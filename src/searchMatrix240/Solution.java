package searchMatrix240;

import java.util.Arrays;

public class Solution {
    /**
     * 对第一行进行二分搜索，找不到则对每列进行二分搜索
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] column = new int[m];
        int i, j;
        int posx;
        posx = Arrays.binarySearch(matrix[0], target);
        if (posx >= 0)
            return true;
        else {
            posx = -posx - 2;
            for (j = posx; j >= 0; --j) {
                for (i = 0; i < m; i++) {
                    column[i] = matrix[i][j];
                }
                if (Arrays.binarySearch(column,target) >= 0)
                    return true;
            }

        }
        return false;
    }

    /**
     * 从右上角开始贪心搜索
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target)
                return true;
            else if (matrix[i][j] > target) {
                --j;
            }
            else {
                ++i;
            }
        }
        return false;
    }
}
