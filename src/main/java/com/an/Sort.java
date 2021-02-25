package com.an;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 排序算法
 */
public class Sort {
    public static void main(String[] args) {

//        System.out.println("========bubbleSort========");
//        bubbleSort(createArray(10));
//        System.out.println("====insertSort=====");
//        insertSort(createArray(10));
//        System.out.println("=====selectSort=====");
//        selectSort(createArray(10));
//        System.out.println("======mergeSort=====");
//        mergeSort(createArray(10));
        System.out.println("======quickSort=========");
        quickSort(createArray(10));
    }

    /**
     * 快速排序
     * O(n^log^n)
     */
    public static Integer[] quickSort(Integer[] array) {
        Integer[] integers = quickSort(array, 0, array.length - 1);
        return integers;
    }

    public static Integer[] quickSort(Integer[] array, int left, int right) {
        if (left < right) {
            int p = partition(array, left, right);
            quickSort(array, left, p - 1);
            quickSort(array, p + 1, right);
        }
        return array;
    }

    private static int partition(Integer[] array, int left, int right) {
        //找基准点
        //排序基准点右边数组
        int pivot = left;
        int index = pivot + 1;

        for (int i = index; i <= right; i++) {
            //如果当前元素小于基准值,则将元素往左边已处理区域末尾
            //否则指针不移动
            if (array[i] < array[pivot]) {
                //进行交换,
                swap(array, i, index);
                index++;
            }
        }
        //index-1的位置就是最后
        swap(array, pivot, index - 1);
        return index - 1;
    }


    private static void swap(Integer[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 归并排序
     * O(n*log^n)
     *
     * @param array
     * @return
     */
    public static Integer[] mergeSort(Integer[] array) {
        Integer[] result = new Integer[array.length];
        return mergeSortRecursive(array, result, 0, array.length - 1);
    }

    private static Integer[] mergeSortRecursive(Integer[] array, Integer[] result, int start, int end) {
        //不可再分
        if (start >= end) {
            return array;
        }
        int len = end - start;
        //找中间分隔位置
        int mid = len / 2 + start;
        //左边开始位置
        int leftStart = start;
        //左边结束位置
        int leftEnd = mid;
        //右边开始位置
        int rightStart = mid + 1;
        //右边结束位置
        int rightEnd = end;
        //左边数组排序
        mergeSortRecursive(array, result, leftStart, leftEnd);
        //右边数组排序
        mergeSortRecursive(array, result, rightStart, rightEnd);
        //合并两个数组
        int k = start;
        //左右两个数组合并
        while (leftStart <= leftEnd && rightStart <= rightEnd) {
            //左右数组同一个位置大小对比
            //取小填充至 临时数组
            result[k++] = array[leftStart] < array[rightStart] ? array[leftStart++] : array[rightStart++];
        }
        //当左边数组比右边多时,继续移动剩余数据至临时数组
        while (leftStart <= leftEnd) {
            result[k++] = array[leftStart++];
        }
        //当右边数组比左边多时,继续移动剩余数据至临时数组
        while (rightStart <= rightEnd) {
            result[k++] = array[rightStart++];
        }
        //复制数据
        for (k = start; k <= end; k++) {
            array[k] = result[k];
        }
        prettyPrint(array, 0);
        return array;
    }

    /**
     * 选择排序
     * O(n^2)
     *
     * @param array
     * @return
     */
    public static Integer[] selectSort(Integer[] array) {
        int len = array.length;
        if (len <= 1) {
            return array;
        }
        //在未排序的数组中找到最小的数,并放置在已排序数组末尾
        for (int i = 0; i < len; i++) {
            //这里假设i就是已排序数组末尾(i=0时也符合此假设)
            int minCursor = i;
            for (int j = i + 1; j < len; j++) {
                if (array[j] < array[minCursor]) {
                    minCursor = j;
                }
            }
            if (minCursor != 0) {
                int temp = array[i];
                array[i] = array[minCursor];
                array[minCursor] = temp;
            }
            prettyPrint(array, i + 1);
        }
        return array;
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
            array[j + 1] = val;
            prettyPrint(array, i - 1);
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
            prettyPrint(array, i);
        }
        return array;
    }

    /**
     * 打印
     *
     * @param array
     * @param count
     */
    private static void prettyPrint(Integer[] array, int count) {
        StringBuilder builder = new StringBuilder();
        builder.append("第").append(count + 1).append("次排序:");
        for (Integer i1 : array) {
            builder.append(" ").append(i1).append(" ");
        }
        System.out.println(builder.toString());
    }

    /**
     * 创建测试数据
     *
     * @return
     */
    private static Integer[] createArray(int n) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            list.add(random.nextInt(100));
        }
        StringBuilder builder = new StringBuilder();
        builder.append("原始数组:");
        Integer[] integers = list.toArray(new Integer[]{});
        for (Integer integer : integers) {
            builder.append(integer)
                    .append(" ");
        }
        System.out.println(builder.toString());
        return integers;
    }

    private static Integer[] createStaticArray() {
        return new Integer[]{4, 3, 1, 9, 2, 6};
    }

}
