package lzy.module.product.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * User: longzhiyou
 * Date: 2017/5/23
 * Time: 9:19
 */
public class GoodIdentificationPK implements Serializable {
    private Integer identificationTypeId;
    private Integer productId;

    @Column(name = "IDENTIFICATION_TYPE_ID")
    @Id
    public Integer getIdentificationTypeId() {
        return identificationTypeId;
    }

    public void setIdentificationTypeId(Integer identificationTypeId) {
        this.identificationTypeId = identificationTypeId;
    }

    @Column(name = "PRODUCT_ID")
    @Id
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoodIdentificationPK that = (GoodIdentificationPK) o;

        if (identificationTypeId != null ? !identificationTypeId.equals(that.identificationTypeId) : that.identificationTypeId != null)
            return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = identificationTypeId != null ? identificationTypeId.hashCode() : 0;
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        return result;
    }
}
