package lzy.utils;


import com.xiaoleilu.hutool.convert.Convert;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HutoolTest {

    private static final Logger logger = LoggerFactory.getLogger(HutoolTest.class);


    @Test
    public void convertTest() throws Exception {

        int a = 1;
        long[] b = {1,2,3,4,5};

        String aStr = Convert.toStr(a);
        Assert.assertEquals("1", aStr);
        String bStr = Convert.toStr(b);
        Assert.assertEquals("[1, 2, 3, 4, 5]", Convert.toStr(bStr));

//        assertNotNull(one);

    }


} 
