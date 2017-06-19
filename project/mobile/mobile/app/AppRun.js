/**
 * 最后执行的模块
* The application startup function, called in the app module's run block
 * Created apart from app.js so it can be easily stubbed out
 * during testing or tested independently
 *
 * Created by bukeyan on 2016/6/12.
 */

(function( angular ) {
    "use strict";

    angular.module('app').run(AppStart);
    /* @ngInject */
    function AppStart($ionicPlatform,$rootScope, $state, $stateParams,$interval,auth,Restangular,setting) {


        auth.init();

        $rootScope.$state = $state;
        $rootScope.$stateParams = $stateParams;


        function startTask(){

            //启动每秒的定时器
            var foodPlanData=null;

            var jobs=[];
            var timer = $interval(function(){


                //检查是否登陆成功
                if (auth.authenticated) {
                    //查看相关数据是否存在
                    if (foodPlanData==null) {

                        jobs.splice(0,jobs.length);//清空数组

                        var sound = device.platform == 'Android' ? 'file://sound.mp3' : 'file://beep.caf';
                        var icon = 'res://icon';

                        //获取会员最新处方信息
                        var rest = Restangular.one("members", auth.getObject("account").id).all("foods");
                        rest.getList().then(function(foods) {
                            foodPlanData=foods;
                            angular.forEach(foods, function(data,index){
                                if (!data.timer) {
                                    return;
                                }
                                var splitData = data.timer.split(":");
                                var  title = data.oddDayFood1Name + data.oddDayFood2Name;

                                if (title) {

                                    // 周 1,3,5
                                    var cronTime = sprintf("0 %s %s * * 1,3,5",splitData[1],splitData[0]);
                                    console.log("cronTime:"+cronTime);
                                    //var message = sprintf("0 %s %s * * 1,3,5",splitData[1],splitData[0]);
                                    var cronJob = new CronJob(cronTime, function(){
                                        cordova.plugins.notification.local.schedule({
                                            id:index*2+1,
                                            title: title,
                                            message: data.timer,
                                            sound: sound,
                                            icon: icon,
                                            badge: data.timer
                                        });
                                    });
                                    jobs.push(cronJob);
                                }



                                title = data.evenDayFood1Name + data.evenDayFood2Name;
                                if (title) {

                                    var cronTime = sprintf("0 %s %s * * 2,4,6,7",splitData[1],splitData[0]);
                                    console.log("cronTime:"+cronTime);
                                    // 周 1,3,5
                                    var cronJob = new CronJob(cronTime, function(){
                                        cordova.plugins.notification.local.schedule({
                                            id:index*2+2,
                                            title: title,
                                            message: data.timer,
                                            sound: sound,
                                            icon: icon,
                                            badge: data.timer
                                        });
                                    });
                                    jobs.push(cronJob);
                                }
                            });

                        });

                    }
                }else {
                    if (foodPlanData!=null){
                        foodPlanData=null;
                        //清除定时器
                        angular.forEach(jobs, function(job){
                            job.stop();

                        });
                        //console.log('清除定时器');
                    }

                }
            },1000);

        }
        startTask();
        $ionicPlatform.ready(function() {




            // Hide the accessory bar by default (remove this to show the accessory bar above the keyboard
            // for form inputs)
            //console.log('$ionicPlatform');
            //
            //cordova.plugins.notification.local.hasPermission(function (granted) {
            //     console.log('Permission has been granted: ' + granted);
            //});
            //

            //console.log(moment().format('LLLL'));
            //var badgecount=1;
            //new CronJob('00 42 20 * * 1-7', function(){
            //    //console.log('You will see this message every second');
            //var now =new Date().getTime();
            //var _5_sec_from_now =new Date(now +5*1000);
            //var _10_sec_from_now =new Date(now +10*1000);
            //    cordova.plugins.notification.local.schedule({
            //        id:1,
            //        title: "lzy _5_sec_from_now",
            //        message: "Hi, long.",
            //        at:_5_sec_from_now,
            //        sound:null,
            //        badge: 1
            //    });
            //cordova.plugins.notification.local.schedule({
            //    id:2,
            //    title: "lzy _10_sec_from_now",
            //    message: "Hi, long.",
            //    sound:null,
            //    at:_10_sec_from_now,
            //    badge: 2
            //});
            //    badgecount=badgecount+1;
            //});





            if (window.cordova && window.cordova.plugins && window.cordova.plugins.Keyboard) {
                cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);
                cordova.plugins.Keyboard.disableScroll(true);

            }
            if (window.StatusBar) {
                // org.apache.cordova.statusbar required
                StatusBar.styleDefault();
            }
        });



        $rootScope.$on('$stateChangeStart',
            function (event, toState, toParams, fromState, fromParams) {

                if (!auth.authenticated ) {
                    if (toState.name != "login") {
                        event.preventDefault();
                        $rootScope.$state.go("login");
                        return;
                    }
                }


            });




    }

})( this.angular );
