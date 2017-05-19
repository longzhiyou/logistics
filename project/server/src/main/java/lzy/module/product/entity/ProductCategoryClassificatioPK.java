package lzy.module.product.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

/**
 * User: longzhiyou
 * Date: 2017/5/18
 * Time: 9:56
 */
public class ProductCategoryClassificatioPK implements Serializable {
    private Date fromDate;
    private Integer productCategoryId;
    private Integer productId;

    @Column(name = "FROM_DATE")
    @Id
    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    @Column(name = "PRODUCT_CATEGORY_ID")
    @Id
    public Integer getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Integer productCategoryId) {
        this.productCategoryId = productCategoryId;
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

        ProductCategoryClassificatioPK that = (ProductCategoryClassificatioPK) o;

        if (fromDate != null ? !fromDate.equals(that.fromDate) : that.fromDate != null) return false;
        if (productCategoryId != null ? !productCategoryId.equals(that.productCategoryId) : that.productCategoryId != null)
            return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fromDate != null ? fromDate.hashCode() : 0;
        result = 31 * result + (productCategoryId != null ? productCategoryId.hashCode() : 0);
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        return result;
    }
}
