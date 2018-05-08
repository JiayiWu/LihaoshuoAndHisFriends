/**
 * Created by L.H.S on 2017/8/14.
 */

define([''], function () {
    'use strict';

    var backendCtrl = ['$scope', '$uibModal',
        function ($scope, $uibModal) {

            $scope.leftNavs = [{
                id: 'room',
                label: '影厅管理'
            }, {
                id: 'arrange',
                label: '场次管理'
            }
            // , {
            //     id: 'movie',
            //     label: '影片维护'
            // }
            ];

            $scope.currentPage = 'room';

            $scope.changePage = function (item) {
                $scope.currentPage = item.id;
            };

            var template_1 = [
                [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
            ];

            var template_2 = [
                [0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0],
                [0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0],
                [0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0],
                [0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0],
                [0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0]
            ];

            var template_3 = [
                [0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0],
                [0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0],
                [0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0],
                [0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0],
                [0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0]
            ];

            // $scope.roomList = [];

            $.ajax({
                url: '/cinema/room/list',
                type: 'GET',
                success: function (resp) {
                    $scope.roomList = resp.object;
                },
                error: function (err) {
                    console.log(err);
                }
            });

            $scope.addRoom = function () {
                var roomModal = $uibModal.open({
                    animation: true,
                    backdrop: 'static',
                    templateUrl: 'business/backend/views/room.html',
                    controller: 'roomCtrl'
                });

                roomModal.result.then(function (data) {

                    if (data.modelNum == 1) {
                        data.seats = template_1;
                    } else if (data.modelNum == 2) {
                        data.seats = template_2;
                    } else {
                        data.seats = template_3;
                    }

                    $.ajax({
                        url: '/cinema/room/create',
                        type: 'POST',
                        data: data,
                        success: function (resp) {
                            $scope.roomList.push(resp.object);
                        },
                        error: function (err) {
                            console.log(err);
                        }
                    })

                });
            };

            $scope.deleteRoom = function (item, index) {
                $.ajax({
                    url: '/cinema/room/delete',
                    type: 'DELETE',
                    data: {
                        roomId: item.id
                    },
                    success: function () {
                        $scope.roomList.splice(index, 1);
                    },
                    error: function (err) {
                        console.log(err);
                    }
                })
            };

            /** arrange */
            $.ajax({
                url: '/cinema/movie/list',
                type: 'GET',
                success: function (resp) {
                    $scope.arrangeList = resp.object;
                },
                error: function (err) {
                    console.log(err);
                }
            });

            $scope.addArrange = function () {
                var arrangeModal = $uibModal.open({
                    animation: true,
                    backdrop: 'static',
                    templateUrl: 'business/backend/views/arrange.html',
                    controller: 'arrangeCtrl'
                });

                arrangeModal.result.then(function (data) {
                    $.ajax({
                        url: '/cinema/arrange/create',
                        type: 'POST',
                        data: data,
                        success: function (resp) {
                            $scope.arrangeList.push(resp.object);
                        },
                        error: function (err) {
                            console.log(err);
                        }
                    })

                });
            };

            $scope.deleteArrange = function (item, index) {
                $.ajax({
                    url: '/cinema/arrange/delete',
                    type: 'DELETE',
                    data: {
                        id: item.id
                    },
                    success: function () {
                        $scope.arrangeList.splice(index, 1);
                    },
                    error: function (err) {
                        console.log(err);
                    }
                })
            };

            $scope.auth = function () {
                return sessionStorage.getItem('user')
            }
        }
    ];

    var backendModule = angular.module('backend.config');
    backendModule.controller('backend.ctrl', backendCtrl);

});