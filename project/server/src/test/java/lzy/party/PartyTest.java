package lzy.party;


import com.xiaoleilu.hutool.log.Log;
import com.xiaoleilu.hutool.log.LogFactory;
import lzy.module.customer.service.CustomerService;
import lzy.module.party.person.entity.Person;
import lzy.module.party.person.service.PersonService;
import lzy.module.party.repository.PartyRepository;
import lzy.module.party.repository.PartyRoleTypeRepository;
import lzy.module.party.repository.RoleTypeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PartyTest {

    private static final Log log = LogFactory.get();


    @Autowired
    PersonService personService;

    @Autowired
    PartyRepository partyRepository;

    @Autowired
    RoleTypeRepository roleTypeRepository;

    @Autowired
    PartyRoleTypeRepository partyRoleTypeRepository;

    @Autowired
    CustomerService customerService;

    @Test
    public void createPerson() throws Exception {

        Person person = new Person();
        person.setName("longzhiyou-new-1");
        Person newPerson = personService.create(person);
        assertNotNull(newPerson);
        log.info(newPerson.toString());

    }


} 
