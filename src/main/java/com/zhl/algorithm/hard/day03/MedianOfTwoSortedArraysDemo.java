package com.zhl.algorithm.hard.day03;

/**
 * Created by zhl on 18/9/29 下午6:42.
 * Median of Two Sorted Arrays
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * You may assume nums1 and nums2 cannot be both empty.
 */
public class MedianOfTwoSortedArraysDemo {

    public static void main(String[] args) {
        int[] arrays1 = new int[]{1,2};
        int[] arrays2 = new int[]{3,4};
        System.out.println(findMedianSortedArrays(arrays1, arrays2));
    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m < n) {
            //前面数组的长度不能小于后面数组的长度
            return findMedianSortedArrays(nums2, nums1);
        }
        if (n == 0) {
            return (nums1[(m - 1) / 2] + nums1[m / 2]) / 2.0;
        }

        int left = 0, right = 2 * n;
        while (left <= right) {
            int mid2 = (left + right) / 2;
            int mid1 = m + n - mid2;
            double L1 = mid1 == 0 ? Double.MIN_VALUE : nums1[(mid1 - 1) / 2];
            double L2 = mid2 == 0 ? Double.MIN_VALUE : nums2[(mid2 - 1) / 2];
            double R1 = mid1 == m * 2 ? Double.MAX_VALUE : nums1[mid1 / 2];
            double R2 = mid2 == n * 2 ? Double.MAX_VALUE : nums2[mid2 / 2];
            if (L1 > R2) {
                left = mid2 + 1;
            } else if(L2 > R1)  {
                right = mid2 - 1;
            } else {
                return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
            }
        }
        return -1;
    }
}
