package com.nuc.mapper;

import com.nuc.model.Arranging;
import com.nuc.model.ArrangingMovie;
import com.nuc.model.Movie;
import com.nuc.model.User;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Jiayiwu on 17/2/16.
 * Mail:wujiayi@lgdreamer.com
 * Change everywhere
 */
public interface ArrangingMapper {

    public int insertArranging(Arranging arranging);

    public int updateArranging(Arranging arranging);
    
    public List<ArrangingMovie> getArrangingByMovieIdAndCinemaId(int movieId, int cinemaId );

    public List<ArrangingMovie> getArrangingByCinemaId(int cinemaId );

    public int deleteArranging(int id);

    public Arranging getArrangingById(int id);

    public List<User> getListCinemaByMovieId(int movie);

    public List<User> getListCinemaByMovieIdAndTime(int movie,Timestamp timestamp);

    public List<Movie> getAllMovieIdByCinemaId(int cinemaId);

}
