package longestConsecutive128;

import java.util.*;
import java.util.Scanner;

public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;
        int i, ans = 1;

        Arrays.sort(nums);
        int length = 1;
        for (i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 == nums[i]) {
                ++length;

            }
            else if (nums[i - 1] == nums[i]) {
                continue;
            }
            else {
                length = 1;
            }
            ans = ans > length ? ans : length;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ans = new int[4];
        int i = 0, j = 0;
        int counter = 1;
        while (j < n) {
            String num = String.valueOf(counter);
            if (num.contains("7") || (counter % 7) == 0) {
                ++ans[i];
                i = (i + 1) % 4;
                ++counter;
                continue;
            }
            i = (i + 1) % 4;
            ++counter;
            ++j;
        }

        for (i = 0; i < 4; i++) {
            System.out.println(ans[i]);
        }
    }
}


