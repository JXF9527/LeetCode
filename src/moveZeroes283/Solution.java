package moveZeroes283;

public class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        for(i = 0; i < nums.length ; ++i){
            if(nums[i] != 0){
                nums[j] = nums[i];
                ++j;
            }
        }
        while(j < nums.length){
            nums[j] = 0;
            ++j;
        }
    }
}
