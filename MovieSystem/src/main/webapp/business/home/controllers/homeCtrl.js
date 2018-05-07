/**
 * Created by L.H.S on 2017/8/14.
 */

define([''], function () {
    'use strict';

    var homeCtrl = ['$scope', '$uibModal',
        function ($scope, $uibModal) {

            // 页面标识位
            $scope.currentPage = 'movie';

            // $scope.movieList = [];

            $.ajax({
                url: '/movie/list',
                type: 'GET',
                success: function (resp) {
                    $scope.movieList = resp;
                },
                error: function (err) {
                    console.log(err)
                }
            });

            $scope.selectedMovie = '';
            $scope.getDetail = function (item) {
                $scope.currentPage = 'cinema';
                $scope.selectedMovie = item;
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
                    url: '/cinema/list',
                    type: 'GET',
                    data: {
                        movieId: $scope.selectedMovie.id
                    },
                    success:function (resp) {
                        $scope.cinemaList = resp
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
                    success:function (resp) {
                        $scope.arrangeList = resp
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
            };

            //0无人，1预定，2过道，3装修, 4已选
            $scope.seatsArr = [
                [0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0],
                [0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0],
                [0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0],
                [0, 0, 0, 0, 2, 1, 1, 0, 0, 0, 0],
                [0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0]
            ];

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

                });
            }

        }

    ];

    var homeModule = angular.module('home.config');
    homeModule.controller('home.ctrl', homeCtrl);

});