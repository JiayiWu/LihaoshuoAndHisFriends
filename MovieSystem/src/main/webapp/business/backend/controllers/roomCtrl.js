/**
 * Created by L.H.S on 2018/5/7.
 */

define([''], function () {
    'use strict';

    var roomCtrl = ['$scope', '$uibModalInstance', function ($scope, $uibModalInstance) {

        $scope.data = {
            name: '',
            modelNum: ''
        };

        $scope.selectTemplate = function (index) {
            $scope.data.modelNum = index;
        };

        $scope.ok = function () {
            $uibModalInstance.close($scope.data);
        };

        $scope.cancel = function () {
            $uibModalInstance.dismiss(false);
        };

    }];

    var backendModule = angular.module('backend.config');
    backendModule.controller('roomCtrl', roomCtrl);
});