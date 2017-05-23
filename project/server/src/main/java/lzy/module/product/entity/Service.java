package lzy.module.product.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 无形的商品，涉及到人们的时间和经验，如咨询服务，法律服务等
 * 继承product
 * User: longzhiyou
 * Date: 2017/5/23
 * Time: 10:19
 */
@Data
@Entity
public class Service {
    @Id
    private Integer productId;


}
