package findMedianSortedArrays4;

import java.util.*;

public class Solution {
    /**
     * 暴力
     * @param nums1
     * @param nums2
     * @return
     */
    static public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        nums1 = Arrays.copyOf(nums1, nums1.length + nums2.length);
        for (int c : nums2) {
            nums1[n++] = c;
        }
        Arrays.sort(nums1);
        double ans = 0;
        int mid = nums1.length >> 1;
        if (nums1.length % 2 == 0) {
            ans = (double) (nums1[mid] + nums1[mid - 1]) / 2;
        }
        else {
            ans = nums1[mid];
        }
        return ans;
    }

    /**
     * 二分递归，问题归约为寻找第k个元素
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int left = (nums1.length + nums2.length + 1) >> 1;
        int right = (nums1.length + nums2.length + 2) >> 1;
        return (findAns(nums1, 0, nums2, 0, left) + findAns(nums1, 0, nums2, 0, right)) / 2.0;
    }

    private double findAns(int[] num1, int i, int[] num2, int j, int k) {
        //num1为空数组
        if (i >= num1.length) {
            return num2[j + k - 1];
        }
        //num2为空数组
        if (j >= num2.length) {
            return num1[i + k - 1];
        }

        //两数组仅一个元素
        if (k == 1) {
            return num1[i] < num2[j] ? num1[i] : num2[j];
        }

        //确定k/2是否在当前数组内
        int midval1 = i + k/2 - 1 < num1.length ? num1[i + k/2 - 1] : Integer.MAX_VALUE;
        int midval2 = j + k/2 - 1 < num2.length ? num2[j + k/2 - 1] : Integer.MAX_VALUE;

        //比较第k/2数大小
        if (midval1 < midval2) {
            //淘汰num1的前k/2
            return findAns(num1, i + k/2, num2, j, k - k/2);
        }
        else {
            //淘汰num2的前k/2
            return findAns(num1, i, num2, j + k/2, k - k/2);
        }

    }

    public static void main(String[] args) {
        findMedianSortedArrays(new int[]{1,2}, new int[]{3,4});
    }
}
