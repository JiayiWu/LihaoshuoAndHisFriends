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

    public int deleteArranging(int id);

    public Order getOrderById(int id);



}
