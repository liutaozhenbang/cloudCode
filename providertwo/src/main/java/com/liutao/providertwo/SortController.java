package com.liutao.providertwo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Random;

/**
 * .
 * Created by liutao20 on 2020/7/20
 */
@RestController
@RequestMapping("sort")
public class SortController {

    @GetMapping("selectSort")
    public String selectSort() {
        String result = "你赢了!!!!!!";
        for (int i = 0; i < 50000; i++) {
            int[] ints = generateIntArray(100, 1000);
//            int[] ints = new int[]{5, 1, 4, 3, 2};
            selectSortInts(ints);
            int[] copyInts = copyInts(ints);
            Arrays.sort(copyInts);
            if (!compareToArray(ints, copyInts)) {
                result = "革命尚未成功，同志仍需努力。。。";
                break;
            }
        }
        System.out.println(result);
        return result;
    }

    @GetMapping("bubbleSort")
    public String bubbleSort() {
        String result = "你赢了!!!!!!";
        for (int i = 0; i < 50000; i++) {
            int[] ints = generateIntArray(100, 1000);
//            int[] ints = new int[]{5, 1, 4, 3, 2};
            bubbleSortInts(ints);
            int[] copyInts = copyInts(ints);
            Arrays.sort(copyInts);
            if (!compareToArray(ints, copyInts)) {
                result = "革命尚未成功，同志仍需努力。。。";
                break;
            }
        }
        System.out.println(result);
        return result;
    }

    @GetMapping("insertionSort")
    public String insertionSort() {
        String result = "你赢了!!!!!!";
        for (int i = 0; i < 50000; i++) {
            int[] ints = generateIntArray(100, 1000);
//            int[] ints = new int[]{5, 1, 4, 3, 2};
            insertionSortInts(ints);
            int[] copyInts = copyInts(ints);
            Arrays.sort(copyInts);
            if (!compareToArray(ints, copyInts)) {
                result = "革命尚未成功，同志仍需努力。。。";
                break;
            }
        }
        System.out.println(result);
        return result;
    }

    private void insertionSortInts(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    private void bubbleSortInts(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int e = arr.length - 1; e > 0; e--) {
            for (int i = 0; i < e; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    private int[] copyInts(int[] ints) {
        int[] newInts = new int[ints.length];
        for (int i = 0; i < ints.length; i++) {
            newInts[i] = ints[i];
        }
        return newInts;
    }

    private void selectSortInts(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
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

    public boolean compareToArray(int[] compareInts, int[] successInts) {
        if (compareInts == null && successInts == null) {
            return true;
        }
        if (compareInts == null || successInts == null) {
            return false;
        }
        if (compareInts.length != successInts.length) {
            return false;
        }
        for (int i = 0; i < compareInts.length; i++) {
            if (compareInts[i] != successInts[i]) {
                return false;
            }
        }
        return true;
    }

}
