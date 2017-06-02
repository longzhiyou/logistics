package lzy.module.product.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 产品特征
 * 例子：质量、商标、颜色、大小、尺寸、款式、硬件、软件、付款方式
 * User: longzhiyou
 * Date: 2017/5/18
 * Time: 9:56
 */
@Data
@Entity
public class ProductFeature {
    @Id
    private Integer productFeatureId;
    private Integer productFeatureCategoryId;
    private String description;

}
