package singleNumber136;

public class Solution {
    public int singleNumber(int[] nums) {
        int a = 0;
        int length = nums.length;
        for (int i = 0; i < length; ++i){
            a ^= nums[i];
        }
        return a;
    }
}
