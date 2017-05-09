
package lzy.module.customer.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@IdClass(CustomerPK.class)
public class Customer {

    @Id
    private Long partyId;
    @Id
    private Integer roleTypeId;

    private String creditCard;

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

