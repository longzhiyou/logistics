package lzy.module.party.repository;

/**
 * 本仓库主要是保存声明式角色类型以及上下文角色类型
 * 声明式类型一般由系统初始化定义好
 * User: longzhiyou
 * Date: 2017/4/7
 * Time: 14:42
 */

import lzy.module.party.entity.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleTypeRepository extends JpaRepository<RoleType, Integer>{

}