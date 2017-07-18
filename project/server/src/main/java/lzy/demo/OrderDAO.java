package lzy.demo;

import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * mybatis3中@SelectProvider的使用技巧
 * http://www.blogjava.net/dbstar/archive/2011/08/08/355825.html
 * User: longzhiyou
 * Date: 2017/7/18
 * Time: 10:25
 */
public interface OrderDAO {
    class SqlProvider {
        private final String TBL_ORDER = "tbl_order";
        public String queryOrderByParam(OrderPara param) {
            SQL sql = new SQL().SELECT("*").FROM(TBL_ORDER);
            String room = param.getRoom();
            if (StringUtils.hasText(room)) {
                sql.WHERE("room LIKE #{room}");
            }
            Date myDate = param.getMyDate();
            if (myDate != null) {
                sql.WHERE("mydate LIKE #{mydate}");
            }
            return sql.toString();
        }
    }

    @SelectProvider(type = SqlProvider.class, method = "queryOrderByParam")
    List<Book> queryOrderByParam(OrderPara param);
}
