package topKFrequent347;

import java.util.*;

public class Solution {
    /**
     * 先建立 值-出现次数的map，然后建立 出现次数-值列表的countMap，最后遍历。
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, List<Integer>> countMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //降序
                return o2 - o1;
            }
        });
        int[] ans = new int[k];
        int i;

        for (i = 0; i < nums.length; ++i) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        }
        List<Integer> list;
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            if (countMap.containsKey(entry.getValue())) {
                countMap.get(entry.getValue()).add(entry.getKey());
            }
            else {
                list = new ArrayList<>();
                list.add(entry.getKey());
                countMap.put(entry.getValue(), list);
            }
        }

        Iterator<Map.Entry<Integer, List<Integer>>> it = countMap.entrySet().iterator();
        i = 0;
        Tp : while (true) {
            Map.Entry<Integer, List<Integer>> entry = it.next();
            Iterator<Integer> ite = entry.getValue().iterator();
            while (ite.hasNext()) {
                ans[i++] = ite.next();
                if (i >= k)
                    break Tp;
            }
        }
        return ans;
    }
}
