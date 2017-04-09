package lzy.module.party.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by bukeyan on 2017/4/9.
 */
public class PartySkillPK implements Serializable {
    private Integer partyId;
    private Integer skillTypeId;

    @Column(name = "PARTY_ID")
    @Id
    public Integer getPartyId() {
        return partyId;
    }

    public void setPartyId(Integer partyId) {
        this.partyId = partyId;
    }

    @Column(name = "SKILL_TYPE_ID")
    @Id
    public Integer getSkillTypeId() {
        return skillTypeId;
    }

    public void setSkillTypeId(Integer skillTypeId) {
        this.skillTypeId = skillTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PartySkillPK that = (PartySkillPK) o;

        if (partyId != null ? !partyId.equals(that.partyId) : that.partyId != null) return false;
        if (skillTypeId != null ? !skillTypeId.equals(that.skillTypeId) : that.skillTypeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = partyId != null ? partyId.hashCode() : 0;
        result = 31 * result + (skillTypeId != null ? skillTypeId.hashCode() : 0);
        return result;
    }
}
