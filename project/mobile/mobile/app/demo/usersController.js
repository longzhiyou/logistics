/**
 *
 * Created by longzhiyou on 2016-06-12.
 */

(function(angular){
    "use strict";
    angular.module('app')
        .controller('usersController', UsersController);
    /* @ngInject */
    function UsersController($state,Restangular){
        var vm = this;
        vm.go = go;
        vm.getUserList=getUserList;
        vm.users=[];
        function go() {
            $state.go('app.dashboard.chat',{},{reload:true});
        }

        function getUserList() {

            // Restangular returns promises
            Restangular.all('users').getList()  // GET: /users
                .then(function(users) {
                    // returns a list of users
                    vm.users = users; // first Restangular obj in list: { id: 123 }
                });

        }

        getUserList();

    }

})(this.angular);