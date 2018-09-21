package com.fourkings.blog.web;

import com.fourkings.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//需求：定义一个异常让访问主页的时候返回500的字样
@Controller
public class IndexController {

    @GetMapping(value = "/")
    public String index(){
//        int a = 9/0;
//        String blog = null;
//        if (blog == null){
//            throw new NotFoundException("博客不存在");
//        }
        return "index";
    }

    @GetMapping(value = "/blog")
    public String blog(){
        return "blog";
    }
}
