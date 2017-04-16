package lzy.module.customer.service;

import lzy.module.customer.domain.CustomerDomain;
import lzy.module.customer.repository.CustomerRepositoryMybatis;
import lzy.module.party.entity.Customer;
import lzy.module.party.entity.Person;
import lzy.module.party.entity.RoleTypeDefine;
import lzy.module.party.repository.CustomerRepository;
import lzy.module.party.repository.RoleTypeRepository;
import lzy.module.party.service.PersonService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Autowired
    RoleTypeRepository roleTypeRepository;

    @Autowired
    CustomerRepositoryMybatis customerRepositoryMybatis;

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

//        RoleType roleType = roleTypeRepository.findOne(RoleTypeDefine.CUSTOMER);

        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDomain,customer);
//        customer.setPerson(person);
//        customer.setRoleType(roleType);
        customer.setCreditCard(customerDomain.getCreditCard());

        customer.setPartyId(person.getPartyId());
        customer.setRoleTypeId(RoleTypeDefine.CUSTOMER);

        customerRepository.save(customer);
        customerDomain.setPartyId(person.getPartyId());


        return customerDomain;

    }

    public List<CustomerDomain> getCustomers(){

        return customerRepositoryMybatis.findAll();
    }

}
