package lzy.module.party.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * Created by bukeyan on 2017/4/9.
 */
@Data
@Entity
public class PartyRole implements Serializable {

//    @EmbeddedId
    @Id
    private Integer partyId;
    @Id
    private Integer roleTypeId;
    private Integer partyRoleId;


}
