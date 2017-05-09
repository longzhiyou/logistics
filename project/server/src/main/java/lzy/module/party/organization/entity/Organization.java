package lzy.module.party.organization.entity;

import lombok.Data;

import javax.persistence.*;


/**
 * User: longzhiyou
 * Date: 2017/4/7
 * Time: 14:41
 */


@Data
@Entity
public class Organization  {
    @Id
    private Integer partyId;
    private String name;


}
