package com.fourkings.blog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//需求：定义一个异常让访问主页的时候返回500的字样
@Controller
public class IndexController {

    @RequestMapping(value = "/")
    public String index(){
        int a = 9/0;
        return "index";
    }
}
