package findDisappearedNumbers448;

import java.util.*;

public class Solution {
    /**
     * 标记法
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        int m = 0;
        int i;
        for(i = 0; i < n; ++i) {
            m = Math.abs(nums[i]) - 1;
            nums[m] = -Math.abs(nums[m]);
        }
        for(i = 0; i < n; ++i){
            if(nums[i] > 0)
                list.add(i + 1);
        }
        return list;
    }

}
