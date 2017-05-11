package lzy.module.party.person.entity;

import lombok.Data;
import lzy.module.party.entity.Party;

import javax.persistence.*;


/**
 * User: longzhiyou
 * Date: 2017/4/7
 * Time: 14:41
 */


@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Person extends Party {


    //    @Id
//    private Long partyId;
    private String name;


}