/**
 * Created by L.H.S on 2017/8/14.
 */

define([''], function () {
    'use strict';

    var homeCtrl = ['$scope',
        function ($scope) {

            $scope.movieList = [{
                name: '后来的我们',
                logoUrl: ''
            }];

        }

    ];

    var homeModule = angular.module('home.config');
    homeModule.controller('home.ctrl', homeCtrl);

});