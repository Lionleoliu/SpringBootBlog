//需求：定义一个controller如果跳转到admin的网址下就返回admin/login的页面
package com.fourkings.blog.web.admin;

import com.fourkings.blog.po.User;
import com.fourkings.blog.service.UserServive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    UserServive userServive;

    @GetMapping
    public String loginPage(){
        return "admin/login";
    }

    //需求：编写一个Post请求,通过提交username和password，判断user如果存在于数据库的话，
    // 将此用户加入到session中，并返回index页面，如果没有这个会员的话重定向到admin页面
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes redirectAttributes){

        User user = userServive.checkUser(username, password);
        if (user != null){
            user.setPassword(null);
            session.setAttribute("user",user);
            return "admin/index";
        }else
            redirectAttributes.addFlashAttribute("message","用户名和密码错误");
            return "redirect:/admin";
    }

    //编写一个LogOut的Controller，清除掉session里的user信息，然后返回到Login的页面
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/admin";
    }
}
