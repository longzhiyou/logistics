package lzy.module.party.domain;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

/**
 *
 * Created by bukeyan on 2017/4/9.
 */
@Data
public class PersonTrainingPK implements Serializable {
    @Id
    private Integer trainingClassTypeId;
    @Id
    private Integer partyId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonTrainingPK that = (PersonTrainingPK) o;

        if (trainingClassTypeId != null ? !trainingClassTypeId.equals(that.trainingClassTypeId) : that.trainingClassTypeId != null)
            return false;
        if (partyId != null ? !partyId.equals(that.partyId) : that.partyId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = trainingClassTypeId != null ? trainingClassTypeId.hashCode() : 0;
        result = 31 * result + (partyId != null ? partyId.hashCode() : 0);
        return result;
    }
}
