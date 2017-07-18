package lzy.module.customer.repository;

/**
 * http://spring.io/blog/2011/04/26/advanced-spring-data-jpa-specifications-and-querydsl
 * http://blog.csdn.net/xiejx618/article/details/51480265 springData使用QueryDsl
 * User: longzhiyou
 * Date: 2017/4/7
 * Time: 14:42
 */

import lzy.module.customer.entity.Customer;
import lzy.module.party.entity.PartyRolePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface CustomerRepository extends JpaRepository<Customer, PartyRolePK>
        {



}