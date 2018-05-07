package com.nuc.controller;

import com.nuc.config.MsgInfo;
import com.nuc.model.SitPair;
import com.nuc.model.User;
import com.nuc.service.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by Jiayiwu on 18/5/6.
 * Mail:wujiayi@lgdreamer.com
 * Change everywhere
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;
    /**
     * 用户在没付款前调用这个接口下单
     * @param roomId
     * @param movieId
     * @return 返回订单信息 Order
     */
    @RequestMapping("/ticket")
    @ResponseBody
    public MsgInfo orderTicket(HttpSession session,int roomId, int movieId,List<SitPair> sits){
        User user =(User) session.getAttribute("user");
        if (null == user)
            return new MsgInfo(false,"用户未登录");
        return orderService.orderTicket(user.getId(),roomId,movieId,sits);
    }

    /**
     * 弹出二维码后调用这个接口支付订单
     * @param orderId
     * @return Order
     */
    @RequestMapping("/pay")
    @ResponseBody
    public MsgInfo payTicket(int orderId){
        return orderService.payTicket(orderId);
    }

    /**
     * 获取某个用户名下的订单
     * @return List<OrderVo>
     */
    @RequestMapping("/list")
    @ResponseBody
    public MsgInfo getUserOrder(HttpSession session){
        User user =(User) session.getAttribute("user");
        if (null == user)
            return new MsgInfo(false,"用户未登录");
        return orderService.getUserOrder(user.getId());
    }

    /**
     * 删除订单
     * @param orderId
     * @return Boolean true表示成功 false表示失败
     */
    public MsgInfo deleteOrder(int orderId){
        return orderService.deleteOrder(orderId);
    }

}
