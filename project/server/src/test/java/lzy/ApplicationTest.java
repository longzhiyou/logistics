package lzy;


import lzy.module.auth.domain.UserEntity;
import lzy.module.auth.repository.UserRepository;
import lzy.module.party.repository.PartyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationTest.class);


    @Autowired
    UserRepository userRepository;

//    @Autowired
//    PersonService personService;
//
//    @Autowired
//    PartyRepository partyRepository;
//
//    @Autowired
//    PersonRepository personRepository;



    @Autowired
    PartyRepository partyRepository;


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
////        party.setPartyId(IdWorker.getId());
////        Party party1 = partyRepository.save(party);
////        assertNotNull(party1);
//        Person person = new Person();
////        person.setPartyId(IdWorker.getId());
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
    public void partyDelete() throws Exception {

        partyRepository.delete(3);


    }








} 
