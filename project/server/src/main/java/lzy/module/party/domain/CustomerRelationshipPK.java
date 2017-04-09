package lzy.module.party.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by bukeyan on 2017/4/9.
 */
public class CustomerRelationshipPK implements Serializable {
    private Integer partyIdFrom;

    @Column(name = "PARTY_ID_FROM")
    @Id
    public Integer getPartyIdFrom() {
        return partyIdFrom;
    }

    public void setPartyIdFrom(Integer partyIdFrom) {
        this.partyIdFrom = partyIdFrom;
    }

    private Integer partyIdTo;

    @Column(name = "PARTY_ID_TO")
    @Id
    public Integer getPartyIdTo() {
        return partyIdTo;
    }

    public void setPartyIdTo(Integer partyIdTo) {
        this.partyIdTo = partyIdTo;
    }

    private Date fromDate;

    @Column(name = "FROM_DATE")
    @Id
    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    private Integer roleTypeIdFrom;

    @Column(name = "ROLE_TYPE_ID_FROM")
    @Id
    public Integer getRoleTypeIdFrom() {
        return roleTypeIdFrom;
    }

    public void setRoleTypeIdFrom(Integer roleTypeIdFrom) {
        this.roleTypeIdFrom = roleTypeIdFrom;
    }

    private Integer roleTypeIdTo;

    @Column(name = "ROLE_TYPE_ID_TO")
    @Id
    public Integer getRoleTypeIdTo() {
        return roleTypeIdTo;
    }

    public void setRoleTypeIdTo(Integer roleTypeIdTo) {
        this.roleTypeIdTo = roleTypeIdTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerRelationshipPK that = (CustomerRelationshipPK) o;

        if (partyIdFrom != null ? !partyIdFrom.equals(that.partyIdFrom) : that.partyIdFrom != null) return false;
        if (partyIdTo != null ? !partyIdTo.equals(that.partyIdTo) : that.partyIdTo != null) return false;
        if (fromDate != null ? !fromDate.equals(that.fromDate) : that.fromDate != null) return false;
        if (roleTypeIdFrom != null ? !roleTypeIdFrom.equals(that.roleTypeIdFrom) : that.roleTypeIdFrom != null)
            return false;
        if (roleTypeIdTo != null ? !roleTypeIdTo.equals(that.roleTypeIdTo) : that.roleTypeIdTo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = partyIdFrom != null ? partyIdFrom.hashCode() : 0;
        result = 31 * result + (partyIdTo != null ? partyIdTo.hashCode() : 0);
        result = 31 * result + (fromDate != null ? fromDate.hashCode() : 0);
        result = 31 * result + (roleTypeIdFrom != null ? roleTypeIdFrom.hashCode() : 0);
        result = 31 * result + (roleTypeIdTo != null ? roleTypeIdTo.hashCode() : 0);
        return result;
    }
}
