package info.mjy.tools;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

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

}
