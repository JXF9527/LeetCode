package rotate48;

public class Solution {
    private static int i;
    private static int temp;
    static public void rotate(int[][] matrix) {
        help(matrix, 0, matrix.length - 1);
    }

    /**
     * 交换法，对角线交换+x轴交换
     * @param matrix
     * @param begin
     * @param end
     */
    static private void help(int[][] matrix, int begin, int end) {
        if(begin >= end)
            return;

        for (i = begin + 1; i <= end - 1; ++i) {
            //上与右交换
            temp = matrix[begin][i];
            matrix[begin][i] = matrix[i][end];
            matrix[i][end] = temp;

            //左与下交换
            temp = matrix[i][begin];
            matrix[i][begin] = matrix[end][i];
            matrix[end][i] = temp;
        }

        for (i = begin + 1; i <= end - 1; ++i) {
            //上下逆序交换
            temp = matrix[begin][i];
            matrix[begin][i] = matrix[end][end + begin - i];
            matrix[end][end + begin - i] = temp;
        }

        //处理角落
        //左上与右上交换
        temp = matrix[begin][end];
        matrix[begin][end] = matrix[begin][begin];
        matrix[begin][begin] = temp;

        //左下与右下交换
        temp = matrix[end][end];
        matrix[end][end] = matrix[end][begin];
        matrix[end][begin] = temp;

        //左上与右下交换
        temp = matrix[end][end];
        matrix[end][end] = matrix[begin][begin];
        matrix[begin][begin] = temp;

        //递归内部矩阵
        help(matrix, begin + 1, end - 1);
    }

    /**
     * 失败，先转置后镜像对称
     * @param matrix
     * @param begin
     * @param end
     */
    static private void helper(int[][] matrix, int begin, int end) {
        if(begin >= end)
            return;
        int n = matrix.length;
        int[] temp = new int[n];
        int[] temp2 = new int[n];
        int i;

        for (i = begin; i <= end; ++i) {
            temp2[i] = matrix[begin][i];
        }

        for (i = begin; i <= end; ++i) {
            temp[i] = matrix[i][end];
            matrix[i][end] = temp2[i];
        }

        for (i = begin; i <= end; ++i) {
            temp2[i] = matrix[end][i];
            matrix[end][i] = temp[n - i - 1];
        }

        for (i = begin; i <= end; ++i) {
            temp[i] = matrix[i][begin];
            if(i != n - 1)
                matrix[i][begin] = temp2[i];
        }

        for (i = begin + 1; i <= end; ++i) {
            matrix[begin][i] = temp[n - i -1];
        }
        helper(matrix, begin + 1, end - 1);
    }


    public static void main(String[] args) {
        int[][] array = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(array);
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.print(anInt + "  ");
            }
            System.out.println();
        }
    }
}
