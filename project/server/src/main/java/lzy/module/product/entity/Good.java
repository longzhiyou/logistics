package lzy.module.product.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

/**
 * 有形的物品，叫货物，如特定类别的笔，家具，
 * 设备或任何在物理地址存储的东西，包括软件
 * 继承自 product
 * User: longzhiyou
 * Date: 2017/5/23
 * Time: 9:19
 */
@Getter
@Setter
@Entity
public class Good extends Product {
//
//    @Id
//    private Integer productId;
//
//    //REFERENCES FINISHED_GOOD
//    private Integer partId;

}
