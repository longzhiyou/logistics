package lzy.module.customer.repository;

import lzy.module.customer.domain.CustomerDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * User: longzhiyou
 * Date: 2017/4/7
 * Time: 14:42
 */
@Mapper
public interface CustomerRepositoryMybatis {

    /** 查找客户列表
     * @return
     */
    @Select("SELECT * " +
            "FROM customer " +
            "LEFT JOIN person ON person.party_id = customer.party_id")
    List<CustomerDomain> findAll();


}