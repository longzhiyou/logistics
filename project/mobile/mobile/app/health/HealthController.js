/**
 *
 * Created by longzhiyou on 2016-06-12.
 */

(function(angular){
    "use strict";
    angular.module('app')
        .controller('healthController', HealthController);
    /* @ngInject */
    function HealthController(auth,$state,Restangular,$ionicHistory){
        var vm = this;

        vm.currentSelect="";
        vm.prescription=prescription;
        vm.select2=select1;
        vm.select3=select3;


        function prescription(){
            //获取会员最新处方信息
            var rest = Restangular.one("members", auth.getObject("account").id).all("prescriptions");
            rest.getList().then(function(prescriptions) {
                if (prescriptions.length>0) {
                    vm.currentSelect="prescription";
                    $ionicHistory.currentView($ionicHistory.backView());
                    $state.go('app.health.prescription',{recordId:prescriptions[0].recordId});
                }else {
                    alert("没有发布")
                }

            });
        }
        function select1(){
            vm.currentSelect="select1";
        }
        function select3(){
            vm.currentSelect="select3";
        }

    }

})(this.angular);