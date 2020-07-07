package subsets78;

import java.util.*;

public class Solution {
    /**
     * 遍历，遇到一个数就把所有子集加上该数组成新的子集，遍历完毕即是所有子集
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        int len;
        for(int i = 0; i < nums.length; ++i) {
            len = ans.size();
            while (len-- > 0) {
                List<Integer> temp = ans.get(len);
                List<Integer> newlist = new ArrayList<>(temp);
                newlist.add(nums[i]);
                ans.add(newlist);
            }
        }
        return ans;
    }
}
