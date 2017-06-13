package lzy.module.product.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 库存项目
 * User: longzhiyou
 * Date: 2017/6/5
 * Time: 10:52
 */
@Data
@Entity
public class InventoryItem {
    @Id
    private Integer inventoryItemId;
    private Integer partId;
    private Integer productId;
    private Integer partyId;
    private Integer statusTypeId;
    private Integer facilityId;
    private Integer containerId;
    private Integer lotId;


}
