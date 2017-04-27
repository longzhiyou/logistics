package lzy.common.domain.nsm;

import lombok.Data;

import javax.persistence.MappedSuperclass;

/**
 * 嵌套结构抽象类
 * User: longzhiyou
 * Date: 2017/4/27
 * Time: 13:20
 */
@Data
@MappedSuperclass
public abstract class NestedSet  {

    private Long parentId;
    private Integer lft;
    private Integer rgt;
    private String path;
    private Integer topLevel;

}
