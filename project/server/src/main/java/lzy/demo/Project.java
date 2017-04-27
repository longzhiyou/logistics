package lzy.demo;

import lombok.Data;
import lzy.common.domain.nsm.NestedSetEntity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 测试JpaNestedSet 实体类
 * User: longzhiyou
 * Date: 2017/4/27
 * Time: 11:52
 */
@Entity
@Data
public class Project  extends NestedSetEntity {
    @Id
    private Long id;
    private String name;
    private String description;



}
