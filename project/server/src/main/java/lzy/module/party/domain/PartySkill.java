package lzy.module.party.domain;

import javax.persistence.*;
import java.sql.Date;

/**
 *
 * Created by bukeyan on 2017/4/9.
 */
@Entity
@IdClass(PartySkillPK.class)
public class PartySkill {
    @Id
    private Integer partyId;
    @Id
    private Integer skillTypeId;
    private Integer yearsExperience;
    private Integer rating;
    private Integer skillLevel;
    private Date startedUsingDate;

}
