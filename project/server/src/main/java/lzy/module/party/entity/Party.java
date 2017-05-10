package lzy.module.party.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


/**
 * User: longzhiyou
 * Date: 2017/4/7
 * Time: 14:40
 */


//@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Party {
    @Id
    private Long partyId;

    public Long getPartyId() {
        return partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }
}