/**
 * @author lzy
 * created on 2017-04-17
 */
(function () {
  'use strict';

  angular.module('BlurAdmin.pages.customers')
      .controller('editCtrl', editCtrl);

  /** @ngInject */
  function editCtrl($stateParams) {

    var vm = this;
    vm.id=$stateParams.id;

    function init(){

    }
    init();

  }

})();
