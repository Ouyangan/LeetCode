package com.an;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 排序算法
 */
public class Sort {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            list.add(random.nextInt(100));
        }
        Integer[] integers = list.toArray(new Integer[]{});
        bubbleSort(integers);
    }

    /**
     * 冒泡排序
     * 复杂度为O(n2)
     */
    public static Integer[] bubbleSort(Integer[] array) {
        int len = array.length;
        if (len <= 1) {
            return array;
        }
        for (int i = 0; i < len; i++) {
            boolean swapFlag = false;
            for (int j = 0; j < len - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapFlag = true;
                }
            }
            if (!swapFlag) {
                break;
            }
           print(array,i);
        }
        return array;
    }

    public static void print(Integer[] array,int count) {
        StringBuilder builder = new StringBuilder();
        builder.append("第").append(count + 1).append("次排序:");
        for (Integer i1 : array) {
            builder.append(" ").append(i1).append(" ");
        }
        System.out.println(builder.toString());
    }

}
