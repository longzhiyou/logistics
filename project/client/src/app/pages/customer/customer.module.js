/**
 * @author longzhiyou
 * created on 04.15.2017
 */
(function () {
  'use strict';

  angular.module('BlurAdmin.pages.customer', [])
    .config(routeConfig);

  /** @ngInject */
  function routeConfig($stateProvider, $urlRouterProvider) {
    $stateProvider
        .state('customerManager', {
          url: '/customers',
          template : '<ui-view  autoscroll="true" autoscroll-body-top></ui-view>',
          abstract: true,
          //controller: 'CustomerCtrl',
          title: '客户管理',
          sidebarMeta: {
            icon: 'ion-grid',
            order: 300
          }
        }).state('customerManager.customers', {
          url: '/index',
          templateUrl: 'app/pages/customer/customer.html',
          controller: 'CustomerCtrl',
          controllerAs: 'vm',
          title: '客户一览',
          sidebarMeta: {
            order: 0
          }
        });
    $urlRouterProvider.when('/customers','/customers/index');
  }

})();
