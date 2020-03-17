package com.zrx.ichiwanspringboot.utils;

/**
 * Description
 * EntryUtils
 * <p>
 * Data
 * 23:30
 *
 * @author zrx
 * @version 1.0
 */

public class EntryUtils {

    public static final int DAY = 24*60*60*1000;

    public static String minuteToHHmm(int minutes){
        int hours = minutes / 60;
        int lastMinutes = minutes - hours*60;
        return hours+":"+(lastMinutes<10?"0":"")+lastMinutes;
    }

}
