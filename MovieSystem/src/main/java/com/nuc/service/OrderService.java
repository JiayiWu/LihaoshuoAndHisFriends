package com.nuc.service;

import com.nuc.config.MsgInfo;

/**
 * Created by Jiayiwu on 18/5/6.
 * Mail:wujiayi@lgdreamer.com
 * Change everywhere
 */
public interface OrderService {

    public MsgInfo orderTicket(int roomId, int row, int column);

    public MsgInfo payTicket(int orderId);

    public MsgInfo getUserOrder(int userId);

    public MsgInfo deleteOrder(int orderId);
}
