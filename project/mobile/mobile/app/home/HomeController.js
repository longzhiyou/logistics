/**
 *
 * Created by longzhiyou on 2016-06-12.
 */

(function(angular){
    "use strict";
    angular.module('app')
        .controller('homeController', HomeController);
    /* @ngInject */
    function HomeController(setting){
        var vm = this;
        vm.menus = setting.homeMenus;

    }

})(this.angular);