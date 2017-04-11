
package lzy.module.party.entity;

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


}

