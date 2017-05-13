
package lzy.module.customer.entity;

import lombok.Data;
import lzy.module.party.entity.PartyRole;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Data
@Entity
//@IdClass(CustomerPK.class)
public class Customer {

    @Id
    private Long partyId;
//    @Id
//    private Integer roleTypeId;

//    private String creditCard;
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

