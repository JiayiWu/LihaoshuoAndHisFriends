package com.nuc.controller;

import com.nuc.config.MsgInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Jiayiwu on 18/5/6.
 * Mail:wujiayi@lgdreamer.com
 * Change everywhere
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    /**
     * 用户在没付款前调用这个接口下单
     * @param roomId
     * @param row
     * @param column
     * @return 返回订单信息 Order
     */
    @RequestMapping("/ticket")
    @ResponseBody
    public MsgInfo orderTicket(int roomId, int row, int column){
        return null;
    }

    /**
     * 弹出二维码后调用这个接口支付订单
     * @param orderId
     * @return Order
     */
    @RequestMapping("/pay")
    @ResponseBody
    public MsgInfo payTicket(int orderId){
        return null;
    }

    /**
     * 获取某个用户名下的订单
     * @param userId
     * @return List<OrderVo>
     */
    @RequestMapping("/list")
    @ResponseBody
    public MsgInfo getUserOrder(int userId){
        return null;
    }

    /**
     * 删除订单
     * @param orderId
     * @return Boolean true表示成功 false表示失败
     */
    public MsgInfo deleteOrder(int orderId){
        return null;
    }

}
