/**
 * Created by L.H.S on 2017/8/14.
 */

define([], function () {

    'use strict';

    var topnavCtrl = ['$scope', '$state', '$uibModal',
        function ($scope, $state, $uibModal) {
            $scope.menus = {
                url: 'framework/topnav/topnav.tpl.html'
            };

            $scope.navList = [{
                state: 'home',
                text: '电影'
            }, {
                state: 'order',
                text: '订单'
            }];

            $scope.currState = $state;
            $scope.$watch('currState.current.name', function (newValue) {
                if (newValue == 'backend') {
                    $scope.navList = [];
                } else {
                    $scope.navList = [{
                        state: 'home',
                        text: '电影'
                    }, {
                        state: 'order',
                        text: '订单'
                    }];
                }
            });

            $scope.isNavCollapsed = true;
            $scope.isCollapsed = false;
            $scope.isCollapsedHorizontal = false;

            // 判断Menu的子状态激活时，是否需要隶属于其父状态
            $scope.isActived = function (firstLevelState) {
                if (typeof (firstLevelState) !== 'undefined') {
                    var rootState = (firstLevelState + '').split('.');
                    return $state.includes(rootState[0]);
                }
                return false;
            };

            $scope.loginModal = function (type) {

                var role = 0; // 普通用户
                if ($state.current.name === 'backend') {
                    role = 1; // 影院
                }

                var loginModal = $uibModal.open({
                    animation: true,
                    backdrop: 'static',
                    templateUrl: 'framework/topnav/login.html',
                    controller: 'loginCtrl',
                    resolve: {
                        type: function () {
                            return type;
                        },
                        role: function () {
                            return role;
                        }
                    }
                });

                loginModal.result.then(function (data) {

                    var jsonData = {
                        username: data.username,
                        password: data.pwd,
                        type: role
                    };

                    if (role === 0) {  // 普通用户
                        // jsonData.type = 0;
                    } else {  // 影院
                        jsonData.nickname = data.nickname;
                        jsonData.location = data.location;
                        jsonData.telephone = data.telephone;
                    }

                    if (type === 'login') {
                        $.ajax({
                            url: '/user/login',
                            type: 'GET',
                          contentType: "application/x-www-form-urlencoded; charset=utf-8",
                            data: JSON.stringify(jsonData),
                            success: function (resp) {
                                sessionStorage.setItem('username', data.username);
                                sessionStorage.setItem('user', resp);
                                location.reload();
                            },
                            error: function (err) {
                                console.log(err);
                            }
                        });
                    } else {
                        $.ajax({
                            url: '/user/create',
                            type: 'POST',
                            contentType: "application/x-www-form-urlencoded; charset=utf-8",
                            data: jsonData,
                            success: function (resp) {
                                sessionStorage.setItem('username', data.username);
                                sessionStorage.setItem('user', resp);
                                location.reload();
                            },
                            error: function (err) {
                                console.log(err);
                            }
                        });
                    }
                });
            };

            $scope.auth = function () {
                return sessionStorage.getItem('username');
            };

        }];

    return topnavCtrl;
});