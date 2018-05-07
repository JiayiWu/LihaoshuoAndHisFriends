package com.nuc.mapper;

import com.nuc.model.Arranging;
import com.nuc.model.Movie;

import java.util.List;

/**
 * Created by Jiayiwu on 17/2/16.
 * Mail:wujiayi@lgdreamer.com
 * Change everywhere
 */
public interface MovieMapper {

    public int insertMovie(Movie movie);

    public int updateMovie(Movie movie);

    public Movie getMovieById(int id);

    public int deleteMovie(int id);

    public List<Movie> getAllMovie();


}
