package lzy.module.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User: longzhiyou
 * Date: 2017/6/5
 * Time: 10:52
 */
@Entity
@Table(name = "inventory_item_status_type", schema = "data_model_resource", catalog = "")
public class InventoryItemStatusType {
    private Integer statusTypeId;

    @Id
    @Column(name = "STATUS_TYPE_ID")
    public Integer getStatusTypeId() {
        return statusTypeId;
    }

    public void setStatusTypeId(Integer statusTypeId) {
        this.statusTypeId = statusTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InventoryItemStatusType that = (InventoryItemStatusType) o;

        if (statusTypeId != null ? !statusTypeId.equals(that.statusTypeId) : that.statusTypeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return statusTypeId != null ? statusTypeId.hashCode() : 0;
    }
}
