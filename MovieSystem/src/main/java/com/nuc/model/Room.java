package com.nuc.model;

/**
 * Created by Jiayiwu on 18/5/6.
 * Mail:wujiayi@lgdreamer.com
 * Change everywhere
 */
public class Room {
    int id;

    int cinemaId;

    String name;

    //JSON存储作为排列
    String sits;

    int status;

    //模板序号
    int modelNum;

    public Room() {
    }

    public Room(int cinemaId, String name, String sits,int modelNum) {
        this.cinemaId = cinemaId;
        this.name = name;
        this.sits = sits;
        this.status = 0;
        this.modelNum = modelNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSits() {
        return sits;
    }

    public void setSits(String sits) {
        this.sits = sits;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getModelNum() {
        return modelNum;
    }

    public void setModelNum(int modelNum) {
        this.modelNum = modelNum;
    }
}
