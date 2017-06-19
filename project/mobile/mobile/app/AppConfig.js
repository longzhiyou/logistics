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
    angular.module("app").config(AppConfig);

    /* @ngInject */
    function AppConfig( $urlRouterProvider
                        ,$stateProvider
                        ,$ionicConfigProvider
                        ,RestangularProvider
                        ,setting
                              ) {

        $urlRouterProvider.otherwise( function($injector, $location) {
            var $state = $injector.get("$state");
            $state.go("app.home");
        });


        //$urlRouterProvider.otherwise('/app/home');       // Return to the login ordering screen
        //调试状态禁止缓存
        //$ionicConfigProvider.views.maxCache(0);
        RestangularProvider.setBaseUrl(MobilePublic.Api);
        //$ionicConfigProvider.platform.ios.tabs.style('standard');
        //$ionicConfigProvider.platform.ios.tabs.position('bottom');
        //$ionicConfigProvider.platform.ios.navBar.alignTitle('center');
        //$ionicConfigProvider.platform.ios.backButton.previousTitleText('').icon('ion-ios-arrow-thin-left');
        //$ionicConfigProvider.platform.ios.views.transition('ios');
        //
        //$ionicConfigProvider.platform.android.tabs.style('standard');
        $ionicConfigProvider.platform.android.tabs.position('bottom');
        $ionicConfigProvider.platform.android.navBar.alignTitle('center');
        //$ionicConfigProvider.platform.android.backButton.previousTitleText('').icon('ion-android-arrow-back');
        //$ionicConfigProvider.platform.android.views.transition('android');


        $stateProvider
            .state('login',
                {
                    url: '/login',
                    templateUrl: MobilePublic.getServerUrl('app/login/Login.html'),
                    controller: 'loginController',
                    controllerAs: 'vm',
                    resolve: {
                        loadPlugin: function ($ocLazyLoad) {
                            return $ocLazyLoad.load([
                                {
                                    files: [MobilePublic.getServerUrl('app/login/LoginController.js')]
                                }
                            ]);
                        }
                    }

                })

            // setup an abstract state for the tabs directive
            .state('app',
                {
                    url: '/app',
                    abstract: true,
                    templateUrl: MobilePublic.getServerUrl('app/layout/Layout.html'),
                    resolve: {
                        loadPlugin: function ($ocLazyLoad) {
                            return $ocLazyLoad.load([
                                {
                                    files: [MobilePublic.getServerUrl('app/layout/LayoutController.js')]
                                }
                            ]);
                        }
                    }


                })
            // Each tab has its own nav history stack:
            .state('app.home',
                {
                    url: '/home',
                    views: {
                        'tab-home': {
                            templateUrl: MobilePublic.getServerUrl('app/home/Home.html'),
                            controller: 'homeController',
                            controllerAs: 'vm',
                            resolve: {
                                loadPlugin: function ($ocLazyLoad) {
                                    return $ocLazyLoad.load([
                                        {
                                            files: [
                                                MobilePublic.getServerUrl('app/home/HomeConfig.js')
                                                ,MobilePublic.getServerUrl('app/home/HomeController.js')
                                            ]
                                        }
                                    ]);
                                }
                            }
                        }
                    }
                })

            .state('app.account',
                {
                    url: '/account',
                    views: {
                        'tab-account': {
                            templateUrl: MobilePublic.getServerUrl('app/account/Account.html'),
                            controller: 'accountController',
                            controllerAs: 'vm',
                            resolve: {
                                loadPlugin: function ($ocLazyLoad) {
                                    return $ocLazyLoad.load([
                                        {
                                            files: [
                                                MobilePublic.getServerUrl('app/account/AccountController.js')
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