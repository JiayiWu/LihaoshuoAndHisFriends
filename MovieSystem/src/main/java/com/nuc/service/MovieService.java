package com.nuc.service;

import com.nuc.config.MsgInfo;

/**
 * Created by Jiayiwu on 18/5/6.
 * Mail:wujiayi@lgdreamer.com
 * Change everywhere
 */
public interface MovieService {

    public MsgInfo createMovie(String name,String logoUrl,String description,String type,int timeOfFile);

    public MsgInfo getAllMovie();

    public MsgInfo deleteMovie();

    public MsgInfo getMovieInfo();

}
