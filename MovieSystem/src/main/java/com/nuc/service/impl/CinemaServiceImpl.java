package com.nuc.service.impl;

import com.nuc.config.MsgInfo;
import com.nuc.mapper.ArrangingMapper;
import com.nuc.mapper.MovieMapper;
import com.nuc.mapper.RoomMapper;
import com.nuc.model.Arranging;
import com.nuc.model.Movie;
import com.nuc.model.Room;
import com.nuc.service.CinemaService;
import com.nuc.utils.SitConvertUtil;
import com.nuc.utils.TimeUtil;
import com.nuc.vo.RoomVo;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import org.springframework.stereotype.Service;

/**
 * Created by Jiayiwu on 18/5/6.
 * Mail:wujiayi@lgdreamer.com
 * Change everywhere
 */
@Service
public class CinemaServiceImpl implements CinemaService {

    @Autowired
    ArrangingMapper arrangingMapper;

    @Autowired
    RoomMapper roomMapper;

    @Autowired
    MovieMapper movieMapper;

    @Override
    public MsgInfo arrangeMovie(int cinemaId, int roomId, int movieId, Timestamp startTime, double price) {

        Movie movie = movieMapper.getMovieById(movieId);
        if (null == movie){
            return new MsgInfo(false,"影片信息不存在");
        }
        Timestamp endTime = TimeUtil.increaTime(startTime,movie.getTimeOfMovie());
        Arranging arranging = new Arranging(cinemaId,roomId,movieId,startTime,endTime,price);
        if (arrangingMapper.insertArranging(arranging) > 0){
            return new MsgInfo(true,"排片成功",arranging);
        }else {
            return new MsgInfo(false,"排片错误");
        }
    }

    @Override
    public MsgInfo deleteArraging(int id) {
        if (arrangingMapper.deleteArranging(id) > 0){
            return new MsgInfo(true,"删除成功");
        }else {
            return new MsgInfo(false,"删除失败");
        }
    }

    @Override
    public MsgInfo createRoom(int cinemaId, String name, int[][] sits,int modelNum) {
        Room room = new Room(cinemaId,name, SitConvertUtil.toJson(sits),modelNum);
        if (roomMapper.insertRoom(room) > 0){
            return new MsgInfo(true,"影厅设置成功",room);
        }else {
            return new MsgInfo(false,"影厅设置错误");
        }
    }

    @Override
    public MsgInfo modifyRoom(int roomId, int[][] sits) {
        Room room = roomMapper.getRoomById(roomId);
        if (null == room){
            return new MsgInfo(false,"该影厅不存在");
        }
        room.setSits(SitConvertUtil.toJson(sits));
        if (roomMapper.updateRoom(room) > 0){
            return new MsgInfo(true,"影厅更新成功",room);
        }else {
            return new MsgInfo(false,"影厅更新错误");
        }
    }

    @Override
    public MsgInfo deleteRoom(int roomId) {
        if (roomMapper.deleteRoom(roomId) > 0){
            return new MsgInfo(true,"删除成功");
        }else {
            return new MsgInfo(false,"删除失败");
        }

    }

    @Override
    public MsgInfo listRoom(int cinemaId) {
        try {
            return new MsgInfo(true,"获取成功",roomMapper.getRoomByCinemaId(cinemaId));
        }catch (Exception e){
            return new MsgInfo(false,"获取失败",e);
        }

    }

    @Override
    public MsgInfo listCinema(int movieId) {
            try {
                return new MsgInfo(true,"获取成功",arrangingMapper.getListCinemaByMovieId(movieId));
            }catch (Exception e){
                return new MsgInfo(false,"获取失败");
            }


    }

    @Override
    public MsgInfo listCinema(int movieId, Timestamp timestamp) {
        try {
            return new MsgInfo(true,"获取成功",arrangingMapper.getListCinemaByMovieIdAndTime(movieId,timestamp));
        }catch (Exception e){
            return new MsgInfo(false,"获取失败");
        }
    }

    @Override
    public MsgInfo listArranging(int movieId, int cinemaId) {

        try {
            return new MsgInfo(true,"获取成功",arrangingMapper.getArrangingByMovieIdAndCinemaId(movieId,cinemaId));
        }catch (Exception e){
            return new MsgInfo(false,"获取失败");
        }
    }

    @Override
    public MsgInfo getMovieList(int cinemaId) {
        try {
            return new MsgInfo(true,"获取成功",arrangingMapper.getAllMovieIdByCinemaId(cinemaId));
        }catch (Exception e){
            return new MsgInfo(false,"获取失败");
        }
    }

    @Override
    public MsgInfo getRoom(int roomId) {
        try {
            return new MsgInfo(true,"获取成功",new RoomVo(roomMapper.getRoomById(roomId)));
        }catch (Exception e){
            return new MsgInfo(false,"获取失败");
        }
    }

    @Override
    public MsgInfo listArranging(int cinemaId) {
        try {
            return new MsgInfo(true,"获取成功",arrangingMapper.getListCinemaByMovieId(cinemaId));
        }catch (Exception e){
            return new MsgInfo(false,"获取失败");
        }
    }
}
