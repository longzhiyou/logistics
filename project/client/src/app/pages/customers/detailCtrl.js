/**
 * @author lzy
 * created on 2017-04-17
 */
(function () {
  'use strict';

  angular.module('BlurAdmin.pages.customers')
      .controller('detailCtrl', detailCtrl);

  /** @ngInject */
  function detailCtrl($stateParams) {

    var vm = this;
    vm.id=$stateParams.id;

    function init(){

    }
    init();

  }

})();
