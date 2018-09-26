package com.zhl.algorithm.easy.day01;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhl on 18/9/26 下午3:08.
 *
 *              two sum
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * 示例:
 *  给定 nums = [2, 7, 11, 15], target = 9
 *  因为 nums[0] + nums[1] = 2 + 7 = 9
 *  所以返回 [0, 1]
 */
public class TwoSumDemo {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 7, 10, 1, 2, 34};
        int target = 17;
        int[] result1 = twoSum1(nums, target);
        System.out.println("result1: "+result1[0]);
        System.out.println("result1: "+result1[1]);


        int[] result2 = twoSum2(nums, target);
        System.out.println("result2: "+result2[0]);
        System.out.println("result2: "+result2[1]);

        int[] result3 = twoSum3(nums, target);
        System.out.println("result3: "+result3[0]);
        System.out.println("result3: "+result3[1]);


    }

    /**
     * 1. 暴力法
     *  时间复杂度：O(n*n)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target){
        for(int i = 0; i < nums.length; i++) {
            for(int j=i+1; j < nums.length; j ++) {
                if(nums[j] == target - nums[i]) {
//                    return new int[]{i, j};
                }
                int r = nums[i] + nums[j];
                if(r == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 2. 两遍哈希表
     *  时间复杂度：O(n)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for(int i=0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 3. 一遍哈希表
     *  时间复杂度 O(n)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


}
