package lzy.module.product.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

/**
 * 产品有多个分类,类似github上的问题有多个标签
 * User: longzhiyou
 * Date: 2017/5/18
 * Time: 9:56
 */
@Data
@Entity
@IdClass(ProductCategoryClassificatioPK.class)
public class ProductCategoryClassificatio {
    @Id
    private Date fromDate;
    @Id
    private Integer productCategoryId;
    @Id
    private Integer productId;
    private Date thruDate;
    private String primaryFlag;
    private String comments;

}
