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
@IdClass(PersonTrainingPK.class)
public class PersonTraining {
    @Id
    private Integer trainingClassTypeId;
    @Id
    private Integer partyId;
    private Date thruDate;
    private Date fromDate;


}
