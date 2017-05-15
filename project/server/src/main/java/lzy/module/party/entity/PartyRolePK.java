package lzy.module.party.entity;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

/**
 *
 * Created by bukeyan on 2017/4/9.
 */
@Data
public class PartyRolePK implements Serializable {
    @Id
    private Long partyId;
    @Id
    private Integer roleTypeId;


}
