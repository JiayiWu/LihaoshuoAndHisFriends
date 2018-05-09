/**
 * Created by L.H.S on 2018/5/7.
 */

define([''], function () {
    'use strict';

    var arrangeCtrl = ['$scope', '$uibModalInstance', function ($scope, $uibModalInstance) {

        $scope.data = {
            movieId: '',
            roomId: '',
            startTime: '',
            price: ''
        };

        $scope.movieOpts = {
            selectedObj: '',
            options: [],
            select: function (op) {
                $scope.data.movieId = op.id;
                $scope.movieOpts.selectedObj = op;
            }
        };

        $.ajax({
            url: '/movie/list',
            type: 'GET',
            success: function (resp) {
                $scope.movieOpts.options = resp.object;
            },
            error: function (err) {
                console.log(err);
            }
        });

        $scope.roomOpts = {
            selectedObj: '',
            options: [],
            select: function (op) {
                $scope.data.roomId = op.id;
                $scope.roomOpts.selectedObj = op;
            }
        };

        $.ajax({
            url: '/cinema/room/list',
            type: 'GET',
            success: function (resp) {
                $scope.roomOpts.options = resp.object;
            },
            error: function (err) {
                console.log(err);
            }
        });

        $scope.ok = function () {
            var data = angular.copy($scope.data);
            data.startTime = new Date(data.startTime).getTime();
            $uibModalInstance.close(data, $scope.movieOpts.selectedObj.name, $scope.roomOpts.selectedObj.name);
        };

        $scope.cancel = function () {
            $uibModalInstance.dismiss(false);
        };

    }];

    var backendModule = angular.module('backend.config');
    backendModule.controller('arrangeCtrl', arrangeCtrl);
});