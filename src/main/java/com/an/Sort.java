package com.an;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 排序算法
 */
public class Sort {
    public static void main(String[] args) {

        bubbleSort(createArray());
        System.out.println("================");
        insertSort(createArray());
    }

    public static Integer[] createArray() {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(100));
        }
        Integer[] integers = list.toArray(new Integer[]{});
        return integers;
    }

    /**
     * 插入排序
     * O(n^2)
     */
    public static Integer[] insertSort(Integer[] array) {
        int len = array.length;
        if (len <= 1) {
            return array;
        }
        for (int i = 1; i < len; i++) {
            Integer val = array[i];
            //查询插入位置
            int j = i - 1;
            //注意array[i]之前的元素是已经排好序的
            //于是可以从array[i-1]向前遍历与当前val相比较，如果比val大的话则往后移动一位
            for (; j >= 0; --j) {
                if (array[j] > val) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            //最终j+1就是插入的位置了
            array[j+1] = val;
            print(array,i-1);
        }
        return array;
    }

    /**
     * 冒泡排序
     * 复杂度为O(n^2)
     * 原地排序
     * 稳定排序
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
            print(array, i);
        }
        return array;
    }

    public static void print(Integer[] array, int count) {
        StringBuilder builder = new StringBuilder();
        builder.append("第").append(count + 1).append("次排序:");
        for (Integer i1 : array) {
            builder.append(" ").append(i1).append(" ");
        }
        System.out.println(builder.toString());
    }

}
