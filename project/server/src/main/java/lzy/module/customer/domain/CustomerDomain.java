
package lzy.module.customer.domain;

import lombok.Data;
import lombok.extern.java.Log;


/**
 * 客户领域模型
 * [2017-04-11 add by longzhiyou]
 */
@Data
@Log
public class CustomerDomain {

    //人员相关信息
    private Long partyId;
    private String name;

    //头像路径
    private String avatar;
    //角色特有的信息
    private String creditCard;
    //...其他
}

