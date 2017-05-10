package lzy.utils;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * User: longzhiyou
 * Date: 2017/5/8
 * Time: 11:50
 */
@SpringBootTest
public class PasswordEncoderTest {

    @Test
    public void matchTest(){
        String pass = "hello";
        BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
        String hashPass = encode.encode(pass);
        System.out.println(hashPass);


    }
}
