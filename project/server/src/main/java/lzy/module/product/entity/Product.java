package lzy.module.product.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

/**
 * User: longzhiyou
 * Date: 2017/5/18
 * Time: 9:56
 */
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@Entity
public class Product {
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "lzy.common.domain.IdGenerator")
    @GeneratedValue(generator = "idGenerator")
    private Long productId;
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
