/**
 * @author longzhiyou
 * created on 04.15.2017
 */
(function () {
  'use strict';

  angular.module('BlurAdmin.pages.customer', [
  ])
    .config(routeConfig);

  /** @ngInject */
  function routeConfig($stateProvider, $urlRouterProvider) {
    $stateProvider
        .state('customers', {
          url: '/customers',
          template : '<ui-view  autoscroll="true" autoscroll-body-top></ui-view>',
          abstract: true,
          title: '客户管理',
          sidebarMeta: {
            icon: 'ion-grid',
            order: 300
          }
        }).state('customers.index', {
          url: '/index',
          templateUrl: 'app/pages/customer/customer.html',
          controller: 'customerCtrl',
          controllerAs: 'vm',
          title: '客户一览',
          sidebarMeta: {
            order: 0
          }
        })
        .state('customers.create', {
        url: '/create',
        templateUrl: 'app/pages/customer/create.html',
        controller: 'createCtrl',
        //controllerAs: 'vm',
        title: '创建客户',
        sidebarMeta: {
            order: 1
            }
        })
    ;
    $urlRouterProvider.when('/customers','/customers/index');
  }

})();
