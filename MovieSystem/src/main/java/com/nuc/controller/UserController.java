package com.nuc.controller;

import com.nuc.config.MsgInfo;
import com.nuc.model.User;
import com.nuc.service.UserService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Jiayiwu on 18/5/6. Mail:wujiayi@lgdreamer.com Change everywhere
 */
@Controller
@RequestMapping("/user")
public class UserController {

  @Autowired
  UserService userService;

  /**
   * @return User
   */
  @RequestMapping("/create")
  @ResponseBody
  public MsgInfo createUser(String username,String nickname,String location,String telephone,String password,int type) {
    User user = new User(username,nickname,location,telephone,password,type);
    return userService.createUser(user);
  }

  /**
   * @return User
   */
  @RequestMapping("/modify/info")
  @ResponseBody
  public MsgInfo modifyInfo(int id,String username,String nickname,String location,String telephone,String password,int type) {
    User user = new User(username,nickname,location,telephone,password,type);
    user.setId(id);
    return userService.modifyInfo(user);
  }

  @RequestMapping("/modify/password")
  @ResponseBody
  public MsgInfo modifyPassword(HttpSession session, String oldPassword, String password) {
    User user = (User) session.getAttribute("user");
    if (!user.getPassword().equals(oldPassword)) {
      return new MsgInfo(false, "原密码错误");
    }
    MsgInfo msgInfo = userService.modifyPassword(user.getId(), password);
    if (msgInfo.getStatus()) {
      user.setPassword(password);
      changeSession(session, user);
    }
    return msgInfo;
  }

  /**
   * @return User
   */
  @RequestMapping("/info")
  @ResponseBody
  public MsgInfo getUserInfo(HttpSession session) {

    User user = (User) session.getAttribute("user");
    if (user == null){
      user = (User) session.getAttribute("cinema");
      if (user == null){
        user = (User) session.getAttribute("admin");
      }
    }
    return new MsgInfo(true,"获取成功",user);
  }

  /**
   * @return User
   */
  @RequestMapping("/login")
  @ResponseBody
  public MsgInfo login(HttpSession session, String userName, String password) {
    MsgInfo msgInfo = userService.login(userName,password);
    if (msgInfo.getStatus()){
      changeSession(session,(User) msgInfo.getObject());
    }
    return msgInfo;
  }

  private void changeSession(HttpSession session, User user) {
    if (user.getType() == 0) {
      session.setAttribute("user", user);
    } else if (user.getType() == 1) {
      session.setAttribute("cinema", user);
    } else {
      session.setAttribute("admin", user);
    }
  }
}
