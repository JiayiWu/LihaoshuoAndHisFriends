/**
 * Created by L.H.S on 2017/8/14.
 */

define(['lazy-load/lazyLoad'],

    function (lazyLoadModule) {
        'use strict';

        var configArr = [{
            name: 'order',
            url: '/order',
            templateUrl: 'business/order/views/order.html',
            controller: 'order.ctrl',
            scripts: {
                controllers: ['business/order/controllers/orderCtrl']
            }
        }];

        var orderModule = angular.module('order.config', ['ui.router']);
        orderModule = lazyLoadModule.makeLazy(orderModule);
        // stateConfig属性配置路由状态基本信息；urlMatch属性配置异常url对应的url路径
        orderModule.StateConfig({
            stateConfig: configArr,
            urlMatch: [['/order/', '/order'], ['/order', '/order']]
        });

        return orderModule;
    });