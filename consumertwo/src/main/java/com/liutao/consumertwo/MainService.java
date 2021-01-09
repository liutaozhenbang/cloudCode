package com.liutao.consumertwo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * .
 * Created by liutao20 on 2020/7/20
 */
@Component
@FeignClient(name = "ProviderServer", path = "/", fallback = MainClientFallback.class)
public interface MainService {


    @GetMapping("getTestReget")
    String getTestReget();

    @PostMapping("postTest")
    Map postTest(@RequestBody Map<String, Object> map);

    @GetMapping("hi")
    String hi();
}
