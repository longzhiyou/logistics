package lzy.module.party.domain;

import lombok.Data;

import javax.persistence.*;

/**
 *
 * Created by bukeyan on 2017/4/9.
 */
@Data
@Entity
@IdClass(PartyRolePK.class)
public class PartyRole {
    @Id
    private Integer partyId;
    @Id
    private Integer roleTypeId;
    private Integer partyRoleId;


}
