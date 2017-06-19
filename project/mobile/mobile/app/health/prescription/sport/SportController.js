/**
 *
 * Created by longzhiyou on 2016-06-12.
 */

(function(angular){
    "use strict";
    angular.module('app')
        .controller('sportController', SportController);
    /* @ngInject */
    function SportController($state,Restangular,$stateParams){
        var vm = this;
        vm.recordId=$stateParams.recordId;

        //获取会员最新处方信息
        var rest = Restangular.one("prescriptions", $stateParams.recordId).all("sports");
        rest.getList().then(function(sports) {

            vm.sports = sports;


        });


    }

})(this.angular);