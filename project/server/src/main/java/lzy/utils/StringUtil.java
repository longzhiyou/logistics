package lzy.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;


public class StringUtil {

	final static String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str) {

		if (str == null || "".equals(str.trim())) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isEmpty(String cs) {
		return cs == null || cs.length() == 0;
	}

	public static boolean isNotEmpty(String cs) {
		return !isEmpty(cs);
	}

	/**
	 * SHA-256での暗号化を行う。
	 * 
	 * @param info
	 *            暗号化対象
	 * @return　暗号化されたもの
	 */
	public static String sha256Encrypt(String info) {
		
		if (StringUtil.isEmpty(info)){
			return info;
		}
		
		String ret = null;

		try {
			MessageDigest md5 = MessageDigest.getInstance("SHA-256");
			byte[] srcBytes = info.getBytes();
			md5.update(srcBytes);
			byte[] resultBytes = md5.digest();
			ret = bytes2Hex(resultBytes);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return ret;
	}

	/**
	 * BYTE配列を16進の文字列に変換する。
	 * 
	 * @param bts
	 *            BYTE配列
	 * @return　16進の文字列
	 */
	public static String bytes2Hex(byte[] bts) {

		StringBuilder des = new StringBuilder();
		String tmp = null;
		for (int i = 0; i < bts.length; i++) {
			tmp = Integer.toHexString(bts[i] & 0xFF);
			if (tmp.length() == 1) {
				des.append("0");
			}
			des.append(tmp);
		}

		return des.toString();
	}

	/**
	 * 指定された日付文字列に最小時分秒を追加する
	 * 
	 */
	public static String getMinDateByString(String strDate) {

		// date最小の時間
		String strMin = strDate + "000000";

		return strMin;
	}

	/**
	 * 指定された日付文字列に最大時分秒を追加する
	 * 
	 */
	public static String getMaxDateByString(String strDate) {

		// date最大の時間
		String strMax = strDate + "235959";
		return strMax;
	}

	/**
	 * 指定された日付文字列に最小時分を追加する
	 * 
	 */
	public static String getMinDateByString12(String strDate) {

		// date最小の時間
		String strMin = strDate + "0000";

		return strMin;
	}

	/**
	 * 指定された日付文字列に最大時分を追加する
	 * 
	 */
	public static String getMaxDateByString12(String strDate) {

		// date最大の時間
		String strMax = strDate + "2359";
		return strMax;
	}

	/**
	 * システムDateを24時間のyyyyMMddHHmmssで返す。
	 * 
	 * @return　システムDate
	 */
	public static String getSystemDate() {

		Date date = new Date();
		SimpleDateFormat dTime = new SimpleDateFormat("yyyyMMddHHmmss");
		String strDate = dTime.format(date);

		return strDate;
	}

	/**
	 * システムDateを24時間「yyyy/MM/dd HH:mm」の形で返す（例：2012/01/13 12:15）。
	 * 
	 * @return　システムDate
	 */
	public static String getSystemDate2() {

		Date date = new Date();
		SimpleDateFormat dTime = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		String strDate = dTime.format(date);

		return strDate;
	}

	/**
	 * システムDateを「yyyy/MM/dd」の形で返す（例：2012/01/13）。
	 * 
	 * @return　システムDate
	 */
	public static String getSystemDate3() {

		Date date = new Date();
		SimpleDateFormat dTime = new SimpleDateFormat("yyyy/MM/dd");
		String strDate = dTime.format(date);

		return strDate;
	}

	/**
	 * システムDateを24時間のyyyyMMddHHmmで返す。
	 * 
	 * @return　システムDate
	 */
	public static String getSystemDate4() {

		Date date = new Date();
		SimpleDateFormat dTime = new SimpleDateFormat("yyyyMMddHHmm");
		String strDate = dTime.format(date);

		return strDate;
	}

	/**
	 * システムDateを24時間のyyyyMMddHHmmSSSで返す。
	 * 
	 * @return　システムDate
	 */
	public static String getSystemDate5() {
		Date date = new Date();
		SimpleDateFormat dTime = new SimpleDateFormat("yyyyMMddHHmmSSS");
		String strDate = dTime.format(date);

		return strDate;
	}
	
	/**
	 * システムDateを24時間のyyyyMMddHHmmssSSSで返す。
	 * 
	 * @return　システムDate
	 */
	public static String getSystemDate6() {
		Date date = new Date();
		SimpleDateFormat dTime = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String strDate = dTime.format(date);

		return strDate;
	}

	/**
	 * 指定の数字に0を埋める
	 * 
	 * @param num
	 *            格式化数字
	 * @param len
	 *            桁数
	 * @return
	 */
	public static String fillZero(int num, int len) {

		String ret = "";

		String format = "%1$0" + String.valueOf(len) + "d";

		ret = String.format(format, num);

		return ret;
	}

	/**
	 * 指定の文字列をIntegerに転換
	 * 
	 * @param num
	 *            格式化数字
	 * @return　Integer
	 */
	public static Integer stringToInteger(String num) {

		Integer ig = null;

		if (isBlank(num)) {
			return null;
		}

		ig = Integer.valueOf(num.replace(",", ""));

		return ig;
	}

	/**
	 * 将传入的文字转为Decimal类型
	 * @param numStr
	 * @return
	 */
	public static BigDecimal stringToDecimal(String numStr) {
		BigDecimal num = null;
		
		if (isBlank(numStr) == false) {
			try {
				numStr = numStr.replace(",", "");
				num = new BigDecimal(numStr);
			} catch (Exception e) {
				return num;				
			}
		}
		return num;
	}
	
	
	/**
	 * 指定金額フォーマット
	 * 
	 * @param money
	 *            金額
	 * @return　String
	 */
	public static String formatMoney(String money) {

		if (isBlank(money)) {
			return money;
		}

		Double dMoney = Double.valueOf(money);
		NumberFormat cFormat = NumberFormat.getNumberInstance();
		String ret = cFormat.format(dMoney);

		// 小数点を切り捨て
		int i = ret.indexOf(".");
		if (i > 0) {
			ret = ret.substring(0, i);
		}

		return ret;
	}

	/**
	 * 指定時間フォーマット（Double時間）
	 * 
	 * @param time
	 *            時間
	 * @return　String
	 */
	public static String formatTimes(Double time) {

		String format = "%1$,1.2f";
		String ret = String.format(format, time);

		return ret;
	}

	/**
	 * 指定時間フォーマット（Ingeger時間）
	 * 
	 * @param time
	 * @return　String
	 */
	public static String formatTimes(Integer time) {

		Double dTime = Double.valueOf(time);
		String format = "%1$,1.2f";
		String ret = String.format(format, dTime);

		return ret;
	}

	/**
	 * 指定時間フォーマット（ジャーナル時間）
	 * 
	 * @param time
	 * @return　String
	 */
	public static String formatTimes(String time) {

		if (isBlank(time)) {
			return time;
		}
		Double timeTemp = Double.parseDouble(time);

		String format = "%1$,1.2f";
		String ret = String.format(format, timeTemp);

		return ret;
	}

	/**
	 * 指定金額を格式文字列にフォーマットする
	 * 
	 * @param money
	 *            金額
	 * @return　String
	 */
	public static String formatMoneyToString(Integer money) {

		if (money == null) {
			return "";
		}

		String format = "%1$-10d";
		String ret = String.format(format, money);

		return ret.trim();
	}

	/**
	 * FILECD格式
	 * 
	 * @param fileCd
	 * @return　String
	 */
	public static String fileCdformat(String fileCd) {

		if (fileCd == null) {

		} else {
			fileCd = fileCd.trim();
		}

		return fileCd;
	}

	/**
	 * 错误信息的格式化
	 * 
	 * @param code
	 *            　错误编号
	 * @param message
	 *            错误信息
	 * @return 格式化后的错误信息
	 * @since 01-00
	 */
	public static String formatMessage(String code, String message) {

		StringBuilder sb = new StringBuilder();
		sb.append(message).append("(").append(code).append(")");
		return sb.toString();
	}

	/**
	 * 根据Form转换成easyUI用的JSON格式
	 * 
	 * @param result
	 *            JSON格式
	 * @return 无
	 */
	public static String toJsonByObject(Object result) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(result);
			return json.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 根据传入的数字， 产生相应长度的随机数
	 * @param n 随机数长度
	 * @return 随机数
	 */
	public static String getRandStr(int n) {
		Random random = new Random();
		String sRand = "";
		for (int i = 0; i < n; i++) {
			String rand = String.valueOf(random.nextInt(10));
			sRand += rand;
		}
		return sRand;
	}
	
	/**
	 * 根据传入的数字， 产生 【年月日时分秒毫秒+传入长度 随机数】
	 * @return 20位 随机数
	 */
	public static String getRandNo(int n) {
		String randNo = DateUtils.toString(new Date(), "yyyyMMddHHmmssSSS") + StringUtil.getRandStr(n);
		return randNo;
	}
	
	/**
	 * 将传入的String转为数字
	 * @param param
	 * @return
	 */
	public static int parseInt(String param) {
		if (isEmpty(param)) {
			return 0;
		} else {
			return Integer.parseInt(param);
		}
	}
	
	/**
	 * 将传入的String对象转为数字
	 * @param param
	 * @return
	 */
	public static BigDecimal parseDecimal(String param) {
		if (isEmpty(param)) {
			return new BigDecimal(0);
		} else {
			param = param.replace(",", "");
			return new BigDecimal(param);
		}
	}
	

    /**
     * 按天计算实际费用
     * @param inValue 总费用
     * @param startDate 开始日
     * @param endDate 结束日(为null时，取得结算日进行计算)
     * @param instituteId 机构ID
     * @return 计算结果
     */
    public static BigDecimal getDaysCost(BigDecimal inValue, Date startDate, Date endDate, String instituteId) {
        BigDecimal decReturn = inValue;
        if(decReturn!=null){
	        Date calEndDate = endDate;
	        /*if (calEndDate == null) {
	            // 传入的结束日为null时，取得结算日
	            calEndDate = getAccountDay(startDate);
	        }*/
	        // 计算用天数类型
	        /*String strFlag = MasterGetter.getMessageByCode("calculateDaysFlag");
	        if ("1".equals(strFlag)) {
	            // 按固定总天数计算
	            // 取得固定天数
	            int calDays = getFixDays(instituteId);
	            // 实际计算天数
	            int betweenDays = getBetweenDays(startDate, calEndDate);
	            decReturn = inValue.multiply(new BigDecimal(betweenDays)).divide(new BigDecimal(calDays), 2, BigDecimal.ROUND_HALF_UP);
	        } else if ("2".equals(strFlag)) {*/
	            // 按实际天数计算
	            Calendar startCal = Calendar.getInstance();
	            Calendar endCal = (Calendar) startCal.clone();
	            startCal.setTime(startDate);
	            endCal.setTime(calEndDate);
	            if (startCal.get(Calendar.MONTH) == endCal.get(Calendar.MONTH)) {
	                // 月份相同时，取得当月最大天数
	                int calDays = startCal.getActualMaximum(Calendar.DATE);
	                // 实际计算天数
	                int betweenDays = getBetweenDays(startDate, calEndDate);
	                decReturn = inValue.multiply(new BigDecimal(betweenDays)).divide(new BigDecimal(calDays), 2, BigDecimal.ROUND_HALF_UP);
	            } else {
	                // 开始日与结束日跨月时，总天数分别按各自月份的总天数计算
	                // 开始日当月天数
	                int startDays = startCal.getActualMaximum(Calendar.DATE);
	                // 开始月的月末日
	                startCal.set(Calendar.DAY_OF_MONTH, startCal.getActualMaximum(Calendar.DAY_OF_MONTH));
	                int startBetweenDays = getBetweenDays(startDate, startCal.getTime());
	                decReturn = inValue.multiply(new BigDecimal(startBetweenDays)).divide(new BigDecimal(startDays), 2, BigDecimal.ROUND_HALF_UP);

	                // 结束日当月天数
	                int endDays = endCal.getActualMaximum(Calendar.DATE);
	                endCal.set(Calendar.DAY_OF_MONTH, endCal.getActualMinimum(Calendar.DAY_OF_MONTH));
	                int endBetweenDays = getBetweenDays(endCal.getTime(), calEndDate);
	                BigDecimal endRate = inValue.multiply(new BigDecimal(endBetweenDays)).divide(new BigDecimal(endDays), 2, BigDecimal.ROUND_HALF_UP);
	                decReturn = decReturn.add(endRate);
	            }
	        //}
	        return decReturn;
        }else{
        	return new BigDecimal("0.00");
        }
    }

    /**
     * 从定义文件取得定义的计算天数
     * @param instituteId 机构ID
     * @return 定义的计算天数
     */
    /*public static int getFixDays(String instituteId) {
        int intFixDays = 30;
        String strFixDays = "";
        if (isNotEmpty(instituteId)) {
            // 取得指定机构计算天数
            strFixDays = MasterGetter.getMessageByCode(instituteId + "_days");
        }
        if (isEmpty(strFixDays)) {
            // 机构计算天数不存在，取固定天数
            strFixDays = MasterGetter.getMessageByCode("days");
        }
        if (isNotEmpty(strFixDays)) {
            intFixDays = Integer.parseInt(strFixDays);
        }
        return intFixDays;
    }*/


    
    /**
     * 取得实际天数
     * @param startDate 开始日
     * @param endDate 结束日
     * @return
     */
    public static int getBetweenDays(Date startDate, Date endDate) {
        Calendar cal = Calendar.getInstance();
        // 开始时间
        cal.setTime(startDate);
        long startTime = cal.getTimeInMillis();
        // 结束时间
        cal.setTime(endDate);
        long endTime = cal.getTimeInMillis();
        // 计算天数
        long betweenDays = (endTime - startTime) / (1000 * 3600 * 24);
        // 开始日及结束日当天都计算
        betweenDays++;
        
        return Integer.parseInt(String.valueOf(betweenDays));
    }
	public static String getServiceId(String serviceId){
		String ret = "A001";
		if (serviceId == null || "A001".compareTo(serviceId)>0){
			return ret;
		}
		if (serviceId.equals("ZZZZ")){
			return "ZZZZ";
		}
		String inchar1 = serviceId.substring(0,1);
		String inchar2 = serviceId.substring(1,2);
		String inchar3 = serviceId.substring(2,3);
		String inchar4 = serviceId.substring(3,4);
		inchar4 = add(inchar4);
		if (inchar4 == null){
			inchar4 = "0";
			inchar3 = add(inchar3);
			if (inchar3 == null){
				inchar3 = "0";
				inchar2 = add(inchar2);
				if (inchar2 == null){
					inchar2 = "0";
					inchar1 = add(inchar1);
				}
			}
		}
		return inchar1 + inchar2 + inchar3 + inchar4;
	}
	public static String add(String in){
		if ("Z".equals(in)){
			return null;
		} else {
			int i = chars.indexOf(in);
			return String.valueOf(chars.charAt(i+1));
		}
	}
}
