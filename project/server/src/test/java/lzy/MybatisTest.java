package lzy;


import lzy.module.customer.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisTest {

    private static final Logger logger = LoggerFactory.getLogger(MybatisTest.class);


    @Autowired
    CustomerService customerService;

    @Test
    public void commonService()  {

//        List<Customer> customers = customerService;
//        assertNotNull(customers);
        //5f944592c74518d249bb3e5d58b884c8a2bcca5c7b58cc91e7a64b634ebfc015
//        String license = LicenseGenerator.getLicense();
//        logger.info(customers.toString());

    }










} 
