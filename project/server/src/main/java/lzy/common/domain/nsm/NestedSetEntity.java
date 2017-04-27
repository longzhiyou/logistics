package lzy.common.domain.nsm;

import lombok.Data;
import lzy.common.domain.BaseEntity;

import javax.persistence.MappedSuperclass;

/**
 * 包含 嵌套结构和基础实体抽象类
 * User: longzhiyou
 * Date: 2017/4/27
 * Time: 13:20
 */
@Data
@MappedSuperclass
public abstract class NestedSetEntity extends BaseEntity {

    private Long parentId;
    private Integer lft;
    private Integer rgt;
    private String path;
    private Integer level;

}
