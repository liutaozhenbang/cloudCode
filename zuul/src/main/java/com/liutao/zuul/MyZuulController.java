package com.liutao.zuul;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * .
 * Created by liutao20 on 2020/7/28
 */
@RestController
@RequestMapping("myZuul")
public class MyZuulController {

    @GetMapping("init")
    public String initZuul() {
        return "小妹随时都方便  欢迎客官光临";
    }


}
