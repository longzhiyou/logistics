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
  'datatables',
  'datatables.buttons',
  //'datatables.bootstrap',
  //  'datatables.colvis','datatables.bootstrap.colvis',
  'BlurAdmin.theme',
  'BlurAdmin.pages'
]);

angular.module('BlurAdmin')
    .constant('defaultOptionsDom'
        ,'<"row"<"col-xs-9 col-md-9"B><"col-xs-3 col-md-3"f>>rt<"row"<"col-md-3"l><"col-md-6"p><"col-md-3"i>>');

angular.module('BlurAdmin')
    .config(config).run(appRun);

/** @ngInject */
function config($httpProvider
    ,RestangularProvider
    ,jwtOptionsProvider) {

    //console.info("app config");
    RestangularProvider.setBaseUrl('http://localhost:9002/api');

    // Please note we're annotating the function so that the $injector works when the file is minified
    jwtOptionsProvider.config({
        authPrefix: '',
        tokenGetter: function() {
            var token = localStorage.getItem('token');
            //token= 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczovL3NhbXBsZXMuYXV0aDAuY29tLyIsInN1YiI6ImZhY2Vib29rfDEwMTU0Mjg3MDI3NTEwMzAyIiwiYXVkIjoiQlVJSlNXOXg2MHNJSEJ3OEtkOUVtQ2JqOGVESUZ4REMiLCJleHAiOjE0MTIyMzQ3MzAsImlhdCI6MTQxMjE5ODczMH0.7M5sAV50fF1-_h9qVbdSgqAnXVF7mz3I6RjS6JiH0H8';

            return token;
        }
        ,unauthenticatedRedirector: function() {
            var landingUrl = "http://" + window.location.host + "/auth.html";
            console.log(landingUrl);
            window.location.href = landingUrl;
        }
        ,whiteListedDomains: ['localhost']
    });
    $httpProvider.interceptors.push('jwtInterceptor');

}

/** @ngInject */
function appRun(authManager,$rootScope,DTDefaultOptions) {
    //console.info("appRun");

var oLanguage=
    {
        "sEmptyTable":     "没有可用的数据",
        "sInfo":           "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
        "sInfoEmpty":      "显示 0 to 0 of 0 条",
        "sInfoFiltered":   "(从 _MAX_ 条数据中检索)",
        "sInfoPostFix":    "",
        "sInfoThousands":  ",",
        "sLengthMenu":     "每页显示 _MENU_ 条记录",
        "sLoadingRecords": "加载中...",
        "sProcessing":     "处理中...",
        "sSearch":         "查询:",
        "sZeroRecords":    "没有检索到数据",
        "oPaginate": {
        "sFirst":    "首页",
            "sLast":     "尾页",
            "sNext":     "前一页",
            "sPrevious": "后一页"
    },
        "oAria": {
        "sSortAscending":  ": activate to sort column ascending",
            "sSortDescending": ": activate to sort column descending"
    }
    };
    DTDefaultOptions.setLanguage(oLanguage);

    //var dom = "<'row'<'col-sm-6'l><'col-sm-6'f>>" +
    //"<'row'<'col-sm-12'tr>>" +
    //"<'row'<'col-sm-5'i><'col-sm-7'p>>";

    //DTDefaultOptions.setDOM(dom);
    //DTDefaultOptions.setDOM('<"row"<"col-xs-9 col-md-9"B><"col-xs-3 col-md-3"f>>rt<"row"<"col-md-3"l><"col-md-6"p><"col-md-3"i>>');
    //DTDefaultOptions.setOption('dom','<"row"<"col-xs-9 col-md-9"B><"col-xs-3 col-md-3"f>>rt<"row"<"col-md-3"l><"col-md-6"p><"col-md-3"i>>');
    //authManager.checkAuthOnRefresh();
    authManager.redirectWhenUnauthenticated();

    $rootScope.$on('$stateChangeStart',
        function (event, toState, toParams, fromState, fromParams) {
            //console.log("fromState"+fromState.toString()+"toState"+toState.toString());
            if (!authManager.isAuthenticated() ) {
                var landingUrl = "http://" + window.location.host + "/auth.html";
                console.log(landingUrl);
                window.location.href = landingUrl;
            }

        });

}