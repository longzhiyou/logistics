package lzy.module.party.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;


/**
 * User: longzhiyou
 * Date: 2017/4/7
 * Time: 14:40
 */


@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Party   {
    @Id
//    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long partyId;

}