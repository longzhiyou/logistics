package lzy.module.party.repository;

/**
 * User: longzhiyou
 * Date: 2017/4/7
 * Time: 14:42
 */

import lzy.module.party.entity.Customer;
import lzy.module.party.entity.CustomerPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, CustomerPK>{

}