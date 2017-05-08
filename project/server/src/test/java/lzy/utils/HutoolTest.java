package lzy.utils;


import com.xiaoleilu.hutool.convert.Convert;
import com.xiaoleilu.hutool.crypto.SecureUtil;
import com.xiaoleilu.hutool.crypto.asymmetric.KeyType;
import com.xiaoleilu.hutool.crypto.asymmetric.RSA;
import com.xiaoleilu.hutool.util.CharsetUtil;
import com.xiaoleilu.hutool.util.HexUtil;
import com.xiaoleilu.hutool.util.StrUtil;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * http://hutool.mydoc.io/?t=184631
 * https://github.com/looly/hutool
 * [2017-05-05 add by longzhiyou]
 */
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
    @Test
    public void rsaTest(){
        RSA rsa = new RSA();
        //获得私钥
        /**
         *  MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAJOY9cLypAwZ/I/CAjkCfkmTQTXc+P2NrJ7tLnerOjGCbPTsUId4g/WUoPlHfv/f3fnZpDMjSNQLqgvmgqaVALh7z5j6YabsOoajVD7619ZUkrWgSwFrggbPXfuoykKaHfjWt/NU7zQQfrNnFo/ZJtSuXD9CE0FSj4u7UEHXosI/AgMBAAECgYAs2UvEQwqKCtNts1wNiq5pGO+1uEGIeiY73IJEJql2JdWJzszhfUNLui/3zzvN8G543yM/zrbwh+LR3udQSvJ+o6A75d4FCfc6fZxsGF1JyHux4nCbyTNDyBFmlqasjXh6jubIUUZ1dQyMtOvDRRKRBFb+9Rg9yzBrmJNlcLrdcQJBAO8/YEjMgXV/j1v+HRB3c4t3kvUOdIfctRIO9ULlvJatCfirrYaORAd2MOck9kWPfMixcKBhIEoxHmBHtA+70/0CQQCd7rbAUNjzCZU7x9qiwTxTVSjP3iNmuvsNVJiCrBlb2LNUZvAp319rdAI8k3ia1/qBN0XgQoinTwrLUwl/mZ3rAkEAo23Hd/M6++iHJXAQqo7ufvbPjFazg5tglVVidLA6gzLw/M1JXAESt4YlIcA9+oZp1y5eoS+3vvaOqXZRqe3EgQJBAIa2IKIIFBWyXd3BCgf7pZY7NHWiODYfVZc4SmJjo7nJLKXYrBA7XSvNpz6+V4hUo3Nmjy7L8b4sWLu314lEogMCQQDkKjqbNJYSMMMMohbFtW2Nw92KEjFcJkMSeONrzIFx9uwjmh3AHS1bKx/+nIanVXD3BgeSTn1bhMZeSVHKW6ah
         * [2017-05-08 add by longzhiyou]
         */
        PrivateKey privateKey = rsa.getPrivateKey();
        String privateKeyBase64 = rsa.getPrivateKeyBase64();

        //获得公钥
        // MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCTmPXC8qQMGfyPwgI5An5Jk0E13Pj9jaye7S53qzoxgmz07FCHeIP1lKD5R37/39352aQzI0jUC6oL5oKmlQC4e8+Y+mGm7DqGo1Q++tfWVJK1oEsBa4IGz137qMpCmh341rfzVO80EH6zZxaP2SbUrlw/QhNBUo+Lu1BB16LCPwIDAQAB
        PublicKey publicKey = rsa.getPublicKey();
        String publicKeyBase64 = rsa.getPublicKeyBase64();

        //告诉客户加密字符串
       String encryptStr = rsa.encryptStr(LicenseGenerator.getCPUSerial(), KeyType.PrivateKey);


        //客户端用公钥解密
        RSA rsaPublic = new RSA(null,publicKeyBase64);

       String decryptStr = rsaPublic.decryptStr(encryptStr, KeyType.PublicKey);
        Assert.assertEquals(LicenseGenerator.getCPUSerial(),decryptStr);

    }

    @Test
    public void getRsaPair(){
        RSA rsa = new RSA();
        //获得私钥
        String privateKeyBase64 = rsa.getPrivateKeyBase64();
        logger.info("私钥:"+privateKeyBase64);

        //获得公钥
        String publicKeyBase64 = rsa.getPublicKeyBase64();
        logger.info("公钥:"+publicKeyBase64);

    }

    @Test
    public void decryptTest(){

        String publicKeyBase64 = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDhKLgXCfcbhUYwX7bqnJT8MCRQHjBhKlzBQ8iIT8WBNPgdwOqbBKDBf7bRcymBI1UrAJWPqN9rzMrkGF48c/rtnTHMLzpjIRiuqWpFC48zNrPfFC79kgbJwy9dql0tBxz7xW0qzW06SInre8W02WV4+EtquuuADo50m37EgxvzjwIDAQAB";
        //客户端用公钥解密
        RSA rsaPublic = new RSA(null,publicKeyBase64);

        String license = "D7ECC49CC78854FEFFF8503699FB5BCA8FF4D4621E8DFB2C597575113DC9062BD19A9D9EF9A456193305C88E2997173526B4577F99C4B79EBFD68CA011977A34998484DE0C125BBA964F959EE789E18EB70166FD2C71E977CCED041C46063E2D28C8D2B4A8656B38BBADE40689F5D5C2E5250EAD902922C2F59DE27BAF275765";
        String decryptStr = rsaPublic.decryptStr(license, KeyType.PublicKey);
        Assert.assertEquals(LicenseGenerator.getCPUSerial(),decryptStr);
    }

    @Test
    public void encryptTest(){

        String privateKeyBase64 = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAOEouBcJ9xuFRjBftuqclPwwJFAeMGEqXMFDyIhPxYE0+B3A6psEoMF/ttFzKYEjVSsAlY+o32vMyuQYXjxz+u2dMcwvOmMhGK6pakULjzM2s98ULv2SBsnDL12qXS0HHPvFbSrNbTpIiet7xbTZZXj4S2q664AOjnSbfsSDG/OPAgMBAAECgYAWaRIhoOlKgPJigDRZl6owi64hl0+jbC79QXzlLGNxH8+OTpRLR6Okfsy4fijkZJrmg9FfEiTiuuh62X4PsE+KRS4yymMz2zazGzyKfm7WtFPdUS3V7C74tA+ZnBKqlXZtU87+JmXXBLG9Uq40HASzHtpcs+5VSswEPUs6qOEEoQJBAPMiNLupsh/LwVNjRO3WcBuvW9IOQUb6+tSC87XvPYZ2j22EMX4R5LQ9T2ClhZ7x8ow+iU3V9pGEsPQ7QnmhkJ8CQQDtEwHS2qj7jH4duTnY/Uehw+OQz0HiifLXRWgfgqu4VuFdbl8tNp+JW/RGUIsiFk+dApONEWhSF1eE58DTcwcRAkEAiMw0M2qVaEJycgKmo9NFnK4b0aJnpBJO0wcjLLiBO4i1xn7cgfx7W9YrNUusVPP47mO5SWwboWCxV5mIG3uGLQJAC6FGEqD1bzmqKi0fAF0UeYQRktYIBmP8DMFz5S/U2rswXRQACUjHtMZVCmoDGU3849fvgxkahARvH676z6Sx8QJAXE03AEx8zn0dWHO/GXarI/0QPs7Y7GnLinJ+SCSP5+Bnm8msLevHKClGpg9AZwz/aaiSKe4l/O0kEVe4N7/9GQ==";
        //客户端用公钥解密
        RSA rsaPrivate = new RSA(privateKeyBase64,null);

        String license = rsaPrivate.encryptStr(LicenseGenerator.getCPUSerial(), KeyType.PrivateKey);
        logger.info(license);
    }

} 
