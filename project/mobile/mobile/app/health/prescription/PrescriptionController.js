/**
 *
 * Created by longzhiyou on 2016-06-12.
 */

(function(angular){
    "use strict";
    angular.module('app')
        .controller('prescriptionController', PrescriptionController);
    /* @ngInject */
    function PrescriptionController($state,Restangular,$stateParams,setting){
        var vm = this;

        vm.recordId=$stateParams.recordId;

        vm.menus=setting.prescriptionMenus;


    }

})(this.angular);