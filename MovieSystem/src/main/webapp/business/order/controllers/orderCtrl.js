/**
 * Created by L.H.S on 2017/8/14.
 */

define([''], function () {
    'use strict';

    var orderCtrl = ['$scope', function ($scope) {

            $scope.auth = function () {
                return sessionStorage.getItem('username');
            };

            $scope.futureOrder = [];
            $scope.historyOrder = [];

        }

    ];

    var homeModule = angular.module('order.config');
    homeModule.controller('order.ctrl', orderCtrl);

});