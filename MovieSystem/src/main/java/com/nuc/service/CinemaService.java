package com.nuc.service;

import com.nuc.config.MsgInfo;

import java.sql.Timestamp;

/**
 * Created by Jiayiwu on 18/5/6.
 * Mail:wujiayi@lgdreamer.com
 * Change everywhere
 */
public interface CinemaService {

    public MsgInfo arrangeMovie(int cinemaId,int roomId, int movieId, Timestamp startTime, double price);

    public MsgInfo deleteArraging(int id);

    public MsgInfo createRoom(int cinemaId,String name,int[][] sits);

    public MsgInfo modifyRoom(int roomId,int[][]sits);

    public MsgInfo deleteRoom(int roomId);

    public MsgInfo listRoom(int cinemaId);

    public MsgInfo listCinema(int movieId);

    public MsgInfo listArranging(int movieId,int cinemaId);

    public MsgInfo getMovieList(int cinemaId);
}
