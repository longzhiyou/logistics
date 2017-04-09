package lzy.module.party.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

/**
 *
 * Created by bukeyan on 2017/4/9.
 */
@Data
public class PersonClassificationPK implements Serializable {
    private Date fromDate;
    private Integer partyTypeId;
    private Integer partyId;

    @Column(name = "FROM_DATE")
    @Id
    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    @Column(name = "PARTY_TYPE_ID")
    @Id
    public Integer getPartyTypeId() {
        return partyTypeId;
    }

    public void setPartyTypeId(Integer partyTypeId) {
        this.partyTypeId = partyTypeId;
    }

    @Column(name = "PARTY_ID")
    @Id
    public Integer getPartyId() {
        return partyId;
    }

    public void setPartyId(Integer partyId) {
        this.partyId = partyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonClassificationPK that = (PersonClassificationPK) o;

        if (fromDate != null ? !fromDate.equals(that.fromDate) : that.fromDate != null) return false;
        if (partyTypeId != null ? !partyTypeId.equals(that.partyTypeId) : that.partyTypeId != null) return false;
        if (partyId != null ? !partyId.equals(that.partyId) : that.partyId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fromDate != null ? fromDate.hashCode() : 0;
        result = 31 * result + (partyTypeId != null ? partyTypeId.hashCode() : 0);
        result = 31 * result + (partyId != null ? partyId.hashCode() : 0);
        return result;
    }
}
