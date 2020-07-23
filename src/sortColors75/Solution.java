package sortColors75;

public class Solution {
    /**
     * 计数排序
     * @param nums
     */
    public void sortColors2(int[] nums) {
        int[] count = new int[3];
        int i;
        for (i = 0; i < nums.length; ++i) {
            ++count[nums[i]];
        }

        for (i = 0; i < nums.length; ++i) {
            if (count[0] > 0) {
                nums[i] = 0;
                --count[0];
            }
            else if (count[1] > 0) {
                nums[i] = 1;
                --count[1];
            }
            else {
                nums[i] = 2;
                --count[2];
            }
        }

        return;
    }

    /**
     * 快排思想，三指针
     * @param nums
     */
    static public void sortColors(int[] nums) {
        int l = 0, r = nums.length - 1;
        int i = 0;
        int temp;
        while (i <= r) {
            switch (nums[i]) {
                case 0:
                    temp = nums[l];
                    nums[l] = nums[i];
                    nums[i] = temp;
                    ++i;
                    ++l;
                    break;
                case 1:
                    ++i;
                    break;
                case 2:
                    temp = nums[r];
                    nums[r] = nums[i];
                    nums[i] = temp;
                    --r;
                    break;
            }

        }
    }

    public static void main(String[] args) {
        sortColors(new int[]{2,0,2,1,1,0});

    }
}
