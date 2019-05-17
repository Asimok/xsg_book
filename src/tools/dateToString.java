package tools;

/*
 * nowdateToString() 将指定的的日期类型数据转换成字符串并返回
 *
 * */


import java.text.SimpleDateFormat;
import java.util.Date;

public class dateToString {


    public static String nowdateToString() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String reStr = sdf.format(date);
        System.out.println(reStr);
        return reStr;
    }

}
