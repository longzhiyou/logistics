package lzy.module.party.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * User: longzhiyou
 * Date: 2017/4/7
 * Time: 14:40
 */


@Inheritance(strategy = InheritanceType.JOINED)
@Data
@Entity
public class Party {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "lzy.common.domain.IdGenerator")
    @GeneratedValue(generator = "idGenerator")
    private Long partyId;


}