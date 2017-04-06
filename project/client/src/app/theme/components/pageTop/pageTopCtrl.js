/**
 * @author v.lugovksy
 * created on 16.12.2015
 */
(function () {
  'use strict';

  angular.module('BlurAdmin.theme.components')
      .controller('pageTopCtrl', pageTopCtrl);

  /** @ngInject */
  function pageTopCtrl($scope, $window,$timeout, $element) {
    $scope.startSearch= startSearch;
    $scope.logout= logout;

    function startSearch(){
      alert("startSearch");
    }

    function logout(){

      //alert("logout");
      localStorage.removeItem("token");
      var landingUrl = "http://" + $window.location.host + "/auth.html";
      $window.location.href = landingUrl;
    }


  }

})();