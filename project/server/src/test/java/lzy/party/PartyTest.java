package lzy.party;


import com.xiaoleilu.hutool.log.Log;
import com.xiaoleilu.hutool.log.LogFactory;
import lzy.module.customer.domain.CustomerDomain;
import lzy.module.customer.service.CustomerService;
import lzy.module.party.entity.PartyRole;
import lzy.module.party.entity.RoleType;
import lzy.module.party.entity.RoleTypeRepository;
import lzy.module.party.person.entity.Person;
import lzy.module.party.person.repository.PersonRepository;
import lzy.module.party.person.service.PersonService;
import lzy.module.party.service.PartyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PartyTest {

    private static final Log log = LogFactory.get();




    @Autowired
    PartyService partyService;

    @Autowired
    PersonService personService;

    @Autowired
    RoleTypeRepository roleTypeRepository;



    @Autowired
    PersonRepository personRepository;

    @Autowired
    CustomerService customerService;

    @Test
    public void initParty(){
        partyService.create();
    }

    @Test

    public void createPerson() throws Exception {

        Person person = new Person();
        person.setName("longzhiyou-new-1");
        Person newPerson = personService.create(person);
        assertNotNull(newPerson);
        log.info(newPerson.toString());

    }

    @Test
    @Transactional
    public void searchRoleType() {


        RoleType one = roleTypeRepository.findOne(1);

        Set<PartyRole> partyRoles = one.getPartyRoles();

        Object[] objects = partyRoles.toArray();
//        Person person = (Person) objects[1];

        assertNotNull(one);

    }


    @Test
    public void deletePerson() throws Exception {

        personRepository.delete(862493337779699712L);

    }

    @Test

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
            customerDomain = customerService.create(customerDomain);
            assertNotNull(customerDomain);

            log.info(customerDomain.toString());

        }



    }




} 
