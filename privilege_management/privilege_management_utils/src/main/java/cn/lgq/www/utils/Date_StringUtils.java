package cn.lgq.www.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间与字符串间的相互转换
 */
public class Date_StringUtils {

    public static String dateToString(Date date,String format){
        String transfer = null;
        try {
            SimpleDateFormat dateformat = new SimpleDateFormat(format);
            transfer = dateformat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transfer;
    }

    public static Date stringToDate(String string,String format){
        Date date = null;
        try {
            SimpleDateFormat dateformat = new SimpleDateFormat(format);
            date = dateformat.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


}
