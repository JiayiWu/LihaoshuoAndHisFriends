/**
 * Created by L.H.S on 2018/5/7.
 */

define([''], function () {
    'use strict';

    var loginCtrl = ['$scope', '$uibModalInstance', 'type', 'role', function ($scope, $uibModalInstance, type, role) {


        $scope.modalType = type;

        $scope.data = {
            username: '',
            pwd: '',
            type: role
        };

        $scope.cancel = function () {
            $uibModalInstance.dismiss(false);
        };

        $scope.ok = function () {
            $uibModalInstance.close($scope.data);
        };


    }];

    return loginCtrl;
});