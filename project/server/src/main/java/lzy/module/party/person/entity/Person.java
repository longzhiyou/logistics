package lzy.module.party.person.entity;

import lombok.Data;

import javax.persistence.*;


/**
 * User: longzhiyou
 * Date: 2017/4/7
 * Time: 14:41
 */


//@Data
@Entity
public class Person  {

//    @Id
    private Long partyId;
    private String name;

    @Id
    public Long getPartyId() {
        return partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}