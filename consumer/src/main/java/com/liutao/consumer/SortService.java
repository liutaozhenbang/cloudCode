package com.liutao.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * .
 * Created by liutao20 on 2020/7/20
 */
@Component
@FeignClient(name = "ProviderServer", path = "/sort")
public interface SortService {


    @GetMapping("/selectSort")
    int[] selectSort();
}


