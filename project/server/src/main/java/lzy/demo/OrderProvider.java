package lzy.demo;

import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * mybatis @Select注解中当参数为空则不添加该参数的判断
 * User: longzhiyou
 * Date: 2017/7/18
 * Time: 10:22
 */
public class OrderProvider {
    private final String TBL_ORDER = "tbl_order";
    public String queryOrderByParam(OrderPara param) {
        return "";
//        SQL sql = new SQL().SELECT("*").FROM(TBL_ORDER);
//        String room = param.getRoom();
//        if (StringUtils.hasText(room)) {
//            sql.WHERE("room LIKE #{room}");
//        }
//        Date myDate = param.getMyDate();
//        if (myDate != null) {
//            sql.WHERE("mydate LIKE #{mydate}");
//        }
//        return sql.toString();
    }

}
