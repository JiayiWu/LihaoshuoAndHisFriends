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
@RequestMapping("/cinema")
public class CinemaController {


    /**
     * 电影院排片
     * @param session
     * @param roomId
     * @param movieId
     * @param startTime
     * @param price
     * @return Boolean true表示创建成功并带上创建的Arranging排片信息，false表示创建失败
     */
    @RequestMapping("/arrange/create")
    @ResponseBody
    public MsgInfo arrangeMovie(HttpSession session, int roomId, int movieId, Timestamp startTime, double price){
        return null;
    }

    /**
     * 删除排片
     * @param id
     * @return  Boolean true表示删除成功，false表示删除失败
     */
    @RequestMapping("/arrange/delete")
    @ResponseBody
    public MsgInfo deleteArraging(int id){
        return null;
    }

    /**
     * 创建影厅
     * @param session
     * @param name
     * @param sits 座位排布 0表示空座位 1表示座位已经被预定 2表示过道 3表示座位在装修
     * @return Boolean true表示创建成功并带上创建的Room信息，false表示创建失败
     */
    @RequestMapping("/room/create")
    @ResponseBody
    public MsgInfo createRoom(HttpSession session,String name,int[][] sits){
        return null;
    }

    /**
     * 修改影厅信息
     * @param roomId
     * @param sits
     * @return Boolean true表示修改成功并带上修改的Room信息，false表示修改失败
     */
    @RequestMapping("/room/modify")
    @ResponseBody
    public MsgInfo modifyRoom(int roomId,int[][]sits){
        return null;
    }

    /**
     * 删除影厅信息
     * @param roomId
     * @return  Boolean true表示删除成功，false表示删除失败
     */
    @RequestMapping("/room/delete")
    @ResponseBody
    public MsgInfo deleteRoom(int roomId){
        return null;
    }

    /**
     * 返回当前影院有哪些电影厅(后台)
     * @return Room
     */
    @RequestMapping("/room/list")
    @ResponseBody
    public MsgInfo listRoom(HttpSession session){
        return null;
    }

    /**
     * 查找当前影片下面有哪些院线排片
     * @param movieId
     * @return User(影厅信息)
     */
    @RequestMapping("/list")
    @ResponseBody
    public MsgInfo listCinema(int movieId){
        return null;
    }

    /**
     * 查找当前电影院下面指定电影的排片信息
     * @param movieId
     * @return ArrangingVo
     */
    @RequestMapping("/arranging/list")
    @ResponseBody
    public MsgInfo listArranging(int movieId,int cinemaId){
        return null;
    }

    /**
     * 获取当前电影院下排了哪些片，用户后台管理
     * @return List<Movie>
     */
    @RequestMapping("/movie/list")
    @ResponseBody
    public MsgInfo getMovieList(HttpSession session){
        return null;
    }

}
