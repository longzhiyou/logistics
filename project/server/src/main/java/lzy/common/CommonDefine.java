package lzy.common;

/**
 * 系统中通用的定义
 * User: longzhiyou
 * Date: 2016/11/9
 * Time: 10:12
 */
public interface CommonDefine {

    String BASE_URI ="/api";
    String NOT_DELETED = "deleted_on IS NULL  OR deleted_on > CURRENT_TIMESTAMP";
    String DELETED_FIELD = "deletedOn";


}
