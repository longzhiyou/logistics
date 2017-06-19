/**
 *
 * Created by longzhiyou on 2016-06-12.
 */

(function(angular){
    "use strict";
    angular.module('app')
        .controller('bmiController', BMIController);
    /* @ngInject */
    function BMIController($state,Restangular,$stateParams){
        var vm = this;
        vm.recordId=$stateParams.recordId;


        function calbmi(height,weight){

            height = height /100;
            return (weight / (height*height)).toFixed(1);


        }

        //获取会员最新处方信息
        var rest = Restangular.one("prescriptions", $stateParams.recordId).all("bmi");
        rest.getList().then(function(bmi) {

            bmi[0].data10=calbmi(bmi[0].data1,bmi[0].data2);
            vm.bmi = bmi;


        });


    }

})(this.angular);