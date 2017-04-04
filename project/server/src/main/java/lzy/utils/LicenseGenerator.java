package lzy.utils;

import java.io.IOException;
import java.util.Scanner;

/**
 * 序列号生成类
 * Created by bukeyan on 2017/4/4.
 */
public class LicenseGenerator {

    /**
     * 获取系统cpu序列号
     * wmic cpu get ProcessorId 命令获取
     * @return 序列号
     */
    public static String getCPUSerial() {
        String serial = "";
        try {
            long start = System.currentTimeMillis();
            Process process = Runtime.getRuntime().exec(
                    new String[]{"wmic", "cpu", "get", "ProcessorId"});
            process.getOutputStream().close();
            Scanner sc = new Scanner(process.getInputStream());
            String property = sc.next();
            serial = sc.next();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return serial;
    }

    public static String getLicense(){
       return StringUtil.sha256Encrypt(getCPUSerial());
    }

    public static  boolean matches(String license) {
        boolean equals = StringUtil.sha256Encrypt(getCPUSerial()).equals(license);
        return equals;
    }

}
