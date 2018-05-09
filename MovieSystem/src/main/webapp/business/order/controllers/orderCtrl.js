/**
 * Created by L.H.S on 2017/8/14.
 */

define([''], function () {
    'use strict';

    var orderCtrl = ['$scope', '$timeout', function ($scope, $timeout) {

        $scope.auth = function () {
            return sessionStorage.getItem('username');
        };

        $scope.orderList = [{
            movieName: '复仇者联盟3',
            cinemaName: '大爷影城',
            cinemaLocation: '南京鼓楼',
            ticketNum: '234130',
            roomName: '2号厅',
            date: '2018-05-09 4:00'
        }];

        $.ajax({
            url: '/order/list',
            type: 'GET',
            success: function (resp) {

                resp.object.forEach(function (item) {
                    var date = new Date(item.gmt_create);
                    item.date = date.getFullYear() + "-" + (date.getMonth() + 1) + date.getDate() + " " + date.getHours() + ":" + date.getMinutes();
                });
                $timeout(function () {
                    // $scope.orderList = resp.object;
                })
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