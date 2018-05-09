/**
 * Created by L.H.S on 2017/8/14.
 */

define([''], function () {
    'use strict';

    var homeCtrl = ['$scope', '$uibModal', '$state', '$timeout',
        function ($scope, $uibModal, $state, $timeout) {

            // 页面标识位
            $scope.currentPage = 'movie';

            // $scope.movieList = [];

            $.ajax({
                url: '/movie/list',
                type: 'GET',
                success: function (resp) {
                    $scope.movieList = resp.object;
                },
                error: function (err) {
                    console.log(err)
                }
            });

            $scope.selectedMovie = '';
            $scope.getDetail = function (item) {
                $scope.currentPage = 'cinema';
                $scope.selectedMovie = item;
                $scope.dateClick($scope.selectedDate);
            };

            function getDateList() {
                var temp = [];
                var today = new Date();
                var nowTs = today.getTime();

                for (var i = 0; i < 7; i++) {
                    temp.push({
                        ts: nowTs + i * 24 * 60 * 60 * 1000,
                        label: (today.getMonth() + 1) + ' 月 ' + (today.getDate() + i)
                    });
                }
                $scope.dateList = temp;
                $scope.selectedDate = temp[0];
            }

            getDateList();

            $scope.dateClick = function (item) {
                $scope.selectedDate = item;

                // 筛选影院
                $.ajax({
                    url: '/cinema/list/time',
                    type: 'GET',
                    data: {
                        movieId: $scope.selectedMovie.id,
                        time: $scope.selectedDate.ts
                    },
                    success: function (resp) {
                        $timeout(function () {
                            $scope.cinemaList = resp.object;
                        })
                    },
                    error: function (err) {
                        console.log(err);
                    }
                })
            };

            // $scope.cinemaList = [];

            $scope.getSessions = function (item) {
                $scope.currentPage = 'session';
                $scope.selectedCinema = item;

                $.ajax({
                    url: '/cinema/arranging/list',
                    type: 'GET',
                    data: {
                        movieId: $scope.selectedMovie.id,
                        cinemaId: item.id
                    },
                    success: function (resp) {
                        $timeout(function () {
                            resp.object.forEach(function (item) {
                                item.startTime = new Date(item.startTime);
                                item.endTime = new Date(item.endTime);
                            })

                            $scope.arrangeList = resp.object;
                        })
                    },
                    error: function (err) {
                        console.log(err);
                    }
                })
            };

            // $scope.arrangeList = [];

            // 购票
            $scope.buyTickets = function (item) {
                $scope.selectedSession = item;
                $scope.currentPage = 'seats';

                // 获取seats
                $.ajax({
                    url: '/cinema/room/info',
                    type: 'GET',
                    data: {
                        roomId: item.roomId
                    },
                    success: function (resp) {
                        $timeout(function () {
                            $scope.seatsArr = resp.object.sits;
                        })
                    },
                    error: function (err) {
                        console.log(err);
                    }
                });
            };

            //0无人，1预定，2过道，3装修, 4已选
            // $scope.seatsArr = [
            //     [0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0],
            //     [0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0],
            //     [0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0],
            //     [0, 0, 0, 0, 2, 1, 1, 0, 0, 0, 0],
            //     [0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0]
            // ];

            $scope.seatClick = function (item, row, index) {
                if (item === 0) {
                    row[index] = 4;
                } else if (item === 4) {
                    row[index] = 0;
                }
            };

            $scope.pay = function () {
                var payModal = $uibModal.open({
                    animation: true,
                    backdrop: 'static',
                    templateUrl: 'business/home/views/pay.html',
                    controller: 'payCtrl'
                });

                payModal.result.then(function () {

                    var data = {
                        roomId: $scope.selectedSession.roomId,
                        movieId: $scope.selectedMovie.id,
                        sits: []
                    };

                    $scope.seatsArr.forEach(function (row, rowIdx) {
                        row.forEach(function (item, colIdx) {
                            if (item === 4) {
                                data.sits.push([rowIdx, colIdx]);
                            }
                        });
                    });

                    data.sits = JSON.stringify(data.sits);

                    // $state.go('order');
                    $.ajax({
                        url: '/order/ticket',
                        type: 'POST',
                        data: data,
                        success: function (resp) {
                            $state.go('order');
                        },
                        error: function (err) {
                            console.log(err);
                        }
                    });

                });
            }

        }

    ];

    var homeModule = angular.module('home.config');
    homeModule.controller('home.ctrl', homeCtrl);

});