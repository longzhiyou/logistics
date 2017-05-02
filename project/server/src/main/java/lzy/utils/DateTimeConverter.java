package lzy.utils;

/**
 *  * 日期转换
 * <p>
 * format [yyyy-MM-dd]
 * format [yyyy-MM-dd HH:mm:ss]
 * format [yyyy-MM-dd HH:mm:ss.SSS]
 * Created by longzhiyou on 2015-06-02.
 */

import org.apache.commons.beanutils.Converter;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Locale;

@SuppressWarnings({ "rawtypes" })
public class DateTimeConverter implements Converter {

    private static final String DATE      = "yyyy-MM-dd";
    private static final String DATETIME  = "yyyy-MM-dd HH:mm:ss";
    private static final String TIMESTAMP = "yyyy-MM-dd HH:mm:ss.SSS";
    private static final String TIME  = "HH:mm:ss";
    private static final String TIME_NO_SECOND  = "HH:mm";
    private static final String DATETIME_NO_SECOND  = "yyyy-MM-dd HH:mm";

    @Override
    public Object convert(Class type, Object value) {
        return toDate(type, value);
    }

    public static Object toDate(Class type, Object value) {
        if (value == null || "".equals(value))
            return null;
        if (value instanceof String) {
            String dateValue = value.toString().trim();
            int length = dateValue.length();
            if (type.equals(java.util.Date.class)||type.equals(java.sql.Timestamp.class)) {
                try {
                    DateFormat formatter = null;

                    if (length <= 5) {
                        formatter = new SimpleDateFormat(TIME_NO_SECOND, new DateFormatSymbols(Locale.CHINA));
                        return formatter.parse(dateValue);
                    }
                    if (length <= 8) {
                        formatter = new SimpleDateFormat(TIME, new DateFormatSymbols(Locale.CHINA));
                        return formatter.parse(dateValue);
                    }
                    if (length <= 10) {
                        formatter = new SimpleDateFormat(DATE, new DateFormatSymbols(Locale.CHINA));
                        return formatter.parse(dateValue);
                    }
                    if (length <= 16) {
                        formatter = new SimpleDateFormat(DATETIME_NO_SECOND, new DateFormatSymbols(Locale.CHINA));
                        return formatter.parse(dateValue);
                    }

                    if (length <= 19) {
                        formatter = new SimpleDateFormat(DATETIME, new DateFormatSymbols(Locale.CHINA));
                        return formatter.parse(dateValue);
                    }
                    if (length <= 23) {
                        formatter = new SimpleDateFormat(TIMESTAMP, new DateFormatSymbols(Locale.CHINA));
                        return formatter.parse(dateValue);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return value;
    }
}