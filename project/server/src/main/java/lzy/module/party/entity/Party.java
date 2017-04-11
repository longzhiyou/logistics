package lzy.module.party.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * User: longzhiyou
 * Date: 2017/4/7
 * Time: 14:40
 */


@Data
@Entity
public class Party {
    @Id
    private Long partyId;


}