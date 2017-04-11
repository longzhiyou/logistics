package lzy.module.party.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * Created by bukeyan on 2017/4/9.
 */
@Data
@Entity
public class PartyRoleType {
    @Id
    private Integer roleTypeId;


}
