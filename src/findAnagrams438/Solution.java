package findAnagrams438;

import java.util.*;

public class Solution {
    /**
     * 暴力
     *
     * @param s
     * @param p
     * @return
     */
    static public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length())
            return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        int i, j;
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        char[] sarray = s.toCharArray();
        for (i = 0; i <= s.length() - p.length(); ++i) {
            Map<Character, Integer> tempmap = new HashMap<>(map);
            for (j = 0; j < p.length(); ++j) {
                if (!map.containsKey(sarray[i + j]) || tempmap.get(sarray[i + j]) - 1 < 0)
                    break;
                tempmap.put(sarray[i + j], tempmap.get(sarray[i + j]) - 1);
            }
            if (j == p.length())
                ans.add(i);
        }

        return ans;
    }

    /**
     * 每次遍历窗口往后移动，去除窗口头字符，加入区间末字符，检查是否为异位同串
     * Hash法
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams2(String s, String p) {
        if (p.length() > s.length())
            return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> comap = new HashMap<>();
        int i, j;
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (j = 0; j < p.length(); ++j) {
            comap.put(s.charAt(j), comap.getOrDefault(s.charAt(j), 0) + 1);
        }
        if (comap.equals(map))
            ans.add(0);

        char[] sarray = s.toCharArray();
        for (i = 1; i <= s.length() - p.length(); ++i) {
            char oldc = sarray[i - 1];
            char newc = sarray[i - 1 + p.length()];
            if (comap.get(oldc).equals(1)) {
                comap.remove(oldc);
            }
            else {
                comap.put(oldc, comap.get(oldc) - 1);
            }
            comap.put(newc, comap.getOrDefault(newc, 0) + 1);
            if (comap.equals(map))
                ans.add(i);
        }

        return ans;
    }

    /**
     * 数组版本
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams3(String s, String p) {
        List<Integer> result = new ArrayList<>();
        char [] sChar = s.toCharArray();
        char [] pChar = p.toCharArray();
        int [] curAToZ = new int[26];
        int [] aToZ = new int[26];
        for (char c : pChar) {
            aToZ[c - 'a']++;
        }
        for (int i = 0; i < sChar.length; i++) {
            if (i >= pChar.length) {
                curAToZ[sChar[i-pChar.length] - 'a']--;
            }
            curAToZ[sChar[i] - 'a']++;
            if (Arrays.equals(curAToZ, aToZ)) {
                result.add(i - pChar.length + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        findAnagrams("cbaebabacd", "abc");
    }
}
