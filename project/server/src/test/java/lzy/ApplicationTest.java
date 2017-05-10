package lzy;


import com.github.pagehelper.PageInfo;
import lzy.sys.auth.domain.UserEntity;
import lzy.sys.auth.repository.UserRepository;
import lzy.module.customer.domain.CustomerDomain;
import lzy.module.customer.service.CustomerService;
import lzy.module.party.entity.PartyRoleType;
import lzy.module.party.person.entity.Person;
import lzy.module.party.repository.PartyRepository;
import lzy.module.party.repository.PartyRoleTypeRepository;
import lzy.module.party.repository.RoleTypeRepository;
import lzy.module.party.person.service.PersonService;
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
public class ApplicationTest {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationTest.class);

//    @Autowired
//    private MockMvc mvc;
//
//    @MockBean
//    private StorageService storageService;


    @Autowired
    UserRepository userRepository;

    @Autowired
    PersonService personService;
//
//    @Autowired
//    PartyRepository partyRepository;
//
//    @Autowired
//    PersonRepository personRepository;



    @Autowired
    PartyRepository partyRepository;

    @Autowired
    RoleTypeRepository roleTypeRepository;

    @Autowired
    PartyRoleTypeRepository partyRoleTypeRepository;

    @Autowired
    CustomerService customerService;



//    @Test
//    public void shouldSaveUploadedFile() throws Exception {
//        MockMultipartFile multipartFile =
//                new MockMultipartFile("file", "test.txt", "text/plain", "Spring Framework".getBytes());
//        this.mvc.perform(fileUpload("/").file(multipartFile))
//                .andExpect(status().isFound())
//                .andExpect(header().string("Location", "/"));
//
//        then(this.storageService).should().store(multipartFile);
//    }

    @Test
    @Transactional
    @Rollback(false)
    public void testJpa() throws Exception {

        UserEntity userEntity = new UserEntity();
        userEntity.setEnabled(true);
        userEntity.setUsername("aaaa");
        userEntity.setPassword("password");
        UserEntity save = userRepository.save(userEntity);
        assertNotNull(save);

    }

//    @Test
//    @Transactional
//    @Rollback(false)
//    public void createPerson() throws Exception {
//
////        Party party = new Party();
////        party.setPartyId(IdUtils.getId());
////        Party party1 = partyRepository.save(party);
////        assertNotNull(party1);
//        Person person = new Person();
////        person.setPartyId(IdUtils.getId());
//        person.setCurrentName("lzy-new");
//        Person save = personRepository.save(person);
//        assertNotNull(save);
//
//    }
//
//    @Test
//    @Transactional
//    @Rollback(false)
//    public void testPersonDelete() throws Exception {
//
//
//        personRepository.delete(850177879256858624L);
//
//
//    }
//
//    @Test
//    @Transactional
//    @Rollback(false)
//    public void deleteParty() throws Exception {
//
//
//        partyRepository.delete(850179287079190528L);
//
//
//    }

//    @Test
//    @Transactional
//    @Rollback(false)
//    public void books() throws Exception {
//
//
//        // save a couple of books
//        List<Book> books = new ArrayList<>();
//
//        bookRepository.save(books);
//
//        // fetch all books
//        for (Book book : bookRepository.findAll()) {
//            logger.info(book.toString());
//        }
//
//    }
//
//    @Test
//    @Transactional
//    @Rollback(false)
//    public void booksDelete() throws Exception {
//
//        bookRepository.delete(2);
//
//
//    }

    @Test
    @Transactional
    @Rollback(false)
    public void testParty() throws Exception {

//        Party party = new Party();
//        party.setPartyId(10);

//        Party one = partyRepository.findOne(2);
//        assertNotNull(one);
//        partyRepository.delete(2);

//        RoleType one = roleTypeRepository.findOne(1);
//        assertNotNull(one);

        PartyRoleType one = partyRoleTypeRepository.findOne(1);
        assertNotNull(one);

        logger.info(one.toString());


    }




    @Test
    @Transactional
    @Rollback(false)
    public void findCustomer() throws Exception {

        PageInfo customers = customerService.getCustomers(new PageRequest(0, 20));
        assertNotNull(customers);

        logger.info(customers.toString());

    }
    @Test
    @Transactional
    @Rollback(false)
    public void testCustomer() throws Exception {

        /**
         *  增加一个客户的逻辑
         *  - 创建一个 party
         *  - 创建一个 person
         *  - 创建一个 role_type
         *  - 创建一个 party_role_type
         * [2017-04-10 add by longzhiyou]
         */

        for (int i=1;i<3;i++){

            CustomerDomain customerDomain = new CustomerDomain();
            customerDomain.setName(String.format("lzy-%d",i+100));
            customerDomain.setCreditCard(String.format("CreditCard-%d",i));
            customerDomain = customerService.create(customerDomain);
            assertNotNull(customerDomain);

            logger.info(customerDomain.toString());

        }



    }

    @Test

    public void testLicenseGenerator()  {
        //5f944592c74518d249bb3e5d58b884c8a2bcca5c7b58cc91e7a64b634ebfc015
//        String license = LicenseGenerator.getLicense();
//        logger.info(license);

    }










} 
