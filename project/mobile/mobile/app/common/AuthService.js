/**
 * 本地存储服务
 * Created by longzhiyou on 2016/11/14.
 */

(function (angular) {
    angular.module('app').factory('auth', ['Restangular', factory]);

    function factory(Restangular) {

        function set(key, value) {
            localStorage[key] = value;
        }

        function get(key, defaultValue) {
            return  localStorage[key] || defaultValue;
        }

        function setObject(key, value) {
            localStorage[key] = JSON.stringify(value);
        }

        function getObject(key) {
            return JSON.parse( localStorage[key] || '{}');
        }

        function remove(key) {
            return  localStorage.removeItem[key];
        }

        function clear() {
            return  localStorage.clear();
        }

        var auth = {
            authenticated: false,
            init: init,
            authenticate: authenticate,
            getObject:getObject,
            clear: clear
        };
        return auth;

        //////////////

        function init() {

            var account = get("account");
            auth.authenticated = account ? true : false;
        }

        function authenticate(credentials, callback) {


            var login = Restangular.all('login');
            login.post(credentials).then(function(account) {
                auth.authenticated = true;
                setObject("account",account);
                callback && callback(auth.authenticated);
            }, function() {
                auth.authenticated = false;
                callback && callback(auth.authenticated);

            });
        }

        function clear() {

            auth.authenticated = false;
            localStorage.removeItem('account');

        }


    }




})(this.angular);