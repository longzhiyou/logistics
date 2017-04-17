/**
 * @author lzy
 * created on 2017-04-17
 */
(function () {
  'use strict';

  angular.module('BlurAdmin.pages.customer')
      .controller('CustomerCreateCtrl', CustomerCreateCtrl);

  /** @ngInject */
  function CustomerCreateCtrl( $scope,fileReader, $filter, $uibModal, Restangular) {

    var vm = this;

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


    function init(){
    }
    init();

  }

})();
