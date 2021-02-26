package com.an;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int len = 100;
        int[] nums = {64, 7, 74, 85, 87, 78};
        int val = binarySearch(nums, 7, 0, nums.length - 1);
        System.out.println(val);
    }

    public static int binarySearch(int[] nums, int val, int low, int high) {
        System.out.println("nums = " + Arrays.toString(nums) + ", val = " + val + ", low = " + low + ", high = " + high);
        if (low > high) {
            System.out.println("不存在");
            return -1;
        }
        int mid = low + ((high - low) >> 2);
        if (nums[mid] == val) {
            System.out.println("存在:" + val + " 下标为:" + mid);
            return mid;
        }
        if (nums[mid] > val) {
            return binarySearch(nums, val, mid + 1, high);
        }
        return binarySearch(nums, val, low, mid - 1);
    }
}
