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
    private Integer productCategoryId;
    @Id
    private Integer productId;
    @Id
    private Date fromDate;

    private Date thruDate;
    //首要标识，防止分析销售时被重复计算
    private String primaryFlag;
    private String comments;

}
