package lzy.module.product.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

/**
 * User: longzhiyou
 * Date: 2017/6/5
 * Time: 10:52
 */
public class InventoryItemVariancePK implements Serializable {
    private Integer inventoryItemId;
    private Date physicalInventoryDate;

    @Column(name = "INVENTORY_ITEM_ID")
    @Id
    public Integer getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(Integer inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    @Column(name = "PHYSICAL_INVENTORY_DATE")
    @Id
    public Date getPhysicalInventoryDate() {
        return physicalInventoryDate;
    }

    public void setPhysicalInventoryDate(Date physicalInventoryDate) {
        this.physicalInventoryDate = physicalInventoryDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InventoryItemVariancePK that = (InventoryItemVariancePK) o;

        if (inventoryItemId != null ? !inventoryItemId.equals(that.inventoryItemId) : that.inventoryItemId != null)
            return false;
        if (physicalInventoryDate != null ? !physicalInventoryDate.equals(that.physicalInventoryDate) : that.physicalInventoryDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = inventoryItemId != null ? inventoryItemId.hashCode() : 0;
        result = 31 * result + (physicalInventoryDate != null ? physicalInventoryDate.hashCode() : 0);
        return result;
    }
}
