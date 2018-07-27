package org.katas.refactoring.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author msh11535
 */
public class DateUtils {

    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static String formatDate(Date date) {
        return new SimpleDateFormat(DATE_TIME_FORMAT).format(date);
    }

}
