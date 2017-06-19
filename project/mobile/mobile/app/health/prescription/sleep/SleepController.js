/**
 *
 * Created by longzhiyou on 2016-06-12.
 */

(function(angular){
    "use strict";
    angular.module('app')
        .controller('sleepController', SleepController);
    /* @ngInject */
    function SleepController($state,Restangular,$stateParams){
        var vm = this;
        vm.recordId=$stateParams.recordId;



        //获取会员最新处方信息
        var rest = Restangular.one("prescriptions", $stateParams.recordId).all("sleeps");
        rest.getList().then(function(sleeps) {
            vm.sleeps = sleeps;

        });



    }

})(this.angular);