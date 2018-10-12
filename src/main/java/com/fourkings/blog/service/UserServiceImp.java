package com.fourkings.blog.service;

import com.fourkings.blog.dao.UserRepository;
import com.fourkings.blog.po.User;
import com.fourkings.blog.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserServive {

    @Autowired
    UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {
        //操作数据库
        User user = userRepository.findByUsernameAndPassword(username,MD5Utils.code(password));
        return user;
    }
}
