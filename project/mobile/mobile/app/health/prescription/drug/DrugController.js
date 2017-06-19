/**
 *
 * Created by longzhiyou on 2016-06-12.
 */

(function(angular){
    "use strict";
    angular.module('app')
        .controller('drugController', DrugController);
    /* @ngInject */
    function DrugController($state,Restangular,$stateParams){
        var vm = this;
        vm.recordId=$stateParams.recordId;


        vm.currentSelect="tips";
        vm.tips=tips;
        vm.management=management;
        vm.note=note;

        function tips(){

            vm.currentSelect="tips";

        }
        function management(){
            vm.currentSelect="management";
        }

        function note(){
            vm.currentSelect="note";
        }


        //获取会员最新处方信息
        var rest = Restangular.one("prescriptions", $stateParams.recordId).all("drugs");
        rest.getList().then(function(drugs) {
            vm.drugs = drugs;
        });


    }

})(this.angular);