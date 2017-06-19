/**
 *
 * Created by longzhiyou on 2016-06-12.
 */

(function(angular){
    "use strict";
    angular.module('app')
        .controller('foodController', FoodController);
    /* @ngInject */
    function FoodController($state,Restangular,$stateParams){
        var vm = this;
        vm.recordId=$stateParams.recordId;

        var rest = Restangular.one("prescriptions", $stateParams.recordId).all("foods");
        rest.getList().then(function(foods) {
            vm.foods = foods;


        });

    }

})(this.angular);