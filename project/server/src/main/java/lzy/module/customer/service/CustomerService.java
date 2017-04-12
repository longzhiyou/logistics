package lzy.module.customer.service;

import lzy.module.customer.domain.CustomerDomain;
import lzy.module.party.service.PersonService;
import lzy.module.party.entity.Customer;
import lzy.module.party.entity.Person;
import lzy.module.party.entity.RoleTypeDefine;
import lzy.module.party.repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * User: longzhiyou
 * Date: 2017/4/10
 * Time: 14:35
 */
@Service
public class CustomerService {


    @Autowired
    PersonService personService;

    @Autowired
    CustomerRepository customerRepository;


    @Transactional
    public CustomerDomain create(CustomerDomain customerDomain){

        /**
         *  增加一个人员客户的逻辑
         *  1.Customer属于party_role,所以创建一个 party_role
         *  2.party_role 是party与party_role_type的映射
         *
         * [2017-04-10 add by longzhiyou]
         */


        Person person = new Person();
        BeanUtils.copyProperties(customerDomain,person);
        person = personService.create(person);

        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDomain,customer);
        customer.setPartyId(person.getPartyId());
        customer.setRoleTypeId(RoleTypeDefine.CUSTOMER);

        customer=customerRepository.save(customer);
        customerDomain.setPartyId(customer.getPartyId());
        return customerDomain;

    }

}
