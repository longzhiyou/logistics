package lzy.utils; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 

/** 
* LicenseGenerator Tester. 
* 
* @author <Authors name> 
* @since <pre>04/05/2017</pre> 
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
* Method: getCPUSerial() 
* 
*/ 
@Test
public void testGetCPUSerial() throws Exception { 
//TODO: Test goes here...
    String serial = LicenseGenerator.getCPUSerial();
    System.out.println("serial" + ": " + serial);

    String license = LicenseGenerator.getLicense();
    System.out.println("license" + ": " + license);

} 

/** 
* 
* Method: getLicense() 
* 
*/ 
@Test
public void testGetLicense() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: matches(String license) 
* 
*/ 
@Test
public void testMatches() throws Exception { 
//TODO: Test goes here... 
} 


} 
