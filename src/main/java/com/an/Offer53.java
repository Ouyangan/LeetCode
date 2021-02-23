package com.an;

/**
 * 统计一个数字在排序数组中出现的次数。
 * <p>
 *
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *
 * <p>
 * 限制：
 * <p>
 * 0 <= 数组长度 <= 50000
 * <p>
 *
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer53 {


    public static void main(String[] args) {
        int search = new Offer53().search(new int[]{5, 7,8, 8, 8, 10}, 8);
        System.out.println(search);
    }


    public  int search(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        return helper(nums, target) - helper(nums, target - 1);
    }

    private int helper(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int m = (left + right) / 2;
            if (nums[m] <= target) {
                left = m + 1;
            } else {
                right = m - 1;
            }
        }
        System.out.println(left);
        return left;
    }

}
