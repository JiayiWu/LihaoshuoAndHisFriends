/**
 * Created by L.H.S on 2017/8/14.
 */

define([''], function () {
    'use strict';

    var backendCtrl = ['$scope',
        function ($scope) {

            $scope.leftNavs = [{
                id: 'room',
                label: '影厅管理'
            }, {
                id: 'arrange',
                label: '场次管理'
            }, {
                id: 'movie',
                label: '影片维护'
            }];

            $scope.currentPage = 'room';

            $scope.changePage = function (item) {
                $scope.currentPage = item.id;
            };

            $scope.auth = function () {
                return sessionStorage.getItem('user')
            }
        }
    ];

    var backendModule = angular.module('backend.config');
    backendModule.controller('backend.ctrl', backendCtrl);

});