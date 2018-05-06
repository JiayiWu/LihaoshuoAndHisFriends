package com.nuc.controller;

import com.nuc.config.MsgInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public MsgInfo createMovie(String name,String logoUrl,String description,String type,int timeOfFile){
        return null;
    }

    /**
     * 获取当前所有影片
     * @return Movie
     */
    @RequestMapping("/list")
    @ResponseBody
    public MsgInfo getAllMovie(){
        return null;
    }

    /**
     * 删除排期影片
     * @param id
     * @return Boolean true表示删除成功 false表示失败
     */
    @RequestMapping("/delete")
    @ResponseBody
    public MsgInfo deleteMovie(int id){
        return null;
    }

    /**
     * 获取指定影片信息
     * @param id
     * @return Movie
     */
    @RequestMapping("/info")
    @ResponseBody
    public MsgInfo getMovieInfo(int id){
        return null;
    }


}
