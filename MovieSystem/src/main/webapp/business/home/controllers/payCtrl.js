/**
 * Created by L.H.S on 2018/5/7.
 */

define([''], function () {
    'use strict';

    var payCtrl = ['$scope', '$uibModalInstance', function ($scope, $uibModalInstance) {

        $scope.ok = function () {
            $uibModalInstance.close();
        }

        $scope.cancel = function () {
            $uibModalInstance.dismiss(false);
        };

    }];

    var homeModule = angular.module('home.config');
    homeModule.controller('payCtrl', payCtrl);
});