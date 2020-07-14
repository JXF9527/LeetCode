package reconstructQueue406;

import java.util.Arrays;

public class Solution {

    /**
     * 按照从大到小排序，然后如果身高一样的话，按照位置从小到大排序，依次将人插进去即可
     * @param people
     * @return
     */
    static public int[][] reconstructQueue(int[][] people) {
        int i , j;
        int[][] ans = new int[people.length][2];
        int temp;
        int pos;
        bubbleSort(people);
        for (i = 0; i < people.length; ++i) {
            pos = people[i][1];
            if(ans[pos][0] == 0) {
                ans[pos] = people[i];
            }
            else {
                while (ans[pos][0] != 0 && people[i][0] >= ans[pos][0]) {
                    ++pos;
                }

                if (ans[pos][0] != 0) {

                    for (j = pos + 1; j < people.length; ++j) {
                        if (ans[j][0] == 0)
                            break;
                    }
                    temp = j;
                    for (j = temp - 1; j >= pos; --j) {
                        ans[j + 1] = ans[j];
                    }
                }

                ans[pos] = people[i];
            }
        }
        return ans;
    }

    public static void bubbleSort(int[][] nums) {
        int[] temp;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < nums.length - 1 - i; ++j) {
                if(nums[j][0] > nums[j + 1][0]) {
                    temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
                else if (nums[j][0] == nums[j + 1][0]) {
                    if (nums[j][1] < nums[j + 1][1]) {
                        temp = nums[j + 1];
                        nums[j + 1] = nums[j];
                        nums[j] = temp;
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        reconstructQueue(new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}});
    }
}
