package lzy.module.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User: longzhiyou
 * Date: 2017/5/23
 * Time: 10:19
 */
@Entity
@Table(name = "service_territory", schema = "data_model_resource", catalog = "")
public class ServiceTerritory {
    private Integer geoId;

    @Id
    @Column(name = "GEO_ID")
    public Integer getGeoId() {
        return geoId;
    }

    public void setGeoId(Integer geoId) {
        this.geoId = geoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceTerritory that = (ServiceTerritory) o;

        if (geoId != null ? !geoId.equals(that.geoId) : that.geoId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return geoId != null ? geoId.hashCode() : 0;
    }
}
