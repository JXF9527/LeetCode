package merge56;

import java.util.*;

public class Solution {
    /**
     * 维护一个已合并区间集合ans，每次合并区间时保证集合内所有区间不相交
     * @param intervals
     * @return
     */
    static public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        int length;
        int i, j;
        int left, right;
        int nowl, nowr;
        boolean flag;
        int pos = 0;
        for (i = 0; i < intervals.length; i++) {
            length = ans.size();
            nowl = intervals[i][0];
            nowr = intervals[i][1];
            flag = true;
            //遍历已合并区间
            for (j = 0; j < length; j++) {
                left = ans.get(j)[0];
                right = ans.get(j)[1];
                //判断区间是否有交集
                if ((nowl <= right && nowr >= left)
                        || (left <= nowr && right >= nowl)) {
                    //合并区间
                    ans.get(j)[0] = Math.min(left, nowl);
                    ans.get(j)[1] = Math.max(right, nowr);
                    //不是合并interval中的区间，而是合并ans中的区间时
                    if (!flag) {
                        --j;
                        --length;
                        //删除重复区间
                        ans.remove(pos);
                    }
                    //记录合并后的区间及位置
                    nowl = ans.get(j)[0];
                    nowr = ans.get(j)[1];
                    pos = j;
                    flag = false;
                }
            }
            //新区间已合并则不用add
            if (flag)
                ans.add(intervals[i]);
        }

        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
    }
}
