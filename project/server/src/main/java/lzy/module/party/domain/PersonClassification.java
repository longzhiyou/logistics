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
@IdClass(PersonClassificationPK.class)
public class PersonClassification {
    @Id
    private Date fromDate;
    @Id
    private Integer partyTypeId;
    @Id
    private Integer partyId;

}
