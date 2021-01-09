package com.liutao.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * .
 * Created by liutao20 on 2020/7/20
 */
@RestController
@RequestMapping("sort")
public class SortController {
    @Autowired
    public SortService selectSort;

    @GetMapping("selectFor")
    public int[] selectSort() {
        return selectSort.selectSort();
//        return new int[]{1,2,4};
    }


}
