package dailyTemperatures739;

import java.util.Stack;

public class Solution {
    /**
     * 暴力
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        for (int i = 0; i < T.length; ++i) {
            for (int j = i + 1; j < T.length; ++j) {
                if(T[i] < T[j]) {
                    ans[i] = j - i;
                    break;
                }
            }
        }
        return ans;
    }

    /**
     * 根据题意，从最后一天推到第一天，这样会简单很多。因为最后一天显然不会再有升高的可能，结果直接为0。
     * 再看倒数第二天的温度，如果比倒数第一天低，那么答案显然为1，如果比倒数第一天高，又因为倒数第一天
     * 对应的结果为0，即表示之后不会再升高，所以倒数第二天的结果也应该为0。
     * 自此我们容易观察出规律，要求出第i天对应的结果，只需要知道第i+1天对应的结果就可以：
     * - 若T[i] < T[i+1]，那么res[i]=1；
     * - 若T[i] > T[i+1]
     *   - res[i+1]=0，那么res[i]=0;
     *   - res[i+1]!=0，那就比较T[i]和T[i+1+res[i+1]]（即将第i天的温度与比第i+1天大的那天的温度进行比较）
     * @param T
     * @return
     */
    public int[] dailyTemperatures2(int[] T) {
        int[] ans = new int[T.length];
        ans[T.length - 1] = 0;
        for (int i = T.length - 2; i >= 0; --i) {
            for (int j = i + 1; j < T.length; j += ans[j]) {
                if (T[i] < T[j]) {
                    ans[i] = j - i;
                    break;
                }
                else {
                    if (ans[j] == 0) {
                        ans[i] = 0;
                        break;
                    }
                    else if (T[ans[j] + j] > T[i]) {
                        ans[i] = ans[j] + j - i;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    /**
     * 递减栈，最小栈
     * @param T
     * @return
     */
    public int[] dailyTemperatures3(int[] T) {
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; ++i) {
            while (!stack.empty() && T[i] > T[stack.peek()]) {
                ans[stack.peek()] = i - stack.pop();

            }
            stack.push(i);
        }
        return ans;
    }
}
