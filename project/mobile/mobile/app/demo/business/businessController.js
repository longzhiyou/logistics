/**
 *
 * Created by longzhiyou on 2016-06-12.
 */

(function(angular){
    "use strict";
    angular.module('app')
        .controller('businessController', BusinessController);
    /* @ngInject */
    function BusinessController($state){

        var vm = this;
        vm.go = go;
        function go() {
            $state.go('app.dashboard');
        }

    }

})(this.angular);