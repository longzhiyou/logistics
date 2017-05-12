package lzy;


import lzy.sys.auth.domain.UserEntity;
import lzy.sys.auth.repository.UserRepository;
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

//
//    @Autowired
//    PartyRepository partyRepository;
//
//    @Autowired
//    PersonRepository personRepository;



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
////        PartyBak party = new PartyBak();
////        party.setPartyId(IdUtils.getId());
////        PartyBak party1 = partyRepository.save(party);
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
//        List<Party> books = new ArrayList<>();
//
//        bookRepository.save(books);
//
//        // fetch all books
//        for (Party book : bookRepository.findAll()) {
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





//    @Test
//
//    public void testLicenseGenerator()  {
//        //5f944592c74518d249bb3e5d58b884c8a2bcca5c7b58cc91e7a64b634ebfc015
////        String license = LicenseGenerator.getLicense();
////        logger.info(license);
//
//    }










} 
