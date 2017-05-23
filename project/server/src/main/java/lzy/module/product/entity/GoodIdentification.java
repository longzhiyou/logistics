package lzy.module.product.entity;

import javax.persistence.*;

/**
 * User: longzhiyou
 * Date: 2017/5/23
 * Time: 9:19
 */
@Entity
@Table(name = "good_identification", schema = "data_model_resource", catalog = "")
@IdClass(GoodIdentificationPK.class)
public class GoodIdentification {
    private Integer identificationTypeId;
    private Integer productId;
    private Integer idValue;

    @Id
    @Column(name = "IDENTIFICATION_TYPE_ID")
    public Integer getIdentificationTypeId() {
        return identificationTypeId;
    }

    public void setIdentificationTypeId(Integer identificationTypeId) {
        this.identificationTypeId = identificationTypeId;
    }

    @Id
    @Column(name = "PRODUCT_ID")
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "ID_VALUE")
    public Integer getIdValue() {
        return idValue;
    }

    public void setIdValue(Integer idValue) {
        this.idValue = idValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoodIdentification that = (GoodIdentification) o;

        if (identificationTypeId != null ? !identificationTypeId.equals(that.identificationTypeId) : that.identificationTypeId != null)
            return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (idValue != null ? !idValue.equals(that.idValue) : that.idValue != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = identificationTypeId != null ? identificationTypeId.hashCode() : 0;
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (idValue != null ? idValue.hashCode() : 0);
        return result;
    }
}
