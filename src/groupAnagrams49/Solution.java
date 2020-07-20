package groupAnagrams49;

import java.util.*;

public class Solution {
    /**
     * 对字符串排序获得唯一key建立map
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ans = new HashMap<>();
        char[] cArray;
        String str;
        for (int i = 0; i < strs.length; ++i) {
            cArray = strs[i].toCharArray();
            Arrays.sort(cArray);
            str = String.valueOf(cArray);
            if (!ans.containsKey(str)) {
                ans.put(str, new ArrayList<>());
            }
            ans.get(str).add(strs[i]);
        }
        return new ArrayList<>(ans.values());
    }
}
