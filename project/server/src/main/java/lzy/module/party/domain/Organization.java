package lzy.module.party.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


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
