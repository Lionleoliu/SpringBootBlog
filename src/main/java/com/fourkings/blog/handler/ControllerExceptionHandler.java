package com.fourkings.blog.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

//需求：写一个获取异常信息并返回error的HTML页面的方法
@ControllerAdvice
public class ControllerExceptionHandler {

    //获取log对象
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //定义一个异常处理方法,返回一个ModelAndView对象，获取请求和异常信息
    @ExceptionHandler(Exception.class)
    public ModelAndView ExceptionHandler(HttpServletRequest request,Exception e ){
        //打印出error的异常信息，异常来自那个url，抛出的哪个异常
        logger.error("Request url :{}, Exception : {}",request.getRequestURL(),e);

        ModelAndView mv = new ModelAndView();
        mv.addObject("url",request.getRequestURL());
        mv.addObject("exception",e);
        mv.setViewName("error/error");
        return mv;
    }
}
