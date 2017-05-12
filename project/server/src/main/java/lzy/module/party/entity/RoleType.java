package lzy.module.party.entity;
import javax.persistence.*;
import java.util.Set;
/**
 * User: longzhiyou
 * Date: 2017/5/12
 * Time: 10:28
 */
@Entity
public class RoleType {
    private int roleTypeId;
    private String description;
    private Set<PartyRole> partyRoles;

    public RoleType(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getRoleTypeId() {
        return roleTypeId;
    }

    public void setRoleTypeId(int roleTypeId) {
        this.roleTypeId = roleTypeId;
    }


    @OneToMany(mappedBy = "roleType")
    public Set<PartyRole> getPartyRoles() {
        return partyRoles;
    }

    public void setPartyRoles(Set<PartyRole> partyRoles) {
        this.partyRoles = partyRoles;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
