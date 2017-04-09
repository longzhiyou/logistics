package lzy.module.party.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
