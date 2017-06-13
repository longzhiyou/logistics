package lzy.module.product.entity.price;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 基础价格
 * User: longzhiyou
 * Date: 2017/6/5
 * Time: 11:23
 */

@Data
@Entity
public class BasePrice {
    @Id
    private Integer priceComponentId;


}
