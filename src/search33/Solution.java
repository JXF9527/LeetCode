package search33;

import java.util.Arrays;

public class Solution {
    /**
     * 二分查找，将数组分为有序部分和无序部分
     * @param nums
     * @param target
     * @return
     */
    static public int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        else if (nums.length == 1)
            return nums[0] == target ? 0 : -1;
        else if (nums.length == 2)
            return nums[0] == target ? 0 : (nums[1] == target ? 1 : -1);
        int low = 0, high = nums.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) >> 1;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] <= nums[low]) {
                if (nums[mid] == nums[low]) {
                    low = mid + 1;
                    continue;
                }
                if (target > nums[mid]) {
                    if (target <= nums[high]) {
                        int ans = Arrays.binarySearch(nums, mid, high + 1, target);
                        return ans >= 0 ? ans : -1;
                    }
                }
                high = mid - 1;
            }
            else if (nums[mid] >= nums[high]) {
                if (nums[mid] == nums[high]) {
                    high = mid - 1;
                    continue;
                }
                if (target < nums[mid]) {
                    if (target >= nums[low]) {
                        int ans = Arrays.binarySearch(nums, low, mid + 1, target);
                        return ans >= 0 ? ans : -1;
                    }
                }
                low = mid + 1;
            }
            else {
                if (target < nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        search(new int[]{1,2,3,4,5}, 5);
    }
}
