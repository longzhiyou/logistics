
package lzy.module.party.domain;

import lombok.Data;


/**
 * 客户领域模型
 * [2017-04-11 add by longzhiyou]
 */
@Data
public class CustomerDomain {

    //人员相关信息
    private Long partyId;
    private String name;

    //角色特有的信息
    private String creditCard;
    //...其他
}

