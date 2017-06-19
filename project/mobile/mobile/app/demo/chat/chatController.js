/**
 *
 * Created by longzhiyou on 2016-06-12.
 */

(function(angular){
    "use strict";
    angular.module('app')
        .controller('chatController', ChatController);
    /* @ngInject */
    function ChatController($state){
        var vm = this;
        vm.go = go;
        function go() {
            $state.go('app.dashboard.chat');
        }

    }

})(this.angular);