package com.nuc.mapper;

import com.nuc.model.Room;

import java.util.List;

/**
 * Created by Jiayiwu on 18/5/6.
 * Mail:wujiayi@lgdreamer.com
 * Change everywhere
 */
public interface RoomMapper {

    public int insertRoom(Room room);

    public int updateRoom(Room room);

    public int deleteRoom(int id);

    public Room getRoomById(int id);

    public List<Room> getRoomByCinemaId(int cinemaId);

}
