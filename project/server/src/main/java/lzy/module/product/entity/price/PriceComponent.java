package lzy.module.product.entity.price;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * 价格成分
 * User: longzhiyou
 * Date: 2017/6/5
 * Time: 11:23
 */
@Data
@Entity
public class PriceComponent {
    @Id
    private Integer priceComponentId;
    private Integer partyId;
    private Integer productFeatureId;
    private Integer productId;
    private Integer agreementItemSeqId;
    private Integer agreementId;
    private Integer productCategoryId;
    private Integer partyTypeId;
    private Integer uomId;
    private Integer saleTypeId;
    private Integer orderValueId;
    private Integer quantityBreakId;
    private Date fromDate;
    private Date thruDate;
    private Integer price;
    private Integer pricePercent;


    private String comments;


    private Integer geoId;


}
