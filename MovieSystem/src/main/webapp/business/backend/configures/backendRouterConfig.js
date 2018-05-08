/**
 * Created by L.H.S on 2017/8/14.
 */

define(['lazy-load/lazyLoad'],

    function (lazyLoadModule) {
        'use strict';

        var configArr = [{
            name: 'backend',
            url: '/backend',
            templateUrl: 'business/backend/views/backend.html',
            controller: 'backend.ctrl',
            scripts: {
                controllers: [
                    'business/backend/controllers/backendCtrl',
                    'business/backend/controllers/roomCtrl',
                    'business/backend/controllers/arrangeCtrl'
                ]
            }
        }];

        var backendModule = angular.module('backend.config', ['ui.router']);
        backendModule = lazyLoadModule.makeLazy(backendModule);
        // stateConfig属性配置路由状态基本信息；urlMatch属性配置异常url对应的url路径
        backendModule.StateConfig({
            stateConfig: configArr,
            urlMatch: [['/backend/', '/backend'], ['/backend', '/backend']]
        });

        return backendModule;
    });