/**
 *
 * Created by longzhiyou on 2016-06-12.
 */

(function(angular){
    "use strict";
    angular.module('app')
        .controller('loginController', LoginController);
    /* @ngInject */
    function LoginController($state,auth){

        var vm = this;
        vm.login = login;
        vm.error = false;
        vm.credentials={};
        function login() {


             auth.authenticate(vm.credentials, function(authenticated) {
             	if (authenticated) {
             		console.log("Login succeeded");
             		vm.error = false;

                    $state.go('app.home');
             	} else {
             		console.log("Login failed");
             		vm.error = true;
             	}
             });


        }

        function remove(user) {
            console.info(user);
        }


        function go() {
            $state.go('users');

        }

    }

})(this.angular);