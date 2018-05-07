package com.nuc.service;

import com.nuc.config.MsgInfo;
import com.nuc.model.SitPair;
import java.util.List;

/**
 * Created by Jiayiwu on 18/5/6.
 * Mail:wujiayi@lgdreamer.com
 * Change everywhere
 */
public interface OrderService {

    public MsgInfo orderTicket(int userId,int roomId, int movieId,List<SitPair> sits);

    public MsgInfo payTicket(int orderId);

    public MsgInfo getUserOrder(int userId);

    public MsgInfo deleteOrder(int orderId);
}
