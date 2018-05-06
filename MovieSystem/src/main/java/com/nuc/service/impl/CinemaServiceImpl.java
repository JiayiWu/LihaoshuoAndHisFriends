package com.nuc.service.impl;

import com.nuc.config.MsgInfo;
import com.nuc.service.CinemaService;

import java.sql.Timestamp;

/**
 * Created by Jiayiwu on 18/5/6.
 * Mail:wujiayi@lgdreamer.com
 * Change everywhere
 */
public class CinemaServiceImpl implements CinemaService {

    @Override
    public MsgInfo arrangeMovie(int cinemaId, int roomId, int movieId, Timestamp startTime, double price) {
        return null;
    }

    @Override
    public MsgInfo deleteArraging(int id) {
        return null;
    }

    @Override
    public MsgInfo createRoom(int cinemaId, String name, int[][] sits) {
        return null;
    }

    @Override
    public MsgInfo modifyRoom(int roomId, int[][] sits) {
        return null;
    }

    @Override
    public MsgInfo deleteRoom(int roomId) {
        return null;
    }

    @Override
    public MsgInfo listRoom(int cinemaId) {
        return null;
    }

    @Override
    public MsgInfo listCinema(int movieId) {
        return null;
    }

    @Override
    public MsgInfo listArranging(int movieId, int cinemaId) {
        return null;
    }

    @Override
    public MsgInfo getMovieList(int cinemaId) {
        return null;
    }
}
