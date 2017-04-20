/**
 * @author longzhiyou
 * created on 04.15.2017
 */
(function () {
  'use strict';

  angular.module('BlurAdmin.pages.customers', [
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
          url: '',
          templateUrl: 'app/pages/customers/index.html',
          controller: 'indexCtrl',
          controllerAs: 'vm',
          title: '客户一览',
          sidebarMeta: {
              icon: 'ion-grid',
                order: 0
          }
        })
        .state('customers.new', {
            url: '/new',
            templateUrl: 'app/pages/customers/new.html',
            controller: 'newCtrl',
            //controllerAs: 'vm',
            title: '创建客户',
            sidebarMeta: {
                order: 1
            }
        })
        .state('customers.detail', {
            url: '/:id',
            templateUrl: 'app/pages/customers/detail.html',
            controller: 'detailCtrl',
            controllerAs: 'vm',
            title: '详情客户'

        })
        .state('customers.edit', {
            url: '/:id/edit',
            templateUrl: 'app/pages/customers/edit.html',
            controller: 'editCtrl',
            controllerAs: 'vm',
            title: '编辑客户'

        })



    ;
    $urlRouterProvider.when('/customers','/customers/index');
  }

})();
