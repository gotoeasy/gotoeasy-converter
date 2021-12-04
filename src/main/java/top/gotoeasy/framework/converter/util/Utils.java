package top.gotoeasy.framework.converter.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static Date toDate(String strDate) {
        if (!hasText(strDate)) {
            return null;
        }

        Date result = null;
        String strInput = strDate.replace("/", "-");

        if (result == null) {
            result = toDate(strInput, "yyyy-M-d");
        }
        if (result == null) {
            result = toDate(strInput, "yyyy-M-d HH:mm:ss");
        }
        if (result == null) {
            result = toDate(strInput, "yyyyMMdd");
        }
        if (result == null) {
            result = toDate(strInput, "yyyy-M-d HH:mm");
        }
        if (result == null) {
            result = toDate(strInput, "yyyy-M-d HH");
        }
        if (result == null) {
            result = toDate(strInput, "yyyy-M-d HH:mm:ss.SSS");
        }

        return result;
    }

    public static Date toDate(String strDate, String format) {
        if (!hasText(strDate)) {
            return null;
        }

        Date result = null;

        try {
            SimpleDateFormat sdf = getSimpleDateFormat(format);
            result = sdf.parse(strDate);
        } catch (ParseException e) {
        }

        return result;
    }

    public static BigDecimal toBigDecimal(String val) {
        if (!hasText(val)) {
            return null;
        }
        String num = val.replaceAll(",", "");
        if (!hasText(num)) {
            return null;
        }
        return new BigDecimal(num);
    }

    public static BigDecimal toBigDecimal(Integer val) {
        if (val == null) {
            return null;
        }
        return new BigDecimal(val);
    }

    public static BigDecimal toBigDecimal(Long val) {
        if (val == null) {
            return null;
        }
        return new BigDecimal(val);
    }

    public static BigDecimal toBigDecimal(Double val) {
        if (val == null) {
            return null;
        }
        return new BigDecimal(val);
    }

    public static BigDecimal toBigDecimal(Float val) {
        if (val == null) {
            return null;
        }
        return new BigDecimal(val);
    }

    public static boolean hasText(String str) {
        return (str != null && !str.isEmpty() && containsText(str));
    }

    private static boolean containsText(CharSequence str) {
        int strLen = str.length();
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static String formatDate(Object date, String fmt) {
        if (date == null) {
            return "";
        }

        SimpleDateFormat sdf = getSimpleDateFormat(fmt);
        return sdf.format(date);
    }

    private static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>();
    private static Object lockObject = new Object();

    private static SimpleDateFormat getSimpleDateFormat(String format) {
        SimpleDateFormat simpleDateFormat = threadLocal.get();
        if (simpleDateFormat == null) {
            synchronized (lockObject) {
                if (simpleDateFormat == null) {
                    simpleDateFormat = new SimpleDateFormat(format);
                    simpleDateFormat.setLenient(false);
                    threadLocal.set(simpleDateFormat);
                }
            }
        }
        simpleDateFormat.applyPattern(format);
        return simpleDateFormat;
    }

}
