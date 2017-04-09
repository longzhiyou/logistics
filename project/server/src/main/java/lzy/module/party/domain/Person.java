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


@NoArgsConstructor
@Data
@Entity
public class Person  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer partyId;

    @NotEmpty(message="姓名不能为空")
    private String name;
    @Length(max=1,message="密码长度不能小于6位")
    private String gender;

    private Date birthDate;
    private String height;
    private String weight;
    private String maritalStatus;
    private String comments;

}