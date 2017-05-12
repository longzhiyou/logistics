package lzy;


import com.github.pagehelper.PageInfo;
import lzy.module.customer.service.CustomerService;
import lzy.module.party.person.service.PersonService;
import lzy.sys.auth.domain.UserEntity;
import lzy.sys.auth.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

//@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
public class PageTest {

    private static final Logger logger = LoggerFactory.getLogger(PageTest.class);


    @Autowired
    UserRepository userRepository;

    @Autowired
    PersonService personService;


//    @Autowired
//    PartyRepository partyRepository;



    @Autowired
    CustomerService customerService;


    @Test
    public void findCustomer() throws Exception {


        PageInfo customers = customerService.getCustomers(new PageRequest(0, 20));
        assertNotNull(customers);

        logger.info(customers.toString());

    }

    @Test
    public void findUser() throws Exception {


        Sort sort =  new Sort(Sort.Direction.ASC,"username");


//        Pageable pageable = new PageRequest(1,10,sort);
        Page<UserEntity> users = userRepository.findAll(new PageRequest(0, 20));
//        Page<UserEntity> all = userRepository.findAll(pageable);

//        Iterable<UserEntity> all = userRepository.findAll();
//
        assertNotNull(users);
//
//        logger.info(all.toString());

    }

} 
