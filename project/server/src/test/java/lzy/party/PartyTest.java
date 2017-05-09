package lzy.party;


import com.github.pagehelper.PageInfo;
import lzy.module.customer.domain.CustomerDomain;
import lzy.module.customer.service.CustomerService;
import lzy.module.party.entity.PartyRoleType;
import lzy.module.party.person.entity.Person;
import lzy.module.party.person.service.PersonService;
import lzy.module.party.repository.PartyRepository;
import lzy.module.party.repository.PartyRoleTypeRepository;
import lzy.module.party.repository.RoleTypeRepository;
import lzy.sys.auth.domain.UserEntity;
import lzy.sys.auth.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertNotNull;

//@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
public class PartyTest {

    private static final Logger logger = LoggerFactory.getLogger(PartyTest.class);


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


} 
