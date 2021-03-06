package com.nuc.controller;

import com.nuc.config.MsgInfo;
import com.nuc.model.SitPair;
import com.nuc.model.User;
import com.nuc.service.OrderService;

import java.util.ArrayList;
import java.util.List;

import com.nuc.utils.SitConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
     *
     * @param roomId
     * @param movieId
     * @return 返回订单信息 Order
     */
    @RequestMapping("/ticket")
    @ResponseBody
    public MsgInfo orderTicket(HttpSession session, @RequestParam int roomId, @RequestParam int movieId, @RequestParam String sits) {

        List<SitPair> sitPairs = new ArrayList<>();
        int[][] sit = SitConvertUtil.paraseJson(sits);
        for (int i = 0; i < sit.length; i++) {
            sitPairs.add(new SitPair(sit[i][0], sit[i][1]));
        }
        User user = (User) session.getAttribute("user");
        if (null == user)
            return new MsgInfo(false, "用户未登录");
        return orderService.orderTicket(user.getId(), roomId, movieId, sitPairs);
    }

    /**
     * 弹出二维码后调用这个接口支付订单
     *
     * @param orderId
     * @return Order
     */
    @RequestMapping("/pay")
    @ResponseBody
    public MsgInfo payTicket(@RequestParam int orderId) {
        return orderService.payTicket(orderId);
    }

    /**
     * 获取某个用户名下的订单
     *
     * @return List<OrderVo>
     */
    @RequestMapping("/list")
    @ResponseBody
    public MsgInfo getUserOrder(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (null == user)
            return new MsgInfo(false, "用户未登录");
        return orderService.getUserOrder(user.getId());
    }

    /**
     * 删除订单
     *
     * @param orderId
     * @return Boolean true表示成功 false表示失败
     */
    public MsgInfo deleteOrder(@RequestParam int orderId) {
        return orderService.deleteOrder(orderId);
    }

}
