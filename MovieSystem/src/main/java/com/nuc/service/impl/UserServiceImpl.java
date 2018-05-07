package com.nuc.service.impl;

import com.nuc.config.MsgInfo;
import com.nuc.mapper.UserMapper;
import com.nuc.model.User;
import com.nuc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jiayiwu on 18/5/6.
 * Mail:wujiayi@lgdreamer.com
 * Change everywhere
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public MsgInfo createUser(User user) {
        if (userMapper.insertUser(user) > 0){
            return new MsgInfo(true,"创建角色成功",user);
        }else {
            return new MsgInfo(false,"排片错误");
        }
    }

    @Override
    public MsgInfo modifyInfo(User user) {
        if (userMapper.updateUser(user) > 0){
            return new MsgInfo(true,"创建角色成功",user);
        }else {
            return new MsgInfo(false,"排片错误");
        }
    }

    @Override
    public MsgInfo modifyPassword(int userId, String password) {
        if (userMapper.resetPass(userId,password) > 0){
            return new MsgInfo(true,"密码修改成功");
        }else {
            return new MsgInfo(false,"排片错误");
        }

    }

    @Override
    public MsgInfo login(String userName, String password) {
       User user = userMapper.getUserByUsername(userName);
       if (user.getPassword().equals(password)){
           return new MsgInfo(true,"登录成功",user);
       }else {
           return new MsgInfo(false,"登录失败");
       }
    }
}
