package lzy.module.product.entity;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * User: longzhiyou
 * Date: 2017/5/18
 * Time: 9:56
 */
@Data
@Entity
public class Product {
    @Id
    private Integer productId;
    private Integer partId;
    private Integer manufacturerPartyId;
    private Integer uomId;
    private String name;
    private Date introductionDate;
    private Date salesDiscontinuationDate;
    private Date supportDiscontinuationDate;
    private String comments;
    private String description;


}
