
package lzy.module.customer.entity;

import lombok.Getter;
import lombok.Setter;
import lzy.module.party.entity.PartyRole;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
//@IdClass(CustomerPK.class)
public class Customer extends PartyRole{

//    @Id
//    private Long partyId;
//    @Id
//    private Integer roleTypeId;

    private String creditCard;
    private String birthday;
//
//    public String getCreditCard() {
//        return creditCard;
//    }
//
//    public void setCreditCard(String creditCard) {
//        this.creditCard = creditCard;
//    }
    //    @Id
//    @ManyToOne
//    @JoinColumn(name = "party_id")
//    private Person person;
//
//    @Id
//    @ManyToOne
//    @JoinColumn(name = "role_type_id")
//    private RoleType roleType;



}

