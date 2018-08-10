package info.mjy.tools;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.*;

/**
 * @author msh11535
 */
public class BeanUtils {

    public final static boolean isNullOrEmpty(Object value) {
        if (null == value) {
            return true;
        }
        /*****************************************************************************/
        boolean flag = false;
        // 字符串
        if (value instanceof String) {
            // 比较字符串长度, 效率高
            flag = value.toString().trim().length() <= 0;
        }
        // Object[]object数组
        else if (value instanceof Object[]) {
            flag = ((Object[]) value).length == 0;
        }
        // ***********************************************************
        // 集合
        else if (value instanceof Collection) {
            flag = ((Collection) value).isEmpty();
        }
        // map
        else if (value instanceof Map) {
            flag = ((Map) value).isEmpty();
        }
        // 枚举
        else if (value instanceof Enumeration) {
            flag = !((Enumeration) value).hasMoreElements();
        }
        // Iterator迭代器
        else if (value instanceof Iterator) {
            flag = !((Iterator) value).hasNext();
        }
        return flag;
    }

    public static final String PRE_SET = "set";
    public static final String EMPTY_JSON_STRING = "{}";

    /**
     * json字符串转换成java对象，支持
     *
     * @param jsonString
     * @param clazz
     * @param <T>
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws RuntimeException
     */
    public static <T> T toJavaBean(String jsonString, Class<T> clazz) throws IllegalAccessException, InstantiationException, RuntimeException {
        if (!isNullOrEmpty(jsonString) || EMPTY_JSON_STRING.equals(jsonString)) {
            return null;
        }
        Field[] fields = clazz.getDeclaredFields();
        T instance = JSONObject.parseObject(jsonString, clazz);
        for (Field field : fields) {
            if (field.getType() != Integer.TYPE
                    && field.getType() != Long.TYPE
                    && field.getType() != Double.TYPE
                    && field.getType() != Short.TYPE
                    && field.getType() != Float.TYPE
                    && field.getType() != Boolean.TYPE
                    && field.getType() != Byte.TYPE
                    && field.getType() != String.class
                    && field.getType() != BigInteger.class
                    && field.getType() != Date.class) {

                Arrays.stream(clazz.getDeclaredMethods()).filter(method ->
                        (method.getName().equals(PRE_SET
                                + field.getName().substring(0, 1).toUpperCase()
                                + field.getName().substring(1, field.getName().length()))))
                        .forEach(method -> {
                            try {
                                method.invoke(instance,
                                        BeanUtils.toJavaBean(JSONObject.parseObject(jsonString).getString(field.getName()), field.getType()));
                            } catch (Exception e) {
                                e.printStackTrace();
                                throw new RuntimeException("BeanUtils.toJavaBean failed, " + e);
                            }
                        });
            }
        }

        return instance;
    }


}
