/**
 *
 * Created by longzhiyou on 2016-06-12.
 */

(function(angular){
    "use strict";
    angular.module('app')
        .controller('userDetailController', UserDetailController);
    /* @ngInject */
    function UserDetailController($state,Restangular){
        var vm = this;
        vm.user={name:"aaa",age:100};

    }

})(this.angular);