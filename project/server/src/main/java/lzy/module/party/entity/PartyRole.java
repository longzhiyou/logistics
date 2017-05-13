package lzy.module.party.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 中间表必须实现Serializable
 * User: longzhiyou
 * Date: 2017/5/12
 * Time: 10:29
 */

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class PartyRole implements Serializable{

    private Party party;
    private RoleType roleType;
    private Integer partyRoleId;

    @Id
    @ManyToOne
    @JoinColumn(name = "party_id")
    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    @Id
    @ManyToOne
    @JoinColumn(name = "role_type_id")
    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Integer getPartyRoleId() {
        return partyRoleId;
    }

    public void setPartyRoleId(Integer partyRoleId) {
        this.partyRoleId = partyRoleId;
    }
}
