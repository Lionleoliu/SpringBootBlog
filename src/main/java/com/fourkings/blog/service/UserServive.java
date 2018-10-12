package com.fourkings.blog.service;

import com.fourkings.blog.po.User;

//需求：定义一个User的登陆接口来通过检查用户名和密码判断是否可以登陆
/*思路：1、定义一个UserService的接口用来定义一个检查登陆的方法，
        2、实现这个接口在此方法里操作数据库
        3、操作数据库需要用到dao层去继承JPARepository的增删改查方法
*/
public interface UserServive {

    User checkUser(String username,String password);
}
