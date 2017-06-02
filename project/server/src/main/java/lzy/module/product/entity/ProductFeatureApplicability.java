package lzy.module.product.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

/**
 * User: longzhiyou
 * Date: 2017/6/2
 * Time: 15:22
 */
@Data
@Entity
@IdClass(ProductFeatureApplicabilityPK.class)
public class ProductFeatureApplicability {

    @Id
    private Integer productId;
    @Id
    private Date fromDate;
    @Id
    private Integer productFeatureId;
    private Date thruDate;


}
