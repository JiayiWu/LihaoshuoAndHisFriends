package com.nuc.mapper;

import com.nuc.model.Arranging;
import com.nuc.model.User;

import java.util.List;

/**
 * Created by Jiayiwu on 17/2/16.
 * Mail:wujiayi@lgdreamer.com
 * Change everywhere
 */
public interface ArrangingMapper {

    public int insertArranging(Arranging arranging);

    public int updateArranging(Arranging arranging);
    
    public List<Arranging> getArrangingByMovieIdAndCinemaId(int movieId, int cinemaId );

    public int deleteArranging(int id);

    public Arranging getArrangingById(int id);

    public int[] getAllMovieIdByCinemaId(int cinemaId);

}
