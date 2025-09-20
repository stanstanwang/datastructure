package org.buptdavid.datastructure.leetcode;

/**
 * @author stan
 * @date 2025/2/17
 */
public class L209 {


    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, result = 0, sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                result = result != 0 ? Math.min(right - left + 1, result) : result;
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return result;
    }

}
