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
public class ProductFeatureCategory {
    @Id
    private Integer productFeatureCategoryId;
    private String description;


}
