package com.nuc.controller;

import com.nuc.config.MsgInfo;
import com.nuc.model.User;
import com.nuc.service.CinemaService;
import java.sql.Timestamp;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Jiayiwu on 18/5/6. Mail:wujiayi@lgdreamer.com Change everywhere
 */
@Controller
@RequestMapping("/cinema")
public class CinemaController {


  @Autowired
  CinemaService cinemaService;

  /**
   * 电影院排片
   *
   * @return Boolean true表示创建成功并带上创建的Arranging排片信息，false表示创建失败
   */
  @RequestMapping("/arrange/create")
  @ResponseBody
  public MsgInfo arrangeMovie(HttpSession session, @RequestParam int roomId, @RequestParam int movieId, @RequestParam Timestamp startTime,
      @RequestParam double price) {
    User user = (User) session.getAttribute("cinema");
    if (null != user){
      return new MsgInfo(false,"用户未登录");
    }
    return cinemaService.arrangeMovie(user.getId(), roomId, movieId, startTime, price);
  }

  /**
   * 删除排片
   *
   * @return Boolean true表示删除成功，false表示删除失败
   */
  @RequestMapping("/arrange/delete")
  @ResponseBody
  public MsgInfo deleteArraging(@RequestParam int id) {
    return cinemaService.deleteArraging(id);
  }

  /**
   * 创建影厅
   *
   * @param sits 座位排布 0表示空座位 1表示座位已经被预定 2表示过道 3表示座位在装修
   * @return Boolean true表示创建成功并带上创建的Room信息，false表示创建失败
   */
  @RequestMapping("/room/create")
  @ResponseBody
  public MsgInfo createRoom(HttpSession session, @RequestParam String name, @RequestParam int[][] sits,@RequestParam int modelNum) {

    User user = (User) session.getAttribute("cinema");
    if (null != user){
      return new MsgInfo(false,"用户未登录");
    }
    return cinemaService.createRoom(user.getId(),name,sits,modelNum);
  }

  /**
   * 修改影厅信息
   *
   * @return Boolean true表示修改成功并带上修改的Room信息，false表示修改失败
   */
  @RequestMapping("/room/modify")
  @ResponseBody
  public MsgInfo modifyRoom(@RequestParam int roomId, @RequestParam int[][] sits) {
    return cinemaService.modifyRoom(roomId,sits);
  }

  /**
   * 删除影厅信息
   *
   * @return Boolean true表示删除成功，false表示删除失败
   */
  @RequestMapping("/room/delete")
  @ResponseBody
  public MsgInfo deleteRoom(@RequestParam int roomId) {
    return cinemaService.deleteRoom(roomId);
  }

  /**
   * 返回当前影院有哪些电影厅(后台)
   *
   * @return Room
   */
  @RequestMapping("/room/list")
  @ResponseBody
  public MsgInfo listRoom(HttpSession session) {
    User user = (User) session.getAttribute("cinema");
    if (null != user){
      return new MsgInfo(false,"用户未登录");
    }
    return cinemaService.listRoom(user.getId());
  }

  /**
   * 查找当前影片下面有哪些院线排片
   *
   * @return User(影厅信息)
   */
  @RequestMapping("/list/time")
  @ResponseBody
  public MsgInfo listCinema(@RequestParam int movieId,@RequestParam Timestamp time) {
    return cinemaService.listCinema(movieId,time);
  }

  /**
   * 查找当前影片下面有哪些院线排片
   *
   * @return User(影厅信息)
   */
  @RequestMapping("/list")
  @ResponseBody
  public MsgInfo listCinema(@RequestParam int movieId) {
    return cinemaService.listCinema(movieId);
  }

  /**
   * 查找当前电影院下面指定电影的排片信息
   *
   * @return List<ArrangingMovie>
   */
  @RequestMapping("/arranging/list")
  @ResponseBody
  public MsgInfo listArranging(@RequestParam int movieId, int cinemaId) {
    return cinemaService.listArranging(movieId,cinemaId);
  }

  /**
   * 查找当前电影院下面指定电影的排片信息
   *
   * @return List<ArrangingMovie>
   */
  @RequestMapping("/arranging/cinema")
  @ResponseBody
  public MsgInfo listArranging(HttpSession session){
    User user = (User) session.getAttribute("cinema");
    if (user == null)
      return new MsgInfo(false,"未登录");

    return cinemaService.listArranging(user.getId());
  }

  /**
   * 查找指定厅信息
   *
   * @return RoomVo
   */
  @RequestMapping("/room/info")
  @ResponseBody
  public MsgInfo roomInfo(int roomId) {
    return cinemaService.getRoom(roomId);
  }

  /**
   * 获取当前电影院下排了哪些片
   *
   * @return List<Movie>
   */
  @RequestMapping("/movie/list")
  @ResponseBody
  public MsgInfo getMovieList(HttpSession session) {
    User user = (User) session.getAttribute("cinema");
    if (user == null)
      return new MsgInfo(false,"未登录");
    return cinemaService.getMovieList(user.getId());
  }

}
