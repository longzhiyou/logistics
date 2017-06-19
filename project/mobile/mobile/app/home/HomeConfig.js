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
    angular.module("app").config(HomeConfig);

    /* @ngInject */
    function HomeConfig($stateProvider) {

        $stateProvider
            .state('app.health',
                {
                    url: '/health',
                    views: {
                        'tab-home': {
                            templateUrl: MobilePublic.getServerUrl('app/health/Health.html'),
                            controller: 'healthController',
                            controllerAs: 'vm',
                            resolve: {
                                loadPlugin: function ($ocLazyLoad) {
                                    return $ocLazyLoad.load([
                                        {
                                            files: [
                                                MobilePublic.getServerUrl('app/health/HealthConfig.js')
                                                ,MobilePublic.getServerUrl('app/health/HealthController.js')
                                            ]
                                        }
                                    ]);
                                }
                            }

                        }
                    }

                })

        ;
  
    }

})(this.angular);