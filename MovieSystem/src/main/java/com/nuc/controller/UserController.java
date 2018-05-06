package com.nuc.controller;

import com.nuc.config.MsgInfo;
import com.nuc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by Jiayiwu on 18/5/6.
 * Mail:wujiayi@lgdreamer.com
 * Change everywhere
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * @param user
     * @return User
     */
    @RequestMapping("/create")
    @ResponseBody
    public MsgInfo createUser(User user){
        return null;
    }

    /**
     * @param user
     * @return User
     */
    @RequestMapping("/modify/info")
    @ResponseBody
    public MsgInfo modifyInfo(User user){
        return null;
    }

    @RequestMapping("/modify/password")
    @ResponseBody
    public MsgInfo modifyPassword(HttpSession session,String password){
        return null;
    }

    /**
     * @param session
     * @return User
     */
    @RequestMapping("/info")
    @ResponseBody
    public MsgInfo getUserInfo(HttpSession session){
        return null;
    }

    /**
     * @param session
     * @param userName
     * @param password
     * @return User
     */
    @RequestMapping("/login")
    @ResponseBody
    public MsgInfo login(HttpSession session,String userName,String password){
        return null;
    }
}
