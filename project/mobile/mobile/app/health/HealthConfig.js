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
    angular.module("app").config(HealthConfig);

    /* @ngInject */
    function HealthConfig($stateProvider) {

        $stateProvider
            .state('app.health.evaluate',
                {
                    url: '/evaluate',
                    views: {
                        'tab-home': {
                            templateUrl: MobilePublic.getServerUrl('app/health/evaluate/Evaluate.html')
                        }
                    }

                })
            .state('app.health.prescription',
                {
                    url: '/prescription/:recordId',
                    templateUrl: MobilePublic.getServerUrl('app/health/prescription/Prescription.html'),
                    controller: 'prescriptionController',
                    controllerAs: 'vm',
                    resolve: {
                        loadPlugin: function ($ocLazyLoad) {
                            return $ocLazyLoad.load([
                                {
                                    files: [
                                        MobilePublic.getServerUrl('app/health/prescription/PrescriptionConfig.js')
                                        ,MobilePublic.getServerUrl('app/health/prescription/PrescriptionController.js')
                                    ]
                                }
                            ]);
                        }
                    }
                })

        ;
  
    }

})(this.angular);