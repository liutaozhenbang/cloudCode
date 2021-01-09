package com.liutao.providerone;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * .
 * Created by liutao20 on 2020/7/20
 */
@RestController
@RequestMapping("sort")
public class SortController {

    @GetMapping("selectSort")
    public int[] selectSort() throws InterruptedException {
        Thread.sleep(4000);
        int[] ints = generateIntArray(5, 5);
        selectSortInts(ints);
        return ints;
    }

    private void selectSortInts(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            for (int j = i; j < ints.length; j++) {
                if (ints[i] > ints[j]) {
                    swap(ints, i, j);
                }
            }
        }
    }

    private void swap(int[] ints, int i, int j) {
        int tmp = ints[i];
        ints[i] = ints[j];
        ints[j] = tmp;
    }

    public int[] generateIntArray(int maxSize, int maxValue) {
        int size = new Random().nextInt(maxSize);
        int[] ints = new int[size];
        for (int i = 0; i < size; i++) {
            ints[i] = new Random().nextInt(maxValue);
        }
        return ints;
    }

    public void compareToArray() {

    }

}
