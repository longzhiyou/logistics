/**
 * 配置模块，主要是路由相关.
 *
 * Configures the UI-Router states and their associated URL routes and views
 * Also adds "state-change" reporting for debugging during development
 *
 * Created by longzhiyou on 2016-06-12.
 */
(function(angular){
    "use strict";
    angular.module("app").config(configureStates);

    /* @ngInject */
    function configureStates($stateProvider) {

        $stateProvider
            .state('users',
                {
                    url: '/users',
                    templateUrl: MobilePublic.getServerUrl('app/users/users.html'),
                    controller: 'usersController',
                    controllerAs: 'vm',
                    resolve: {
                        loadPlugin: function ($ocLazyLoad) {
                            return $ocLazyLoad.load([
                                {
                                    files: [MobilePublic.getServerUrl('app/users/usersController.js')]
                                }
                            ]);
                        }
                    }
                })
            .state('user-detail',
                {
                    //url: '/users/:userId',
                    params:{userId:null,name:"llll"},
                    templateUrl: MobilePublic.getServerUrl('app/users/user.html'),
                    controller: 'userController',
                    controllerAs: 'vm',
                    resolve: {
                        loadPlugin: function ($ocLazyLoad) {
                            return $ocLazyLoad.load([
                                {
                                    files: [MobilePublic.getServerUrl('app/users/userController.js')]
                                }
                            ]);
                        }
                    }

                })

        ;
  
    }

})(this.angular);