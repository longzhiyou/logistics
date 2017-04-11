package lzy.module.party.entity;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

/**
 *
 * Created by bukeyan on 2017/4/9.
 */
@Data
//@Embeddable
public class CustomerPK implements Serializable {
    @Id
    private Long partyId;
    @Id
    private Integer roleTypeId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerPK that = (CustomerPK) o;

        if (partyId != null ? !partyId.equals(that.partyId) : that.partyId != null) return false;
        if (roleTypeId != null ? !roleTypeId.equals(that.roleTypeId) : that.roleTypeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = partyId != null ? partyId.hashCode() : 0;
        result = 31 * result + (roleTypeId != null ? roleTypeId.hashCode() : 0);
        return result;
    }
}
