'use strict';

angular.module('BlurAdmin', [
  'ngAnimate',
  'ui.bootstrap',
  'ui.sortable',
  'ui.router',
  'ngTouch',
  'toastr',
  'smart-table',
  "xeditable",
  'ui.slimscroll',
  'ngJsTree',
  'angular-progress-button-styles',
  'angular-jwt',
    'restangular',
  'BlurAdmin.theme',
  'BlurAdmin.pages'
]);

angular.module('BlurAdmin')
    .config(config).run(appRun);

/** @ngInject */
function config($httpProvider
    ,jwtOptionsProvider) {

    console.info("app config");

    // Please note we're annotating the function so that the $injector works when the file is minified
    jwtOptionsProvider.config({
        authPrefix: '',
        tokenGetter: function() {
            var token = localStorage.getItem('token');
            //token= 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczovL3NhbXBsZXMuYXV0aDAuY29tLyIsInN1YiI6ImZhY2Vib29rfDEwMTU0Mjg3MDI3NTEwMzAyIiwiYXVkIjoiQlVJSlNXOXg2MHNJSEJ3OEtkOUVtQ2JqOGVESUZ4REMiLCJleHAiOjE0MTIyMzQ3MzAsImlhdCI6MTQxMjE5ODczMH0.7M5sAV50fF1-_h9qVbdSgqAnXVF7mz3I6RjS6JiH0H8';

            return token;
        }
        ,unauthenticatedRedirector: function() {
            var landingUrl = "http://" + $window.location.host + "/auth.html";
            console.log(landingUrl);
            $window.location.href = landingUrl;
        }
        ,whiteListedDomains: ['localhost']
    });
    $httpProvider.interceptors.push('jwtInterceptor');

}

/** @ngInject */
function appRun(authManager,$rootScope,$window) {
    console.info("appRun");
    //authManager.checkAuthOnRefresh();
    authManager.redirectWhenUnauthenticated();

    $rootScope.$on('$stateChangeStart',
        function (event, toState, toParams, fromState, fromParams) {
            //console.log("fromState"+fromState.toString()+"toState"+toState.toString());
            if (!authManager.isAuthenticated() ) {
                var landingUrl = "http://" + $window.location.host + "/auth.html";
                console.log(landingUrl);
                $window.location.href = landingUrl;
            }

        });

}