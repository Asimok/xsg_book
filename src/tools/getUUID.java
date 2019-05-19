package tools;
/*
 * getUUID32() 随机生成uuid
 * */

import java.util.UUID;

public class getUUID {

    public static String getUUID32() {
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        return uuid;
        //聽 return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }

}
