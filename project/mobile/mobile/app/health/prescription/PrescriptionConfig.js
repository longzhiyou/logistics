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
    angular.module("app").config(PrescriptionConfig);

    /* @ngInject */
    function PrescriptionConfig($stateProvider) {

        //八个处方状态
        $stateProvider
            .state('app.prescription-chronic',
                {
                    url: '/health/prescription/:recordId/chronic',
                    views: {
                        'tab-home': {
                            templateUrl: MobilePublic.getServerUrl('app/health/prescription/chronic/Chronic.html'),
                            controller: 'chronicController',
                            controllerAs: 'vm',
                            resolve: {
                                loadPlugin: function ($ocLazyLoad) {
                                    return $ocLazyLoad.load([
                                        {
                                            files: [
                                                MobilePublic.getServerUrl('app/health/prescription/chronic/ChronicController.js')
                                            ]
                                        }
                                    ]);
                                }
                            }
                        }
                    }


                })
            .state('app.prescription-drug',
                {
                    url: '/health/prescription/:recordId/drug',
                    views: {
                        'tab-home': {
                            templateUrl: MobilePublic.getServerUrl('app/health/prescription/drug/Drug.html'),
                            controller: 'drugController',
                            controllerAs: 'vm',
                            resolve: {
                                loadPlugin: function ($ocLazyLoad) {
                                    return $ocLazyLoad.load([
                                        {
                                            files: [
                                                MobilePublic.getServerUrl('app/health/prescription/drug/DrugController.js')
                                            ]
                                        }
                                    ]);
                                }
                            }
                        }
                    }

                })
            .state('app.prescription-sleep',
                {
                    url: '/health/prescription/:recordId/sleep',
                    views: {
                        'tab-home': {
                            templateUrl: MobilePublic.getServerUrl('app/health/prescription/sleep/Sleep.html'),
                            controller: 'sleepController',
                            controllerAs: 'vm',
                            resolve: {
                                loadPlugin: function ($ocLazyLoad) {
                                    return $ocLazyLoad.load([
                                        {
                                            files: [
                                                MobilePublic.getServerUrl('app/health/prescription/sleep/SleepController.js')
                                            ]
                                        }
                                    ]);
                                }
                            }
                        }
                    }

                })
            .state('app.prescription-water',
                {
                    url: '/health/prescription/:recordId/water',
                    views: {
                        'tab-home': {
                            templateUrl: MobilePublic.getServerUrl('app/health/prescription/water/Water.html'),
                            controller: 'waterController',
                            controllerAs: 'vm',
                            resolve: {
                                loadPlugin: function ($ocLazyLoad) {
                                    return $ocLazyLoad.load([
                                        {
                                            files: [
                                                MobilePublic.getServerUrl('app/health/prescription/water/WaterController.js')
                                            ]
                                        }
                                    ]);
                                }
                            }
                        }
                    }

                })
            .state('app.prescription-bmi',
                {
                    url: '/health/prescription/:recordId/bmi',
                    views: {
                        'tab-home': {
                            templateUrl: MobilePublic.getServerUrl('app/health/prescription/bmi/BMI.html'),
                            controller: 'bmiController',
                            controllerAs: 'vm',
                            resolve: {
                                loadPlugin: function ($ocLazyLoad) {
                                    return $ocLazyLoad.load([
                                        {
                                            files: [
                                                MobilePublic.getServerUrl('app/health/prescription/bmi/BMIController.js')
                                            ]
                                        }
                                    ]);
                                }
                            }
                        }
                    }

                })
            .state('app.prescription-sport',
                {
                    url: '/health/prescription/:recordId/sport',
                    views: {
                        'tab-home': {
                            templateUrl: MobilePublic.getServerUrl('app/health/prescription/sport/Sport.html'),
                            controller: 'sportController',
                            controllerAs: 'vm',
                            resolve: {
                                loadPlugin: function ($ocLazyLoad) {
                                    return $ocLazyLoad.load([
                                        {
                                            files: [
                                                MobilePublic.getServerUrl('app/health/prescription/sport/SportController.js')
                                            ]
                                        }
                                    ]);
                                }
                            }
                        }
                    }

                })
            .state('app.prescription-mood',
                {
                    url: '/health/prescription/:recordId/mood',
                    views: {
                        'tab-home': {
                            templateUrl: MobilePublic.getServerUrl('app/health/prescription/mood/Mood.html'),
                            controller: 'moodController',
                            controllerAs: 'vm',
                            resolve: {
                                loadPlugin: function ($ocLazyLoad) {
                                    return $ocLazyLoad.load([
                                        {
                                            files: [
                                                MobilePublic.getServerUrl('app/health/prescription/mood/MoodController.js')
                                            ]
                                        }
                                    ]);
                                }
                            }
                        }
                    }

                })
            .state('app.prescription-food',
                {
                    url: '/health/prescription/:recordId/food',
                    views: {
                        'tab-home': {
                            templateUrl: MobilePublic.getServerUrl('app/health/prescription/food/Food.html'),
                            controller: 'foodController',
                            controllerAs: 'vm',
                            resolve: {
                                loadPlugin: function ($ocLazyLoad) {
                                    return $ocLazyLoad.load([
                                        {
                                            files: [
                                                MobilePublic.getServerUrl('app/health/prescription/food/FoodController.js')
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