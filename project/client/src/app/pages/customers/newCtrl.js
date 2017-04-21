/**
 * @author lzy
 * created on 2017-04-17
 */
(function () {
  'use strict';

  angular.module('BlurAdmin.pages.customers')
      .controller('newCtrl', newCtrl);

  /** @ngInject */
  function newCtrl($scope,fileReader, $filter, $uibModal, Restangular) {

    //$scope.formData={
    //  name:"",
    //  creditCard:""
    //};
    $scope.formData={

    };
    $scope.create=create;

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
      var fd = new FormData();
      var  jsonStr=  JSON.stringify($scope.formData);
      fd.append('jsonStr', jsonStr);
      fd.append('avatar', $scope.file);


      Restangular.all('customers')
          .withHttpConfig({transformRequest: angular.identity})
          .customPOST(fd, undefined, undefined,
              { 'Content-Type': undefined }).then(function(customers) {
        $state.go('customers.index');

      });
    }

    function init(){
    }
    init();

  }

})();
