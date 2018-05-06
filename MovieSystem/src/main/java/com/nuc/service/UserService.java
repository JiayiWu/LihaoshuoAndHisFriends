package com.nuc.service;

import com.nuc.config.MsgInfo;
import com.nuc.model.User;

/**
 * Created by Jiayiwu on 18/5/6.
 * Mail:wujiayi@lgdreamer.com
 * Change everywhere
 */
public interface UserService {


    public MsgInfo createUser(User user);


    public MsgInfo modifyInfo(User user);


    public MsgInfo modifyPassword(int userId,String password);


    public MsgInfo login(String userName,String password);

}
