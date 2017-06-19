/**
 *
 * Created by longzhiyou on 11/03/16.
 */
var MobilePublic = MobilePublic || {};
MobilePublic.Url = "mobile/";
MobilePublic.Api = "http://192.168.1.119/api/";

MobilePublic.getServerUrl = function (shortUrl) {

    return MobilePublic.Url + shortUrl;
};

MobilePublic.getServerApi = function (shortUri) {

    return MobilePublic.Api + shortUri;
};
// 删除掉Loading画面
var loading_div = document.getElementById('windowLoadingDiv');
angular.element(loading_div).remove();

// 远程CSS设置
document.write("<link href='"+MobilePublic.getServerUrl("assets/css/widget.css")+"' rel='stylesheet'>");

document.write("<script src='"+MobilePublic.getServerUrl("app/common/Public.js")+"'></script>");
document.write("<script src='"+MobilePublic.getServerUrl("app/App.js")+"'></script>");
document.write("<script src='"+MobilePublic.getServerUrl("app/Setting.js")+"'></script>");
document.write("<script src='"+MobilePublic.getServerUrl("app/AppConfig.js")+"'></script>");
document.write("<script src='"+MobilePublic.getServerUrl("app/AppRun.js")+"'></script>");
document.write("<script src='"+MobilePublic.getServerUrl("app/common/LocalService.js")+"'></script>");
document.write("<script src='"+MobilePublic.getServerUrl("app/common/AuthService.js")+"'></script>");
