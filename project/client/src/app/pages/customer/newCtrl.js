/**
 * @author lzy
 * created on 2017-04-17
 */
(function () {
  'use strict';

  angular.module('BlurAdmin.pages.customer')
      .controller('newCtrl', newCtrl);

  /** @ngInject */
  function newCtrl( $scope,fileReader, $filter, $uibModal, Restangular) {

    var vm = this;

    vm.formData={};
    vm.create=create;

    $scope.picture = $filter('profilePicture')('Nasta');

    $scope.removePicture = function () {
      $scope.picture = $filter('appImage')('theme/no-photo.png');
      $scope.noPicture = true;
    };

    $scope.uploadPicture = function () {
      var fileInput = document.getElementById('uploadFile');
      fileInput.click();

    };

    $scope.getFile = function () {
      fileReader.readAsDataUrl($scope.file, $scope)
          .then(function (result) {
            $scope.picture = result;
          });
    };

    function create(){
      Restangular.all('users')
          .withHttpConfig({transformRequest: angular.identity})
          .customPOST(vm.formData, undefined, undefined,
              { 'Content-Type': undefined });
    }

    function init(){
    }
    init();

  }

})();
