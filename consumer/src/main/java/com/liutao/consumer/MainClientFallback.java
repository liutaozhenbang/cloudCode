package com.liutao.consumer;

import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * .
 * Created by liutao20 on 2020/7/21
 */
@Component
public class MainClientFallback implements MainService {

    @Override
    public String getTestReget() {
        return "小妹现在不方便， 客观稍后再来！！";
    }

    @Override
    public Map postTest(Map<String, Object> map) {
        map.put("name", "小妹现在不方便， 客观稍后再来！！");
        return map;
    }

    @Override
    public String hi() {
        return "小妹现在不方便， 客观稍后再来！！";
    }
}
