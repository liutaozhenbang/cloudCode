package com.liutao.supone.util;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * .
 * Created by liutao20 on 2020/8/12
 */
public class DateUtil {

//    public static SimpleDateFormat today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

    public static String emptyDefaultDay(String day) {
        if (StringUtils.isEmpty(day)) {
            return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        } else {
            return day;
        }
    }


}
