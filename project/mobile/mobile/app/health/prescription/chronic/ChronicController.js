/**
 *
 * Created by longzhiyou on 2016-06-12.
 */

(function(angular){
    "use strict";
    angular.module('app')
        .controller('chronicController', ChronicController);
    /* @ngInject */
    function ChronicController($state,Restangular,$stateParams,$sce){
        var vm = this;
        vm.recordId=$stateParams.recordId;

        //获取会员最新处方信息
        var rest = Restangular.one("prescriptions", $stateParams.recordId).all("chronics");
        rest.getList().then(function(chronics) {
            vm.chronics = chronics;

        });



    }

})(this.angular);