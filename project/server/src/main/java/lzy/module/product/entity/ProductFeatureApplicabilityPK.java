package lzy.module.product.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

/**
 * User: longzhiyou
 * Date: 2017/6/2
 * Time: 15:22
 */
public class ProductFeatureApplicabilityPK implements Serializable {
    private Integer productId;
    private Date fromDate;
    private Integer productFeatureId;

    @Column(name = "PRODUCT_ID")
    @Id
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Column(name = "FROM_DATE")
    @Id
    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    @Column(name = "PRODUCT_FEATURE_ID")
    @Id
    public Integer getProductFeatureId() {
        return productFeatureId;
    }

    public void setProductFeatureId(Integer productFeatureId) {
        this.productFeatureId = productFeatureId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductFeatureApplicabilityPK that = (ProductFeatureApplicabilityPK) o;

        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (fromDate != null ? !fromDate.equals(that.fromDate) : that.fromDate != null) return false;
        if (productFeatureId != null ? !productFeatureId.equals(that.productFeatureId) : that.productFeatureId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productId != null ? productId.hashCode() : 0;
        result = 31 * result + (fromDate != null ? fromDate.hashCode() : 0);
        result = 31 * result + (productFeatureId != null ? productFeatureId.hashCode() : 0);
        return result;
    }
}
