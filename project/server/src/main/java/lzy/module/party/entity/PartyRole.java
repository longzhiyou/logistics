package lzy.module.party.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 中间表必须实现Serializable
 * User: longzhiyou
 * Date: 2017/5/12
 * Time: 10:29
 */

//@Inheritance(strategy = InheritanceType.JOINED)

@Data
@IdClass(PartyRolePK.class)
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class PartyRole {

    @Id
    private Long partyId;
    @Id
    private Integer roleTypeId;
    private Integer partyRoleId;

}
