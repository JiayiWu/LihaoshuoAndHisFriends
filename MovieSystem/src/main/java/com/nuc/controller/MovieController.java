package com.nuc.controller;

import com.nuc.config.MsgInfo;
import com.nuc.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;

/**
 * Created by Jiayiwu on 18/5/6.
 * Mail:wujiayi@lgdreamer.com
 * Change everywhere
 */
@Controller
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    /**
     * 创建影片
     * @param name
     * @param logoUrl
     * @param description
     * @param type
     * @param timeOfFile
     * @return Boolean true表示创建成功并带上创建的Movie信息，false表示创建失败
     */
    @RequestMapping("/create")
    @ResponseBody
    public MsgInfo createMovie(@RequestParam String name,@RequestParam String logoUrl,@RequestParam String description,@RequestParam String type,@RequestParam int timeOfFile){
        return movieService.createMovie(name,logoUrl,description,type,timeOfFile);
    }

    /**
     * 获取当前所有影片
     * @return Movie
     */
    @RequestMapping("/list")
    @ResponseBody
    public MsgInfo getAllMovie(){
        return movieService.getAllMovie();
    }

    /**
     * 删除排期影片
     * @param id
     * @return Boolean true表示删除成功 false表示失败
     */
    @RequestMapping("/delete")
    @ResponseBody
    public MsgInfo deleteMovie(@RequestParam int id){
        return movieService.deleteMovie(id);
    }

    /**
     * 获取指定影片信息
     * @param id
     * @return Movie
     */
    @RequestMapping("/info")
    @ResponseBody
    public MsgInfo getMovieInfo(@RequestParam int id){
        return movieService.getMovieInfo(id);
    }





}
