package lzy.module.product.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * User: longzhiyou
 * Date: 2017/5/18
 * Time: 9:56
 */
@Data
@Entity
public class ProductCategory {
    @Id
    private Integer productCategoryId;
    private String description;

}
