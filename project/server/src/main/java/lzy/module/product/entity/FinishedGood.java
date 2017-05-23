package lzy.module.product.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User: longzhiyou
 * Date: 2017/5/23
 * Time: 9:18
 */
@Data
@Entity
public class FinishedGood {
    @Id
    private Integer partId;

}
