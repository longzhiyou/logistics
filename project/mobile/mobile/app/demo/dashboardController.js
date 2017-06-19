/**
 *
 * Created by longzhiyou on 2016-06-12.
 */

(function(angular){
    "use strict";
    angular.module('app')
        .controller('dashboardController', DashboardController);
    /* @ngInject */
    function DashboardController($state,$http,setting,Restangular){
        var vm = this;
        vm.greeting = {id:"0",content:"empty"};
        vm.Comments = setting.getBaseApi("/greeting");
        vm.go = go;
        function go() {

            // Only stating main route
            // First way of creating a Restangular object. Just saying the base URL
            var account = Restangular.one("accounts", 123);
            account.get().then(function(data){
                vm.greeting= data;
            });

            // GET /accounts/123?single=true
            //$scope.account = account.get({single: true});

            // This will query /accounts and return a promise.
            //baseAccounts.getList().then(function(accounts) {
            //    vm.allAccounts = accounts;
            //});

            var data = 0;
            //$http.get(MobilePublic.getServerApi('/greeting'))
            //    .then(getAvengersComplete)
            //    .catch(function(message) {
            //        exception.catcher('XHR Failed for getAvengers')(message);
            //        $location.url('/login');
            //    });
            //
            //function getAvengersComplete(data, status, headers, config) {
            //    vm.greeting= data.data;
            //}
            //$state.go('app.account');
        }

    }

})(this.angular);