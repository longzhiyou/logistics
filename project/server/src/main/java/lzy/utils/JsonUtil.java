package lzy.utils;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;

/**
 *  小工具类，实现常用的功能,慢慢增加.
 * Created by lzy on 2015-02-09.
 */

public class JsonUtil {
	private static final BigDecimal BIGDECIMAL_ZERO = new BigDecimal("0");

//	static {
//		ConvertUtils.register(new DateTimeConverter(), java.util.Date.class);
//		ConvertUtils.register(new DateConverter(null), java.sql.Date.class);
//		ConvertUtils.register(new DateConverter(null), java.sql.Time.class);
//		ConvertUtils.register(new BigDecimalConverter(BIGDECIMAL_ZERO), BigDecimal.class);
//
//	}

	/**
	 * json字符串转换到java bean
	 * 
	 * @param jsonStr
	 *            json字符串
	 * @param beanClass
	 *            元素类型 用法: TEvaluateScoring scro = json2JavaBean(jsonStr,
	 *            TEvaluateScoring.class);
	 */
	public static <T> T json2JavaBean(String jsonStr, Class<T> beanClass) {

		if (null == jsonStr || jsonStr.isEmpty()) {
			return null;
		}
		try {
			ObjectMapper mapper = new ObjectMapper();

			mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
			// mapper.getSerializationConfig().setDateFormat(new
			// SimpleDateFormat("yyyy-MM-dd"));
			return mapper.readValue(jsonStr, beanClass);

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * json字符串转换到java的集合
	 * 
	 * @param jsonStr
	 *            json字符串
	 * @param collectionClass
	 *            泛型的Collection
	 * @param elementClasses
	 *            元素类型 用法: Map<String,String> map =
	 *            BspUtil.json2JavaCollection(str2
	 *            ,Map.class,String.class,String.class);
	 *            List<AgedPeopleEvaluate> list = json2JavaCollection(jsonStr,
	 *            List.class, AgedPeopleEvaluate.class); List<Integer> listBadl
	 *            = json2JavaCollection(jsonStrBadl, List.class, Integer.class);
	 */
	public static <T> T json2JavaCollection(String jsonStr,
			Class<?> collectionClass, Class<?>... elementClasses) {

		if (null == jsonStr || jsonStr.isEmpty()) {
			return null;
		}
		try {
			ObjectMapper mapper = new ObjectMapper();
			JavaType javaType = mapper.getTypeFactory().constructParametricType(collectionClass,
					elementClasses);
			return mapper.readValue(jsonStr, javaType);

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}



}