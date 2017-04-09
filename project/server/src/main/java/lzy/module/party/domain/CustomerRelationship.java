package lzy.module.party.domain;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

/**
 *
 * Created by bukeyan on 2017/4/9.
 */

@Data
@Entity
@IdClass(CustomerRelationshipPK.class)
public class CustomerRelationship {
    @Id
    private Integer partyIdFrom;
    @Id
    private Integer partyIdTo;
    @Id
    private Date fromDate;
    @Id
    private Integer roleTypeIdFrom;
    @Id
    private Integer roleTypeIdTo;



}
