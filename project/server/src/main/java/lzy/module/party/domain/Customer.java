
package lzy.module.party.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@IdClass(CustomerPK.class)
public class Customer {

    @Id
    private Integer partyId;
    @Id
    private Integer roleTypeId;
    private String firstName;
    private String lastName;



}

