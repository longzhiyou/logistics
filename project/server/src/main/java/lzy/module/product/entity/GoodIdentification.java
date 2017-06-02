package lzy.module.product.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 货物标识,类似于标签
 * User: longzhiyou
 * Date: 2017/5/23
 * Time: 9:19
 */

@Data
@Entity
@IdClass(GoodIdentificationPK.class)
public class GoodIdentification {
    @Id
    private Integer identificationTypeId;
    @Id
    private Integer productId;
    private Integer idValue;

}
