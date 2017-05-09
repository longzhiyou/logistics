package lzy.demo;

import lzy.sys.auth.domain.UserEntity;
import lzy.sys.auth.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/hello")
    public String index() {

        UserEntity userEntity = new UserEntity();
        userEntity.setEnabled(true);
        userEntity.setUsername("longzhiyouadd");
        userEntity.setPassword("qqq123456");
        UserEntity save = userRepository.save(userEntity);

        userEntity.setUsername("changelongzhiyou");
        save=  userRepository.save(userEntity);

        // fetch all customers
        log.info("Customers found with findAll():");
        log.info("-------------------------------");
//        for (Customer customer : customerRepository.findAll()) {
//            log.info(customer.toString());
//        }
        log.info("");

        return "Greetings from Spring Boot!";
    }
    
}
