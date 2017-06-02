package lzy.module.product.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * User: longzhiyou
 * Date: 2017/6/2
 * Time: 15:22
 */
public class ProductFeatureInteractionPK implements Serializable {
    private Integer productFeatureIdFactorIn;
    private Integer productFeatureIdOf;

    @Column(name = "PRODUCT_FEATURE_ID_FACTOR_IN")
    @Id
    public Integer getProductFeatureIdFactorIn() {
        return productFeatureIdFactorIn;
    }

    public void setProductFeatureIdFactorIn(Integer productFeatureIdFactorIn) {
        this.productFeatureIdFactorIn = productFeatureIdFactorIn;
    }

    @Column(name = "PRODUCT_FEATURE_ID_OF")
    @Id
    public Integer getProductFeatureIdOf() {
        return productFeatureIdOf;
    }

    public void setProductFeatureIdOf(Integer productFeatureIdOf) {
        this.productFeatureIdOf = productFeatureIdOf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductFeatureInteractionPK that = (ProductFeatureInteractionPK) o;

        if (productFeatureIdFactorIn != null ? !productFeatureIdFactorIn.equals(that.productFeatureIdFactorIn) : that.productFeatureIdFactorIn != null)
            return false;
        if (productFeatureIdOf != null ? !productFeatureIdOf.equals(that.productFeatureIdOf) : that.productFeatureIdOf != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productFeatureIdFactorIn != null ? productFeatureIdFactorIn.hashCode() : 0;
        result = 31 * result + (productFeatureIdOf != null ? productFeatureIdOf.hashCode() : 0);
        return result;
    }
}
