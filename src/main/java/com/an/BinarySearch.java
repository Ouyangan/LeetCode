package com.an;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = ArrayGenerator.createSortArray(10);
        int val = binarySearch(ArrayGenerator.createSortArray(10), 7, 0, nums.length - 1);
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
            if (mid == 0 || nums[mid - 1] != val) {
                return mid;
            }
            return binarySearch(nums, val, low, mid - 1);
        }
        if (nums[mid] < val) {
            return binarySearch(nums, val, mid + 1, high);
        }
        return binarySearch(nums, val, low, mid - 1);
    }
}
