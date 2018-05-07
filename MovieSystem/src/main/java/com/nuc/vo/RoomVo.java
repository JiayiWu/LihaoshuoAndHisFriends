package com.nuc.vo;

import com.nuc.model.Room;
import com.nuc.utils.SitConvertUtil;

public class RoomVo {

  int id;

  int cinemaId;

  String name;

  //JSON存储作为排列
  int[][] sits;

  int status;

  int modelNum;

  public RoomVo() {
  }

  public RoomVo(Room room) {
    this.id = room.getId();
    this.cinemaId = room.getCinemaId();
    this.name = room.getName();
    this.sits = SitConvertUtil.paraseJson(room.getSits());
    this.status = room.getStatus();
    this.modelNum = room.getModelNum();
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getCinemaId() {
    return cinemaId;
  }

  public void setCinemaId(int cinemaId) {
    this.cinemaId = cinemaId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int[][] getSits() {
    return sits;
  }

  public void setSits(int[][] sits) {
    this.sits = sits;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }
}
