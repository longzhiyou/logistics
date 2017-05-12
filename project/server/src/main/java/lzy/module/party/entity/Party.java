package lzy.module.party.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * User: longzhiyou
 * Date: 2017/4/7
 * Time: 14:40
 */


@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
public class Party {


    private Long partyId;
    private Set<PartyRole> partyRoles;

    public Party() {
        partyRoles = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getPartyId() {
        return partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }

    @OneToMany(mappedBy = "party",cascade={CascadeType.ALL}, orphanRemoval = true)
    public Set<PartyRole> getPartyRoles() {
        return partyRoles;
    }

    public void setPartyRoles(Set<PartyRole> partyRoles) {
        this.partyRoles = partyRoles;
    }
}