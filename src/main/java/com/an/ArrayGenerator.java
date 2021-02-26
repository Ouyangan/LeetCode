package com.an;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArrayGenerator {

    public static int[] createArray(int n) {
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
        int[] nums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }

    public static int[] createSortArray(int n) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        StringBuilder builder = new StringBuilder();
        builder.append("原始数组:");
        Integer[] integers = list.toArray(new Integer[]{});
        for (Integer integer : integers) {
            builder.append(integer)
                    .append(" ");
        }
        System.out.println(builder.toString());
        int[] nums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }
}
