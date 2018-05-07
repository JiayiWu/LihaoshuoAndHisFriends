/**
 * Created by L.H.S on 2017/8/14.
 */

/**
 * 主框架module，该模块依赖于angularjs ng module和tiny wcc module
 * 所有的service router都在这里进行统一的配置
 */

define(['ui-router/angular-ui-router',
        'framework/topnav/topnavCtrl',
        'framework/topnav/loginCtrl',
        'business/home/configures/homeRouterConfig',
        'business/order/configures/orderRouterConfig',
        'business/backend/configures/backendRouterConfig'
    ],
    function (router, topnavCtrl, loginCtrl,
              homeRouterConfig, orderRouterConfig, backendRouterConfig) {
        'use strict';

        // 注入框架的配置文件（新增业务模块在此处添加注册）
        var dependency = [
            'ngAnimate',
            'ngSanitize',
            'ui.bootstrap',
            'ui.router',
            homeRouterConfig.name,
            orderRouterConfig.name,
            backendRouterConfig.name
        ];

        var framework = angular.module('framework', dependency);

        framework.controller('topnavCtrl', topnavCtrl); // 顶部菜单控制器
        framework.controller('loginCtrl', loginCtrl);

        // 初始跳转至首页模块
        framework.config(['$urlRouterProvider', function ($urlRouterProvider) {
            $urlRouterProvider.otherwise('/home');
        }]);

        return framework;
    });
