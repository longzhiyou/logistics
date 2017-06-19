/**
 *
 * Created by longzhiyou on 2016-06-12.
 */

(function(angular){
    "use strict";
    angular.module('app')
        .controller('moodController', MoodController);
    /* @ngInject */
    function MoodController($state,Restangular,$stateParams){
        var vm = this;
        vm.recordId=$stateParams.recordId;

        //获取会员最新处方信息
        var rest = Restangular.one("prescriptions", $stateParams.recordId).all("moods");
        rest.getList().then(function(moods) {
            vm.moods = moods;


        });


    }

})(this.angular);