package numIslands200;

public class Solution {
    static public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid == null)
            return 0;
        int ans = 0;
        int y = grid.length;
        int x = grid[0].length;
        for (int i = 0; i < y; ++i) {
            for (int j = 0; j < x; ++j) {
                //未访问过则寻找岛屿
                if (grid[i][j] == '1') {
                    extend(grid, i, j);
                    ++ans;
                }
            }
        }
        return ans;
    }

    static private void extend(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        //标记为2表示访问过
        grid[i][j] = '2';
        extend(grid, i - 1, j);
        extend(grid, i , j -1);
        extend(grid, i + 1, j);
        extend(grid, i, j + 1);
    }

    public static void main(String[] args) {
        //numIslands(new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}});
        numIslands(new char[][]{{'1','1','1'},{'0','1','0'},{'1','1','1'}});
    }
}
