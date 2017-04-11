package lzy.module.party.entity;

import lombok.Data;

import javax.persistence.*;

/**
 *
 * Created by bukeyan on 2017/4/9.
 */
@Data
@Entity
public class PartyType {
    @Id
    private Integer partyTypeId;
    private String description;


}
