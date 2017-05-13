package lzy.module.party.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * User: longzhiyou
 * Date: 2017/4/7
 * Time: 14:40
 */


@Inheritance(strategy = InheritanceType.JOINED)
@Data
@Entity
public class Party {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "lzy.common.domain.IdGenerator")
    @GeneratedValue(generator = "idGenerator")
    private Long partyId;

    @OneToMany(mappedBy = "party",cascade={CascadeType.ALL})
    private Set<PartyRole> partyRoles;

    public Party() {
        partyRoles = new HashSet<>();
    }


//    @GeneratedValue(strategy = GenerationType.AUTO)
//    public Long getPartyId() {
//        return partyId;
//    }
//
//    public void setPartyId(Long partyId) {
//        this.partyId = partyId;
//    }


//    public Set<PartyRole> getPartyRoles() {
//        return partyRoles;
//    }
//
//    public void setPartyRoles(Set<PartyRole> partyRoles) {
//        this.partyRoles = partyRoles;
//    }
}