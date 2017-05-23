package lzy.module.product.entity;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 有形的物品，叫货物，如特定类别的笔，家具，
 * 设备或任何在物理地址存储的东西，包括软件
 * 继承自 product
 * User: longzhiyou
 * Date: 2017/5/23
 * Time: 9:19
 */
@Data
@Entity
public class Good {

    @Id
    private Integer productId;

    //REFERENCES FINISHED_GOOD
    private Integer partId;

}
