/**
 *
 * Created by longzhiyou on 2016-06-12.
 */

(function(angular){
    "use strict";
    angular.module('app')
        .controller('accountController', AccountController);
    /* @ngInject */
    function AccountController($state,auth,Restangular){
        var vm = this;
        vm.clear = clear;

        function clear() {
            auth.clear();

        }

    }

})(this.angular);