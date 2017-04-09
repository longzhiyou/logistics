package lzy.module.party.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;


/**
 * User: longzhiyou
 * Date: 2017/4/7
 * Time: 14:40
 */


@Entity
@Data
@NoArgsConstructor
public class Party implements Serializable{
    @Id
    private int partyId;
    private String name;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "partyPerson")
    private Person person;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "partyOrganization")
    private Organization organization;



}