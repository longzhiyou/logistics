/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package lzy.utils;

import java.security.SecureRandom;
import java.util.UUID;

/**
 * 封装各种生成唯一性ID算法的工具类.
 * @author longzhiyou
 * @version 2015-05-25
 */

public class IdGen {

	private static SecureRandom random = new SecureRandom();
	
	/**
	 * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
	 */
	public static String uuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	/**
	 * 使用SecureRandom随机生成Long. 
	 */
	public static long randomLong() {
		return Math.abs(random.nextLong());
	}

	public static int randomInt() {
		return Math.abs(random.nextInt());
	}


	public String getNextId() {
		return IdGen.uuid();
	}
//
//
//
//	public static void main(String[] args) {
//		System.out.println(IdGen.uuid());
//		System.out.println(IdGen.uuid().length());
//		System.out.println(new IdGen().getNextId());
//		for (int i=0; i<1000; i++){
//			System.out.println(IdGen.randomLong() );
//		}
//	}

}
