package test.lzy.utils;

import lzy.utils.LicenseGenerator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * LicenseGenerator Tester.
 *
 * @author <Authors name>
 * @since <pre>���� 4, 2017</pre>
 * @version 1.0
 */
public class LicenseGeneratorTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     *
     * Method: main(String[] args)
     *
     */
    @Test
    public void testMain() throws Exception {
//TODO: Test goes here...
        // TODO Auto-generated method stub

        String serial = LicenseGenerator.getCPUSerial();
        System.out.println("serial" + ": " + serial);

        String license = LicenseGenerator.getLicense();
        System.out.println("license" + ": " + license);

    }


} 
