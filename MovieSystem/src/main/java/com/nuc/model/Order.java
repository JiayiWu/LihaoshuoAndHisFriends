package com.nuc.model;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Jiayiwu on 18/5/6.
 * Mail:wujiayi@lgdreamer.com
 * Change everywhere
 */
public class Order {

    private int id;
    //取票码
    private String ticketNum;

    private Timestamp gmt_create;

    private Timestamp modify_create;

    int userId;

    int cinemaId;

    int movieId;

    int roomId;
    //0未付款，1已付款
    int status;

    String sitPair;

    public Order() {
    }

    public Order(String ticketNum, int userId,
        int cinemaId, int movieId, int roomId, String sitPair) {
        this.ticketNum = ticketNum;
        this.gmt_create = new Timestamp(new Date().getTime());
        ;
        this.modify_create = new Timestamp(new Date().getTime());
        ;
        this.userId = userId;
        this.cinemaId = cinemaId;
        this.movieId = movieId;
        this.roomId = roomId;
        this.sitPair = sitPair;
        this.status = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(String ticketNum) {
        this.ticketNum = ticketNum;
    }

    public Timestamp getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(Timestamp gmt_create) {
        this.gmt_create = gmt_create;
    }

    public Timestamp getModify_create() {
        return modify_create;
    }

    public void setModify_create(Timestamp modify_create) {
        this.modify_create = modify_create;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getSitPair() {
        return sitPair;
    }

    public void setSitPair(String sitPair) {
        this.sitPair = sitPair;
    }
}
