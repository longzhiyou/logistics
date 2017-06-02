package lzy.module.product.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * User: longzhiyou
 * Date: 2017/6/2
 * Time: 15:22
 */
@Data
@Entity
@IdClass(ProductFeatureInteractionPK.class)
public class ProductFeatureInteraction {
    @Id
    private Integer productFeatureIdFactorIn;
    @Id
    private Integer productFeatureIdOf;
    private Integer productId;

}
