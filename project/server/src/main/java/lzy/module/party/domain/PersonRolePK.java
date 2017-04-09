package lzy.module.party.domain;

import javax.persistence.Id;
import java.io.Serializable;

/**
 *
 * Created by bukeyan on 2017/4/9.
 */
public class PersonRolePK implements Serializable {
    @Id
    private Integer partyId;
    @Id
    private Integer roleTypeId;


}
