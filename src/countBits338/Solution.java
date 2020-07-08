package countBits338;

public class Solution {
    /**
     * 暴搜
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        int temp;
        for (int i = 0; i <= num; ++i) {
            temp = i;
            for (int j = 0; j < 32; ++j) {
                ans[i] += (temp & 1);
                temp >>= 1;
            }
        }
        return ans;
    }

    /**
     * 时空O(n)，dp
     * @param num
     * @return
     */
    private static int i = 0;
    private static int count = 2;
    public int[] countBits2(int num) {
        int[] ans = new int[num + 1];
        ans[0] = 0;
        if(num < 1)
            return ans;
        ans[1] = 1;
        count = 2;
        for (i = 2; i <= num; ++i) {
            if(i == count << 1)
                count = i;
            ans[i] = ans[i - count] + 1;
        }
        return ans;
    }

    /**
     * dp
     * @param num
     * @return
     */
    public int[] countBits3(int num) {
        int[] ans = new int[num + 1];
        ans[0] = 0;
        if(num < 1)
            return ans;
        ans[1] = 1;
        for (int i = 2; i <= num; ++i) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }

}
