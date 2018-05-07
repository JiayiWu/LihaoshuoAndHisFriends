package com.nuc.service.impl;

import com.nuc.config.MsgInfo;
import com.nuc.mapper.MovieMapper;
import com.nuc.model.Movie;
import com.nuc.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jiayiwu on 18/5/6.
 * Mail:wujiayi@lgdreamer.com
 * Change everywhere
 */
@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieMapper movieMapper;

    @Override
    public MsgInfo createMovie(String name, String logoUrl, String description, String type, int timeOfFile) {
        Movie movie = new Movie(name,logoUrl,description,type,timeOfFile);
        if (movieMapper.insertMovie(movie) > 0){
            return new MsgInfo(true,"创建电影成功",movie);
        }else {
            return new MsgInfo(false,"创建电影失败");
        }
    }

    @Override
    public MsgInfo getAllMovie() {
        try {
            return new MsgInfo(true,"获取成功",movieMapper.getAllMovie());
        }catch (Exception e){
            return new MsgInfo(false,"获取失败",e);
        }
    }

    @Override
    public MsgInfo deleteMovie(int id) {
        if (movieMapper.deleteMovie(id) > 0){
            return new MsgInfo(true,"删除电影成功");
        }else {
            return new MsgInfo(false,"删除电影失败");
        }
    }

    @Override
    public MsgInfo getMovieInfo(int id) {
        try {
            return new MsgInfo(true,"获取成功",movieMapper.getMovieById(id));
        }catch (Exception e){
            return new MsgInfo(false,"获取失败",e);
        }
    }
}
