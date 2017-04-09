package lzy.module.party.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;


/**
 * User: longzhiyou
 * Date: 2017/4/7
 * Time: 14:41
 */


@Data
@Entity
public class Person  {
    @Id
    private Integer partyId;
    private String name;


}