package lzy.module.product.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

/**
 * 库存项目变化
 * 是库存项目与原因的M-N
 * User: longzhiyou
 * Date: 2017/6/5
 * Time: 10:52
 */

@Data
@Entity
@IdClass(InventoryItemVariancePK.class)
public class InventoryItemVariance {
    @Id
    private Integer inventoryItemId;
    @Id
    private Date physicalInventoryDate;
    private Integer reasonId;
    private Integer quantity;
    private String comments;


}
