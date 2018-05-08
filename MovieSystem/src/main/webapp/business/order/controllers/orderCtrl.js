/**
 * Created by L.H.S on 2017/8/14.
 */

define([''], function () {
    'use strict';

    var orderCtrl = ['$scope', function ($scope) {

        $scope.auth = function () {
            return sessionStorage.getItem('username');
        };

        // $scope.orderList = [];

        $.ajax({
            url: '/order/list',
            type: 'GET',
            success: function (resp) {

                resp.forEach(function (item) {
                    var date = new Date(item.gmt_create);
                    item.date = date.getFullYear() + "-" + (date.getMonth() + 1) + date.getDate() + " " + date.getHours() + ":" + date.getMinutes();
                });
                $scope.orderList = resp;
            },
            error: function (err) {
                console.log(err);
            }
        })

    }

    ];

    var homeModule = angular.module('order.config');
    homeModule.controller('order.ctrl', orderCtrl);

});