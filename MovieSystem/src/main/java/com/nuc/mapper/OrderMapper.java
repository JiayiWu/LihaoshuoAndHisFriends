package com.nuc.mapper;

import com.nuc.model.Arranging;
import com.nuc.model.Order;

import java.util.List;

/**
 * Created by Jiayiwu on 18/5/6.
 * Mail:wujiayi@lgdreamer.com
 * Change everywhere
 */
public interface OrderMapper {

    public int insertOrder(Order order);

    public int updateOrder(Order order);

    public int deleteOrder(int id);

    public Order getOrderById(int id);

    public List<Order> getOrdersByUserid(int userId);



}
