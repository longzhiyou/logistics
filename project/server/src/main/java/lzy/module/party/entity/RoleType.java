package lzy.module.party.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
/**
 * User: longzhiyou
 * Date: 2017/5/12
 * Time: 10:28
 */

@Data
@Entity
public class RoleType {
    @Id
    private int roleTypeId;
    private String description;

}
