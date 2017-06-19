/**
 *
 * 定义app涉及的所有模块的总入口
 * Created by longzhiyou on 2016-06-12.
 */
(function(angular){
    "use strict";
    /* @ngInject */
    angular.module('app', [
        'ionic'
        ,'restangular'
        ,'oc.lazyLoad'
        ,"sprintf"
    ]);

})(this.angular);