package maximalRectangle85;

public class Solution {
    /**
     * 朴素法
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        int ans = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    ans = Math.max(ans, helper(matrix, i, j));
                }
            }
        }
        return ans;
    }


    private int helper(char[][] matrix, int row, int col) {
        int max = 0;
        int rowlenth = matrix.length;
        int collenth = matrix[0].length;
        int i, j;
        for (i = row; i < rowlenth; i++) {
            //这行第一个列为0
            if (matrix[i][col] == '0') {
                rowlenth = i;
                break;
            }
            for (j = col; j < collenth; j++) {
                //这行某个列出现0
                if (matrix[i][j] == '0') {
                    collenth = j;
                    continue;
                }
            }

            max = Math.max(max, (i - row + 1)*(collenth - col));

        }

        return max;
    }
}
