package com.nuc.service.impl;

import com.nuc.config.MsgInfo;
import com.nuc.mapper.OrderMapper;
import com.nuc.mapper.RoomMapper;
import com.nuc.model.Order;
import com.nuc.model.Room;
import com.nuc.model.SitPair;
import com.nuc.service.OrderService;
import com.nuc.utils.SitConvertUtil;
import com.nuc.utils.TicketNumGenerator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Jiayiwu on 18/5/6.
 * Mail:wujiayi@lgdreamer.com
 * Change everywhere
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    RoomMapper roomMapper;
    @Autowired
    OrderMapper orderMapper;


    @Override
    @Transactional
    public MsgInfo orderTicket(int userId,int roomId, int movieId,List<SitPair> sits) {
        Room room = roomMapper.getRoomById(roomId);
        Order order = new Order(TicketNumGenerator.generatorTicketNum(room.getCinemaId()),userId,room.getCinemaId(),movieId,roomId,SitConvertUtil.toJsonPair(sits));
        if (orderMapper.insertOrder(order) > 0){

                return payTicket(order.getId());


        }else {
            return new MsgInfo(false,"订单预定失败");
        }
    }

    @Override

    public MsgInfo payTicket(int orderId) {
        Order order = orderMapper.getOrderById(orderId);
        Room room = roomMapper.getRoomById(order.getRoomId());
        boolean isConflict = false;
        int[][]sits = SitConvertUtil.paraseJson(room.getSits());
        List<SitPair> ticketSit = SitConvertUtil.parasePair(order.getSitPair());
        for (SitPair sitPair : ticketSit){
            if (sits[sitPair.getColumn()][sitPair.getRow()] != 0){
                isConflict = true;
                break;
            }else {
                sits[sitPair.getColumn()][sitPair.getRow()] = 1;
            }
        }
        if (!isConflict){
            room.setSits(SitConvertUtil.toJson(sits));
            order.setStatus(1);
            orderMapper.updateOrder(order);
            roomMapper.updateRoom(room);
            return new MsgInfo(true,"订单支付成功",order);
        }else {
            //事务回滚
            throw new RuntimeException();
        }

    }

    @Override
    public MsgInfo getUserOrder(int userId) {
        try {
            return new MsgInfo(true,"获取成功",orderMapper.getOrdersByUserid(userId));
        }catch (Exception e){
            return new MsgInfo(false,"获取失败");
        }

    }

    @Override
    public MsgInfo deleteOrder(int orderId) {
        if (orderMapper.deleteOrder(orderId) > 0){
            return new MsgInfo(true,"订单删除成功");
        }else {
            return new MsgInfo(false,"订单删除失败");
        }
    }
}
