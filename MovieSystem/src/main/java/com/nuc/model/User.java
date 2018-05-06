package com.nuc.model;

/**
 * Created by Jiayiwu on 17/1/15.
 * Mail:wujiayi@lgdreamer.com
 * Change everywhere
 */

public class User {
    private  int id;

    private String username;

    private String nickname;
    /** 地理位置，电影院才需要填写 */
    private String location;

    private String telephone;

    private String password;

    /** 0普通用户，1影院，2系统管理员 维护拍片 */
    private int type;

    public User() {
    }

    public User(String username, String nickname, String location, String telephone, String password, int type) {
        this.username = username;
        this.nickname = nickname;
        this.location = location;
        this.telephone = telephone;
        this.password = password;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
