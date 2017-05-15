package lzy.party;


import com.xiaoleilu.hutool.log.Log;
import com.xiaoleilu.hutool.log.LogFactory;
import lzy.module.customer.domain.CustomerDomain;
import lzy.module.customer.service.CustomerService;
import lzy.module.party.entity.*;
import lzy.module.party.person.entity.Person;
import lzy.module.party.person.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PartyTest {

    private static final Log log = LogFactory.get();




    @Autowired
    PartyRepository partyRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    RoleTypeRepository roleTypeRepository;


    @Autowired
    CustomerService customerService;

    @Test
    @Transactional
    @Rollback(false)
    public void createParty(){

        // create new
        Party partyA = new Party();

        Party save = partyRepository.save(partyA);
        assertNotNull(save);

    }

    @Test
    @Transactional
    @Rollback(false)
    public void createPerson() throws Exception {

        Person person = new Person();
        person.setName("longzhiyou-new-1");
        Person newPerson = personRepository.save(person);
        assertNotNull(newPerson);
        log.info(newPerson.toString());

    }
    @Test
    @Transactional
    @Rollback(false)
    public void createCustomer() throws Exception {

        /**
         *  增加一个客户的逻辑
         *  - 创建一个 party
         *  - 创建一个 person
         *  - 创建一个 role_type
         *  - 创建一个 party_role_type
         * [2017-04-10 add by longzhiyou]
         */

        for (int i=0;i<1;i++){

            CustomerDomain customerDomain = new CustomerDomain();
            customerDomain.setName(String.format("lzy-%d",i+100));
            customerDomain.setCreditCard(String.format("CreditCard-%d",i));
            customerDomain = customerService.createByPerson(customerDomain);
            assertNotNull(customerDomain);

            log.info(customerDomain.toString());

        }

    }


    @Test
    public void deletePerson() throws Exception {

        personRepository.delete(862493337779699712L);

    }





} 
