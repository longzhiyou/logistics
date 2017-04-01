package lzy.utils;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 日付の格式転換
 *  * @author cwg
 * 
 */
public class DateUtil {

    public static final int LENGTH5 = 5;
	public static final int LENGTH6 = 6;
	public static final int LENGTH7 = 7;
	public static final int LENGTH8 = 8;
	public static final int LENGTH10 = 10;
	public static final int LENGTH12 = 12;
	public static final int LENGTH14 = 14;
	public static final int LENGTH16 = 16;
	public static final int LENGTH17 = 17;
	public static final int LENGTH19 = 19;
	public static final int LENGTH19_2 = 192;

    /**
     * 格式：HH:mm
     */
    private static SimpleDateFormat format5 = new SimpleDateFormat("HH:mm");
    
    private static SimpleDateFormat formatTotime = new SimpleDateFormat("HH:mm:ss");
	/**
	 * 格式：yyyyMM
	 */
	private static SimpleDateFormat format6 = new SimpleDateFormat("yyyyMM");
	/**
	 * 格式：yyyyMMdd
	 */
	private static SimpleDateFormat format8 = new SimpleDateFormat("yyyyMMdd");
	/**
	 * 格式：yyyy-MM-dd
	 */
	private static SimpleDateFormat format10 = new SimpleDateFormat(
			"yyyy-MM-dd");
	/**
	 * 格式：yyyyMMddHHmm
	 */
	private static SimpleDateFormat format12 = new SimpleDateFormat(
			"yyyyMMddHHmm");
	/**
	 * 格式：yyyyMMddHHmmss
	 */
	private static SimpleDateFormat format14 = new SimpleDateFormat(
			"yyyyMMddHHmmss");
	/**
	 * 格式：yyyyMMddHHmmssSSS
	 */
	private static SimpleDateFormat format17 = new SimpleDateFormat(
			"yyyyMMddHHmmssSSS");
	/**
	 * 格式：yyyy/MM
	 */
	private static SimpleDateFormat formatSlash7 = new SimpleDateFormat(
			"yyyy/MM");
	/**
	 * 格式：yyyy/MM/dd
	 */
	private static SimpleDateFormat formatSlash10 = new SimpleDateFormat(
			"yyyy/MM/dd");
	/**
	 * 格式：MM/dd
	 */
	private static SimpleDateFormat formatSlash20 = new SimpleDateFormat(
			"MM/dd");
	/**
	 * 格式：yyyy/MM/dd hh:mm
	 */
	private static SimpleDateFormat formatSlash16 = new SimpleDateFormat(
			"yyyy/MM/dd HH:mm");
	/**
	 * 格式：yyyy/MM/dd hh:mm:ss
	 */
	private static SimpleDateFormat formatSlash19 = new SimpleDateFormat(
			"yyyy/MM/dd HH:mm:ss");

	/**
	 * 格式：yyyy/MM/dd hh:mm:ss
	 */
	private static SimpleDateFormat formatMinus19 = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	/**
	 * 格式：yyyy-MM-dd
	 */
	private static SimpleDateFormat formatSlash_10 = new SimpleDateFormat(
			"yyyy-MM-dd");

