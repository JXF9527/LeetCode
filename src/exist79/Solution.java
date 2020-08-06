package exist79;

public class Solution {
    static private boolean ans = false;

    /**
     * dfs搜索
     * @param board
     * @param word
     * @return
     */
    static public boolean exist(char[][] board, String word) {
        if (board.length == 0 || word.length() == 0)
            return false;
        int i, j;
        int pos = 0;
        char[] wd = word.toCharArray();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (i = 0; i < board.length; i++) {
            for (j = 0; j < board[0].length; j++) {
                if (board[i][j] == wd[0]) {
                    dfs(board, i, j, wd, 0, visited);
                    if (ans)
                        return true;
                }

            }
        }
        return false;
    }

    static private void dfs(char[][] board, int i, int j,char[] wd, int pos, boolean[][] visited) {
        if (ans)
            return;
        if (pos == wd.length) {
            ans = true;
            return;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return;
        if (visited[i][j])
            return;
        if (board[i][j] == wd[pos]) {
            visited[i][j] = true;
            //搜索4个方向
            dfs(board, i + 1, j, wd, pos + 1, visited);
            dfs(board, i - 1, j, wd, pos + 1, visited);
            dfs(board, i, j + 1, wd, pos + 1, visited);
            dfs(board, i, j - 1, wd, pos + 1, visited);
            visited[i][j] = false;
        }
    }

    public static void main(String[] args) {
        exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED");
    }
}
