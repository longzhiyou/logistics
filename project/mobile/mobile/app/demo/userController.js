/**
 *
 * Created by longzhiyou on 2016-06-12.
 */

(function(angular){
    "use strict";
    angular.module('app')
        .controller('userController', UserController);
    /* @ngInject */
    function UserController($state, $stateParams){
        var vm = this;

        vm.userId=$stateParams.userId;

    }

})(this.angular);