	/**
	 * 取得指定日期所在月份的日数。
	 * @param date
	 * @return
     */
	public static int getDaysOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		calendar.set(Calendar.DATE, 1);
		calendar.roll(Calendar.DATE, -1);
		int maxDate = calendar.get(Calendar.DATE);
		return maxDate;
	}

	/**
	 * 取得指定日期的下一天。
	 * @param date
	 * @return
     */
	public static Date getNextDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 1);
		return calendar.getTime();
	}

	/**
	 * 取得指定日期的前一天。
	 * @param date
	 * @return
	 */
	public static Date getPreDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, -1);
		return calendar.getTime();
	}


	/**
	 * 取得0时0分0秒
	 * @param date
	 * @return
     */
	public static Date getMinDate(Date date) {
		if(date == null) {
			return null;
		}

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar.getTime();
	}

	/**
	 * 取得23时59分59秒
	 * @param date
	 * @return
	 */
	public static Date getMaxDate(Date date) {
		if(date == null) {
			return null;
		}

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);

		return calendar.getTime();
	}


	/**
	 * 指定された文字列を日付に転換する() YYYY/MM/DD　+　”00；00；00”　→　Date
	 */
	public synchronized static Date getMinDateByString(String strDate) {

		// date最小の時間
		String strMin = strDate + "000000";
		Date dateFrom;
		try {
			dateFrom = format14.parse(strMin);
			return dateFrom;
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	/**
	 * 指定された文字列を日付に転換する() YYYY-MM-DD　+　”00；00；00”　→　Date
	 */
	public synchronized static String getMinDateString(String strDate) {

		// date最小の時間
		String strMin = strDate + " 00:00:00";

		return strMin;
	}
	
	/**
	 * 指定された文字列を日付に転換する() YYYY-MM-DD　+　”23:59:59”　→　Date
	 */
	public synchronized static String getMaxDateString(String strDate) {

		// date最小の時間
		String strMin = strDate + " 23:59:59";

		return strMin;
	}

	/**
	 * 指定された文字列を日付に転換する() YYYY/MM/DD　+　”00；00；00”　→　Date
	 */
	public synchronized static Date getMaxDateByString(String strDate) {

		// date最大の時間
		String strMax = strDate + "235959";
		Date dateTo;
		try {
			dateTo = format14.parse(strMax);
			return dateTo;
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 日付文字列から日付データに変換する
	 * 
	 * @param string
	 *            　yyyyMM、yyyyMMdd、yyyyMMddHHmm、yyyyMMddHHmmss
	 * @param stringLenth
	 * @return
	 */
	public synchronized static Date praseString2Date(String string) {
		try {
			if (string == null || string.length() == 0) {
				return null;
			}
			switch (string.length()) {
			case LENGTH14:
				return format14.parse(string);
			case LENGTH12:
				return format12.parse(string);
			case LENGTH10:
				return format10.parse(string);
			case LENGTH8:
				return format8.parse(string);
			case LENGTH6:
				return format6.parse(string);
			case LENGTH17:
				return format17.parse(string);
			case LENGTH19:
				return formatMinus19.parse(string);
			default:
				break;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Timestamp praseString2Timestamp(String string) {
		Timestamp retTime = null;
		
		Date paramDate = praseString2Date(string);
		if (paramDate != null) {
			retTime = new Timestamp(paramDate.getTime());
		}
		return retTime;
	}
	
	public static Time praseString2Time(String string) {
		Time retTime = null;
        Date date=null;
        try {
            date = formatTotime.parse(string);
            retTime = new Time(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return retTime;
	}
	

	/**
	 * 日付文字列から日付データに変換する
	 * 
	 * @param string
	 *            　yyyyMM、yyyyMMdd、yyyyMMddHHmm、yyyyMMddHHmmss
	 * @param stringLenth
	 * @return
	 */
	public synchronized static java.sql.Date praseString2SqlDate(String string) {
		Date utilDate = null;
		java.sql.Date sqlDate = null;
		try {
			if (string == null || string.length() == 0) {
				return null;
			}
			switch (string.length()) {
			case LENGTH14:
				utilDate = format14.parse(string);
				break;
			case LENGTH12:
				utilDate = format12.parse(string);
				break;
			case LENGTH10:
				utilDate = format10.parse(string);
				break;
			case LENGTH8:
				utilDate = format8.parse(string);
				break;
			case LENGTH6:
				utilDate = format6.parse(string);
				break;
			default:
				break;
			}
			
			if (utilDate != null) {
				sqlDate = new java.sql.Date(utilDate.getTime());
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return sqlDate;
	}

	/**
	 * 日付データからに日付文字列変換する
	 * 
	 * @param date
	 * @param stringLenth
	 * @return
	 */
	public synchronized static String parseDate2String(Date date, int stringLenth) {

		if (date == null) {
			return "";
		}
		switch (stringLenth) {
		case LENGTH19_2:
			return formatMinus19.format(date);
		case LENGTH19:
			return formatSlash19.format(date);
		case LENGTH16:
			return formatSlash16.format(date);
		case LENGTH14:
			return format14.format(date);
		case LENGTH12:
			return format12.format(date);
		case LENGTH10:
			return formatSlash10.format(date);
		case LENGTH8:
			return format8.format(date);
		case LENGTH7:
			return formatSlash7.format(date);
		case LENGTH6:
			return format6.format(date);
		default:
			break;
		}
		return null;
	}
	

    /**
     * 日付データからに日付文字列変換する
     * 
     * @param date
     * @param stringLenth
     * @return
     */
    public synchronized static String parseTimeStamp2String(Timestamp timeStamp, int stringLenth) {

        if (timeStamp == null) {
            return "";
        }
        switch (stringLenth) {
        case LENGTH19:
            return formatSlash19.format(timeStamp);
        case LENGTH16:
            return formatSlash16.format(timeStamp);
        case LENGTH14:
            return format14.format(timeStamp);
        case LENGTH12:
            return format12.format(timeStamp);
        case LENGTH10:
            return formatSlash10.format(timeStamp);
        case LENGTH8:
            return format8.format(timeStamp);
        case LENGTH7:
            return formatSlash7.format(timeStamp);
        case LENGTH6:
            return format6.format(timeStamp);
        case LENGTH5:
            return format5.format(timeStamp);
        default:
            break;
        }
        return null;
    }

	/**
	 * 指定された日付文字列にスラッシュを追加する
	 * 
	 * @param date
	 *            　6桁、8桁、12桁の日付
	 * @param stringLenth
	 *            　変換した後桁数
	 * @return　変換した後日付文字列
	 */
	public synchronized static String addSlashStringDate(String date, int stringLenth) {

		try {

			if (StringUtil.isBlank(date)) {
				return "";
			}
			date = date.trim();
			Date dt = null;
			switch (date.length()) {
			case LENGTH6:
				dt = format6.parse(date);
				break;
			case LENGTH8:
				dt = format8.parse(date);
				break;
			case LENGTH12:
				dt = format12.parse(date);
				break;
			case LENGTH14:
				dt = format14.parse(date);
				break;
			default:
				return "";
			}

			String ret = "";

			switch (stringLenth) {
			case LENGTH7:
				ret = formatSlash7.format(dt);
				break;
			case LENGTH10:
				ret = formatSlash10.format(dt);
				break;
			case LENGTH16:
				ret = formatSlash16.format(dt);
				break;
			case LENGTH19:
				ret = formatSlash19.format(dt);
				break;
			default:
				break;
			}

			return ret;
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return "";
	}

	/**
	 * 指定された日付文字列からスラッシュを削除する
	 * 
	 * @param date
	 *            　7桁、10桁、16桁、19桁の日付
	 * @param stringLenth
	 *            　変換した後桁数
	 * @return　変換した後日付文字列
	 */
	public synchronized static String removeSlashStringDate(String date, int stringLenth) {

		try {
			if (date == null || date.length() == 0) {
				return "";
			}
			Date dt = null;
			switch (date.length()) {
			case LENGTH7:
				dt = formatSlash7.parse(date);
				break;
			case LENGTH10:
				dt = formatSlash10.parse(date);
				break;
			case LENGTH16:
				dt = formatSlash16.parse(date);
				break;
			case LENGTH19:
				dt = formatSlash19.parse(date);
				break;
			default:
				return date;
			}

			String ret = "";
			switch (stringLenth) {
			case LENGTH6:
				ret = format6.format(dt);
				break;
			case LENGTH8:
				ret = format8.format(dt);
				break;
			case LENGTH12:
				ret = format12.format(dt);
				break;
			case LENGTH14:
				ret = format14.format(dt);
				break;
			default:
				break;
			}

			return ret;

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return "";
	}

	/**
	 * 日付の時刻を取得する。
	 * 
	 * @param date
	 * @return　時刻　ｈｈ：ｍｍ
	 */
	public static String getDateime(Object date) {

		String time = "";
		if (date instanceof String) {
			time = addSlashStringDate(date.toString(), LENGTH16).substring(11,
					16);
		} else if (date instanceof Date) {
			time = parseDate2String((Date) date, LENGTH16).substring(11, 16);
		}
		return time;
	}

	/**
	 * システム日付を取得する。
	 * 
	 * @return　システム日付
	 */
	public static Date getSystemDate() {

		Date date = new Date();
		return date;
	}

	/**
	 * 指定された日付文字列の判断
	 * 
	 * @param date
	 *            　6桁、8桁、12桁、14桁の日付（/無）、7桁、10桁、16桁、19桁の日付（/有）
	 * @param stringLenth
	 *            　変換した後桁数
	 * @return　変換した後日付文字列
	 */
	public synchronized static boolean isDate(String date) {
		try {
			switch (date.length()) {
			case LENGTH6:
				format6.parse(date);
				break;
			case LENGTH8:
				format8.parse(date);
				break;
			case LENGTH12:
				format12.parse(date);
				break;
			case LENGTH14:
				format14.parse(date);
				break;
			case LENGTH7:
				formatSlash7.parse(date);
				break;
			case LENGTH10:
				formatSlash10.parse(date);
				break;
			case LENGTH16:
				formatSlash16.parse(date);
				break;
			case LENGTH19:
				formatSlash19.parse(date);
				break;
			default:
				return false;
			}
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	public static Date parseStrToDateYYYYMMdd(String str){
    	Date ret = null;
    	try {
    		ret = formatSlash10.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return ret;
    }
	
	public static Date parseStrToDateFor19(String str){
		Date ret = null;
		try {
			ret = formatSlash19.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	/**
	 * yyyy/MM/dd 日付を取得する。
	 * 
	 * @param date
	 * @return　日付　yyyy/MM/dd
	 */
	public static String getFormattedYMD(String date) {

		StringBuilder sb = new StringBuilder();
		if (StringUtil.isBlank(date) || date.length() < 8) {
			return "";
		}
		sb.append(date.substring(0, 4));
		sb.append("/");
		sb.append(date.substring(4, 6));
		sb.append("/");
		sb.append(date.substring(6, 8));
		return sb.toString();
	}

	/**
	 * hh:mm 時間を取得する。
	 * 
	 * @param date
	 * @return　時間　hh:mm
	 */
	public static String getFormattedHM(String time) {

		StringBuilder sb = new StringBuilder();
		if (StringUtil.isBlank(time) || time.length() != 4) {
			return "";
		}
		sb.append(time.substring(0, 2));
		sb.append(":");
		sb.append(time.substring(2, 4));
		return sb.toString();
	}

	/**
	 * 二つデーターの日数差を計算する
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 * @throws Exception
	 */
	public static long dateDiff(String d1, String d2) throws Exception {
		SimpleDateFormat dTime = null;
		dTime = new SimpleDateFormat("yyyyMMdd");
		d1 = d1.substring(0, 8);
		d2 = d2.substring(0, 8);
		Date d3 = dTime.parse(d1);
		Date d4 = dTime.parse(d2);
		long n1 = d3.getTime();
		long n2 = d4.getTime();
		long diff = Math.abs(n1 - n2);

		diff /= 3600 * 1000 * 24;
		return diff;
	}

	public synchronized static Date praseString3Date(String string) {
		try {
			if (string == null || string.length() == 0) {
				return null;
			}
			return formatSlash_10.parse(string);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public synchronized static String parseDate2Stringforformat10(Date date) {
		if (date == null) {
			return "";
		}
		return format10.format(date);
	}
	
	
	
	/**
	 * 获取现在时间
	 * 
	 * @return 返回时间类型 yyyy-MM-dd HH:mm:ss
	 */
	public static Date getNowDate() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		ParsePosition pos = new ParsePosition(8);
		Date currentTime_2 = formatter.parse(dateString, pos);
		return currentTime_2;
	}

	/**
	 * 获取现在时间
	 * 
	 * @return返回短时间格式 yyyy-MM-dd
	 */
	public static Date getNowDateShort() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(currentTime);
		ParsePosition pos = new ParsePosition(0);
		Date currentTime_2 = formatter.parse(dateString, pos);
		return currentTime_2;
	}

	/**
	 * 获取现在时间
	 * 
	 * @return返回字符串格式 yyyy-MM-dd HH:mm:ss
	 */
	public static String getStringDate() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 获取现在时间
	 * 
	 * @return 返回短时间字符串格式yyyy-MM-dd
	 */
	public static String getStringDateShort() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 获取时间 小时:分;秒 HH:mm:ss
	 * 
	 * @return
	 */
	public static String getTimeShort() {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		Date currentTime = new Date();
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 将长时间格式字符串转换为时间 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param strDate
	 * @return
	 */
	public static Date strToDateLong(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}

	/**
	 * 将长时间格式时间转换为字符串 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param dateDate
	 * @return
	 */
	public static String dateToStrLong(Date dateDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(dateDate);
		return dateString;
	}

	/**
	 * 将短时间格式时间转换为字符串 yyyy-MM-dd
	 * 
	 * @param dateDate
	 * @param
	 * @return
	 */
	public static String dateToStr(Date dateDate) {
		if (dateDate == null){
			return "";
		}
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(dateDate);
		return dateString;
	}

	/**
	 * 将短时间格式字符串转换为时间 yyyy-MM-dd
	 * 
	 * @param strDate
	 * @return
	 */
	public static Date strToDate(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}

	/**
	 * 得到现在时间
	 * 
	 * @return
	 */
	public static Date getNow() {
		Date currentTime = new Date();
		return currentTime;
	}

	/**
	 * 提取一个月中的最后一天
	 * 
	 * @param day
	 * @return
	 */
	public static Date getLastDate(long day) {
		Date date = new Date();
		long date_3_hm = date.getTime() - 3600000 * 34 * day;
		Date date_3_hm_date = new Date(date_3_hm);
		return date_3_hm_date;
	}

	/**
	 * 得到现在时间
	 * 
	 * @return 字符串 yyyyMMdd HHmmss
	 */
	public static String getStringToday() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HHmmss");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 得到现在小时
	 */
	public static String getHour() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		String hour;
		hour = dateString.substring(11, 13);
		return hour;
	}

	/**
	 * 得到现在分钟
	 * 
	 * @return
	 */
	public static String getTime() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		String min;
		min = dateString.substring(14, 16);
		return min;
	}

	/**
	 * 根据用户传入的时间表示格式，返回当前时间的格式 如果是yyyyMMdd，注意字母y不能大写。
	 * 
	 * @param sformat
	 *            yyyyMMddhhmmss
	 * @return
	 */
	public static String getUserDate(String sformat) {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(sformat);
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 二个小时时间间的差值,必须保证二个时间都是"HH:MM"的格式，返回字符型的分钟
	 */
	public static String getTwoHour(String st1, String st2) {
		String[] kk = null;
		String[] jj = null;
		kk = st1.split(":");
		jj = st2.split(":");
		if (Integer.parseInt(kk[0]) < Integer.parseInt(jj[0]))
			return "0";
		else {
			double y = Double.parseDouble(kk[0]) + Double.parseDouble(kk[1])
					/ 60;
			double u = Double.parseDouble(jj[0]) + Double.parseDouble(jj[1])
					/ 60;
			if ((y - u) > 0)
				return y - u + "";
			else
				return "0";
		}
	}

	/**
	 * 得到二个日期间的间隔天数
	 */
	public static String getTwoDay(String sj1, String sj2) {
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
		long day = 0;
		try {
			Date date = myFormatter.parse(sj1);
			Date mydate = myFormatter.parse(sj2);
			day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
		} catch (Exception e) {
			return "";
		}
		return day + "";
	}

	/**
	 * 时间前推或后推分钟,其中JJ表示分钟.
	 */
	public static String getPreTime(String sj1, String jj) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String mydate1 = "";
		try {
			Date date1 = format.parse(sj1);
			long Time = (date1.getTime() / 1000) + Integer.parseInt(jj) * 60;
			date1.setTime(Time * 1000);
			mydate1 = format.format(date1);
		} catch (Exception e) {
		}
		return mydate1;
	}

	/**
	 * 得到一个时间延后或前移几天的时间,nowdate为时间,delay为前移或后延的天数
	 */
	public static String getNextDay(String nowdate, String delay) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String mdate = "";
			Date d = strToDate(nowdate);
			long myTime = (d.getTime() / 1000) + Integer.parseInt(delay) * 24
					* 60 * 60;
			d.setTime(myTime * 1000);
			mdate = format.format(d);
			return mdate;
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 判断是否润年
	 * 
	 * @param ddate
	 * @return
	 */
	public static boolean isLeapYear(String ddate) {

		/**
		 * 详细设计： 1.被400整除是闰年，否则： 2.不能被4整除则不是闰年 3.能被4整除同时不能被100整除则是闰年
		 * 3.能被4整除同时能被100整除则不是闰年
		 */
		Date d = strToDate(ddate);
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(d);
		int year = gc.get(Calendar.YEAR);
		if ((year % 400) == 0)
			return true;
		else if ((year % 4) == 0) {
			if ((year % 100) == 0)
				return false;
			else
				return true;
		} else
			return false;
	}

	/**
	 * 返回美国时间格式 26 Apr 2006
	 * 
	 * @param str
	 * @return
	 */
	public static String getEDate(String str) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(str, pos);
		String j = strtodate.toString();
		String[] k = j.split(" ");
		return k[2] + k[1].toUpperCase() + k[5].substring(2, 4);
	}

	/**
	 * 获取一个月的最后一天
	 * 
	 * @param dat
	 * @return
	 */
	public static String getEndDateOfMonth(String dat) {// yyyy-MM-dd
		String str = dat.substring(0, 8);
		String month = dat.substring(5, 7);
		int mon = Integer.parseInt(month);
		if (mon == 1 || mon == 3 || mon == 5 || mon == 7 || mon == 8
				|| mon == 10 || mon == 12) {
			str += "31";
		} else if (mon == 4 || mon == 6 || mon == 9 || mon == 11) {
			str += "30";
		} else {
			if (isLeapYear(dat)) {
				str += "29";
			} else {
				str += "28";
			}
		}
		return str;
	}

	/**
	 * 判断二个时间是否在同一个周
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isSameWeekDates(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(date1);
		cal2.setTime(date2);
		int subYear = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
		if (0 == subYear) {
			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2
					.get(Calendar.WEEK_OF_YEAR))
				return true;
		} else if (1 == subYear && 11 == cal2.get(Calendar.MONTH)) {
			// 如果12月的最后一周横跨来年第一周的话则最后一周即算做来年的第一周
			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2
					.get(Calendar.WEEK_OF_YEAR))
				return true;
		} else if (-1 == subYear && 11 == cal1.get(Calendar.MONTH)) {
			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2
					.get(Calendar.WEEK_OF_YEAR))
				return true;
		}
		return false;
	}

	/**
	 * 产生周序列,即得到当前时间所在的年度是第几周
	 * 
	 * @return
	 */
	public static String getSeqWeek() {
		Calendar c = Calendar.getInstance(Locale.CHINA);
		String week = Integer.toString(c.get(Calendar.WEEK_OF_YEAR));
		if (week.length() == 1)
			week = "0" + week;
		String year = Integer.toString(c.get(Calendar.YEAR));
		return year + week;
	}

	/**
	 * 获得一个日期所在的周的星期几的日期，如要找出2002年2月3日所在周的星期一是几号
	 * 
	 * @param sdate
	 * @param num
	 * @return
	 */
	public static String getWeek(String sdate, String num) {
		// 再转换为时间
		Date dd = strToDate(sdate);
		Calendar c = Calendar.getInstance();
		c.setTime(dd);
		if (num.equals("1")) // 返回星期一所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		else if (num.equals("2")) // 返回星期二所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
		else if (num.equals("3")) // 返回星期三所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
		else if (num.equals("4")) // 返回星期四所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
		else if (num.equals("5")) // 返回星期五所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		else if (num.equals("6")) // 返回星期六所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		else if (num.equals("0")) // 返回星期日所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
	}

	/**
	 * 根据一个日期，返回是星期几的字符串
	 * 
	 * @param sdate
	 * @return
	 */
	public static String getWeek(String sdate) {
		// 再转换为时间
		Date date = strToDate(sdate);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		// int hour=c.get(Calendar.DAY_OF_WEEK);
		// hour中存的就是星期几了，其范围 1~7
		// 1=星期日 7=星期六，其他类推
		return new SimpleDateFormat("EEEE").format(c.getTime());
	}

	public static String getWeekStr(String sdate) {
		String str = "";
		str = getWeek(sdate);
		if ("1".equals(str)) {
			str = "星期日";
		} else if ("2".equals(str)) {
			str = "星期一";
		} else if ("3".equals(str)) {
			str = "星期二";
		} else if ("4".equals(str)) {
			str = "星期三";
		} else if ("5".equals(str)) {
			str = "星期四";
		} else if ("6".equals(str)) {
			str = "星期五";
		} else if ("7".equals(str)) {
			str = "星期六";
		}
		return str;
	}
	
    public static String getWeekNumToStr(String sdate) {
        String str = "";
        if ("1".equals(sdate)) {
            str = "星期日";
        } else if ("2".equals(sdate)) {
            str = "星期一";
        } else if ("3".equals(sdate)) {
            str = "星期二";
        } else if ("4".equals(sdate)) {
            str = "星期三";
        } else if ("5".equals(sdate)) {
            str = "星期四";
        } else if ("6".equals(sdate)) {
            str = "星期五";
        } else if ("7".equals(sdate)) {
            str = "星期六";
        }
        return str;
    }
	/**
	 * 两个时间之间的天数
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long getDays(String date1, String date2) {
		if (date1 == null || date1.equals(""))
			return 0;
		if (date2 == null || date2.equals(""))
			return 0;
		
		long day = 0;
		// 转换为标准时间
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		Date mydate = null;
		try {
			date = myFormatter.parse(date1);
			mydate = myFormatter.parse(date2);
			day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
		} catch (Exception e) {
		}
		
		return day;
	}

	/**
	 * 形成如下的日历 ， 根据传入的一个时间返回一个结构 星期日 星期一 星期二 星期三 星期四 星期五 星期六 下面是当月的各个时间
	 * 此函数返回该日历第一行星期日所在的日期
	 * 
	 * @param sdate
	 * @return
	 */
	public static String getNowMonth(String sdate) {
		// 取该时间所在月的一号
		sdate = sdate.substring(0, 8) + "01";

		// 得到这个月的1号是星期几
		Date date = strToDate(sdate);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int u = c.get(Calendar.DAY_OF_WEEK);
		String newday = getNextDay(sdate, (1 - u) + "");
		return newday;
	}

	/**
	 * 取得数据库主键 生成格式为yyyyMMddHHmmss+k位随机数
	 * 
	 * @param k
	 *            表示是取几位随机数，可以自己定
	 */

	public static String getNo(int k) {

		return getUserDate("yyyyMMddHHmmss") + getRandom(k);
	}

	/**
	 * 返回一个随机数
	 * 
	 * @param i
	 * @return
	 */
	public static String getRandom(int i) {
		Random jjj = new Random();
		// int suiJiShu = jjj.nextInt(9);
		if (i == 0)
			return "";
		String jj = "";
		for (int k = 0; k < i; k++) {
			jj = jj + jjj.nextInt(9);
		}
		return jj;
	}

	/**
	 * 
	 * @param args
	 */
	public static boolean RightDate(String date) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		if (date == null)
			return false;
		if (date.length() > 10) {
			sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		} else {
			sdf = new SimpleDateFormat("yyyy-MM-dd");
		}
		try {
			sdf.parse(date);
		} catch (ParseException pe) {
			return false;
		}
		return true;
	}

	/**
	 * 根据年龄获取对应的生日日期
	 * 
	 * @param age
	 * @return 生日字符串
	 */
	public static String getDateForAge(Integer age) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());

		calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH)
				- 365 * age);
		Date date = calendar.getTime();

		return dateToStr(date);
	}
	

    /**
     * 根据日期获取几号
     * 
     * @param strDate 日期
     * @return 月的几日
     */
    public static String getDay(String strDate) {

        Date date = praseString2Date(strDate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int day = calendar.get(Calendar.DAY_OF_MONTH);

        return String.valueOf(day);
    }
    

    
    public static long getIntervalDay(String startDate, String endDate) {
        
        if (startDate == null || startDate.equals(""))
            return 0;
        if (endDate == null || endDate.equals(""))
            return 0;
        
        long day = 0;
        // 转换为标准时间
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyyMMdd");
        Date date = null;
        Date mydate = null;
        try {
            date = myFormatter.parse(endDate);
            mydate = myFormatter.parse(startDate);
            day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
        } catch (Exception e) {
        }
        return day;
    }
    
    /**
     * 将传入的时间字符串转为Timestamp类型
     * @param timeStr
     * @return
     */
    public static Timestamp praseTime2Date(String timeStr) {
    	
    	Timestamp sysTime = null;
    	
    	if (timeStr != null && !"".equals(timeStr)) {
        	Date sysDate = new Date();
    		
        	int hour = Integer.parseInt(timeStr.split(":")[0]);
        	int minute = Integer.parseInt(timeStr.split(":")[1]);
        	Calendar cal = Calendar.getInstance();
    		cal.setTime(sysDate);
    		cal.set(Calendar.HOUR_OF_DAY, hour);
    		cal.set(Calendar.MINUTE, minute);
    		cal.set(Calendar.SECOND, 00);
    		
    		sysTime = new Timestamp(cal.getTime().getTime());
    	}
		
		return sysTime;
    }
    
    public static Date parseStrToDateMMdd(String str){
    	Date ret = null;
    	try {
    		ret = formatSlash20.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return ret;
    }
    
	
	/**
	 * 把日期转换成字符串型
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String toString(Date date, String pattern){
		if(date == null){
			return "";
		}
		if(pattern == null){
			pattern = "yyyy-MM-dd";;
		}
		String dateString = "";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			dateString = sdf.format(date);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return dateString;
	}

	/**
	 * 获取星期的第一天
	 * 
	 * @param date
	 * @return date
	 */
	public static Date getFirstDayOfWeek(Date date) {
		Calendar calendar = Calendar.getInstance();
        /**
         *要先设置setFirstDayOfWeek为周一
         * [2016-04-24 add by longzhiyou]
         */
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(date);
		//本周第一天，以星期日开始
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return calendar.getTime();
	}
	
	/**
	 * 获取星期的最后一天
	 * 
	 * @param date
	 * @return date
	 */
	public static Date getLastDayOfWeek(Date date) {


        /**
         *要先设置setFirstDayOfWeek为周一
         * [2016-04-24 add by longzhiyou]
         */
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);

        calendar.setTime(date);

        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);

        return calendar.getTime();
	}
	
	/**
	 * 日期往前增加一天
	 */
	public static Date dateAddOneDay(Date date) {
		if(date == null){
			return null;
		}
	    Calendar calendar  = Calendar.getInstance();
	    calendar.setTime(date); 
	    calendar.add(Calendar.DATE,1);//把日期往后增加一天.整数往后推,负数往前移动
	    Date newDate=calendar.getTime();
		return newDate;
	}
	
	public static String parseTime2String(Time time, String formatStr) {
		Date inDate = new Date(time.getTime());
		
		String timeStr = DateUtil.toString(inDate, formatStr);
		return timeStr;
	}
	public static String parseTime2String(Time time) {
		Date inDate = new Date(time.getTime());
		
		String timeStr = DateUtil.toString(inDate, "HH:mm:ss");
		return timeStr;
	}
	/**
	 * 日期往前增加指定天
	 */
	public static String dateAddDays(String strDate, int day) {
		Date date = strToDate(strDate);
		if(date == null){
			return null;
		}
	    Calendar calendar  = Calendar.getInstance();
	    calendar.setTime(date); 
	    calendar.add(Calendar.DATE,day);
	    Date newDate=calendar.getTime();
	    String retDate = dateToStr(newDate);
		return retDate;
	}
	/**
	 * 日期往前增加指定天
	 */
	public static Date dateAddDays(Date date, int day) {
		if(date == null){
			return null;
		}
		Calendar calendar  = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE,day);//把日期往后增加一天.整数往后推,负数往前移动
		Date newDate=calendar.getTime();
		return newDate;
	}
	/**
	 * 日期往前增加指定天
	 */
	public static String dateAddDays1(String strDate, int day) {
		Date date = chgDate(strDate);
		if(date == null){
			return null;
		}
	    Calendar calendar  = Calendar.getInstance();
	    calendar.setTime(date); 
	    calendar.add(Calendar.DATE,day);
	    Date newDate=calendar.getTime();
	    String retDate = dateChgStr(newDate);
		return retDate;
	}
	/**
	 * 日期往前增加指定天
	 */
	public static String dateAddMonth(String strDate, int month) {
		Date date = chgDate(strDate);
		if(date == null){
			return null;
		}
	    Calendar calendar  = Calendar.getInstance();
	    calendar.setTime(date); 
	    calendar.add(Calendar.MONTH,month);
	    Date newDate=calendar.getTime();
	    String retDate = dateChgStr(newDate);
		return retDate;
	}
	public static Date chgDate(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}
	public static java.sql.Date chgSqlDate(String strDate) {
		String chgDate = strDate;
		if (StringUtil.isNotEmpty(chgDate)&&strDate.length() == 8){
			chgDate = strDate.substring(0,4) + "-" + strDate.substring(4,6) + "-" +strDate.substring(6,8);
		}
		java.sql.Date sqlDate=java.sql.Date.valueOf(chgDate);
		return sqlDate;
	}
	/**
	 * 将短时间格式时间转换为字符串 yyyyMMdd
	 * 
	 * @param dateDate
	 * @param
	 * @return
	 */
	public static String dateChgStr(Date dateDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String dateString = formatter.format(dateDate);
		return dateString;
	}

    /**
     * 将长时间格式字符串转换为时间 ，指定输入的格式
     * 
     * @param strDate
     * @return
     */
    public static Date strToDateLong(String strDate, String inFormate) {
        SimpleDateFormat formatter = new SimpleDateFormat(inFormate);
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }
    
    /**
     * 将长时间格式字符串转换为sql时间 ，指定输入的格式
     * 
     * @param strDate 日期字符串
     * @param inFormate 参数strDate的值的格式
     * @return
     */
    public static java.sql.Date strToSqlDateLong(String strDate, String inFormate) {
        SimpleDateFormat formatter = new SimpleDateFormat(inFormate);
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        java.sql.Date sqlDate = new java.sql.Date(strtodate.getTime());
        return sqlDate;
    }
	/**
	 * 日期加减
	 */
	public static Date dateAdd(Date inDate, int number , int type) {
		Calendar calendar  = Calendar.getInstance();
		calendar.setTime(inDate);
		calendar.add(type,number);
		Date newDate=calendar.getTime();
		return newDate;
	}
}
