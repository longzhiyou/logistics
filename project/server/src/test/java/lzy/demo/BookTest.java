package lzy.demo;


import com.xiaoleilu.hutool.log.Log;
import com.xiaoleilu.hutool.log.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//@RunWith(SpringRunner.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest
public class BookTest {

    private static final Log log = LogFactory.get();




    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private StudentRepository studentRepository;


    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private BookCategoryRepository bookCategoryRepository;


    @Test
    @Transactional
    @Rollback(false)
    public void initCategory()   {

        // save a couple of categories
        final BookCategory categoryA = new BookCategory("Category A");
        Set bookAs = new HashSet<Book>(){{
            add(new Book("Book A1", categoryA));
            add(new Book("Book A2", categoryA));
            add(new Book("Book A3", categoryA));
        }};
        categoryA.setBooks(bookAs);

        final BookCategory categoryB = new BookCategory("Category B");
        Set bookBs = new HashSet<Book>(){{
            add(new Book("Book B1", categoryB));
            add(new Book("Book B2", categoryB));
            add(new Book("Book B3", categoryB));
        }};
        categoryB.setBooks(bookBs);

        bookCategoryRepository.save(new HashSet<BookCategory>() {{
            add(categoryA);
            add(categoryB);
        }});

        // fetch all categories
        for (BookCategory bookCategory : bookCategoryRepository.findAll()) {
            log.info(bookCategory.toString());
        }


    }
    @Test
    @Transactional
    @Rollback(false)
    public void init() throws Exception {

        // create new
        Book bookA = new Book("Book A");

        Publisher publisherA = new Publisher("Publisher A");

        BookPublisher bookPublisher = new BookPublisher();
        bookPublisher.setBook(bookA);
        bookPublisher.setPublisher(publisherA);
        bookPublisher.setPublishedDate(new Date());

        bookA.getBookPublishers().add(bookPublisher);

        publisherRepository.save(publisherA);
        bookRepository.save(bookA);

        // test
        System.out.println(bookA.getBookPublishers().size());

    }


    @Test
    @Transactional
    @Rollback(false)
    public void createBook() throws Exception {

        // create new
        Book bookA = new Book("Book A");
//        bookA.setId(100);

        Publisher publisherA =publisherRepository.findOne(2);

        BookPublisher bookPublisher = new BookPublisher();
        bookPublisher.setBook(bookA);
        bookPublisher.setPublisher(publisherA);
        bookPublisher.setPublishedDate(new Date());

        bookA.getBookPublishers().add(bookPublisher);


        bookRepository.save(bookA);

        // test
        System.out.println(bookA.getBookPublishers().size());

    }


    @Test
    public void searchBook(){


        Iterable<Student> all = studentRepository.findAll(QStudent.student.name.eq("lzy"));
        String s = all.toString();

//        QBook book = QBook.book;
//        BooleanExpression customerHasBirthday = book.name.eq("Book A");
//        Iterable all = bookRepository.findAll(customerHasBirthday);

//        bookRepository.findAll(book.name.eq("Book A")); // 所有用户名为 lufifcc 的用户
//        log.info( all.toString());

    }



} 
