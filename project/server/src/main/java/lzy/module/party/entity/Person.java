package lzy.module.party.entity;

import lombok.Data;

import javax.persistence.*;


/**
 * User: longzhiyou
 * Date: 2017/4/7
 * Time: 14:41
 */


@Data
@Entity
public class Person  {
    @Id
    private Long partyId;
    private String name;


}