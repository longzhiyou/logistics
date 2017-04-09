package lzy.module.party.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;


/**
 * User: longzhiyou
 * Date: 2017/4/7
 * Time: 14:41
 */
@Entity
@Data
@NoArgsConstructor
public class Organization implements Serializable {
    @Id
    @OneToOne
    @JoinColumn(name = "party_id")
    private Party partyOrganization;



}
