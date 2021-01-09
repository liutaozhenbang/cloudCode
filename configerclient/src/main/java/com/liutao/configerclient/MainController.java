package com.liutao.configerclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * .
 * Created by liutao20 on 2020/7/31
 */
@RestController
public class MainController {

    @Value("${myPro}")
    private String myPro;

    @GetMapping("test")
    public String test() {
        return "test : " + myPro;
    }


}
