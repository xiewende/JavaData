package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @create 2019-11-20  18:53
 */
public class seven_nine_单词搜索 {

    private static boolean[][] isUse;

    public boolean exist(char[][] board, String word) {
        int count = 0;

        // 如果word长度超过board，必然找不到
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                count++;
            }
        }
        if (count < word.length()) {
            return false;
        }

        int row = board.length;
        int col = board[0].length;
        List<Character> re = new ArrayList<>();
        isUse = new boolean[row][col];
        return find(board, word, re);

    }

    // 找开头位置，避免从头遍历
    public static boolean find(char[][] board, String word, List<Character> re) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    // re.add(board[i][j]);
                    if (tsstExist(board, word, i, j, re)) {
                        return true;
                    }

                }
            }
        }

        return false;
    }

    //找上下左右是否匹配下一个字母  回溯
    public static boolean tsstExist(char[][] board, String word, int x, int y, List<Character> re) {
        re.add(board[x][y]);
        if (word.length() == re.size()) {

            re.remove(re.size() - 1);
            return true;
        }
        isUse[x][y] = true;

        // 边界
        int up = (x - 1 >= 0) ? x - 1 : x;
        int down = (x + 1 < board.length) ? x + 1 : x;
        int left = (y - 1 >= 0) ? y - 1 : y;
        int right = (y + 1 < board[0].length) ? y + 1 : y;

        //四周
        if (board[up][y] == word.charAt(re.size()) && !isUse[up][y] && tsstExist(board, word, up, y, re)) {
            return true;
        }
        if (board[down][y] == word.charAt(re.size()) && !isUse[down][y] && tsstExist(board, word, down, y, re)) {
            return true;
        }
        if (board[x][right] == word.charAt(re.size()) && !isUse[x][right] && tsstExist(board, word, x, right, re)) {
            return true;
        }
        if (board[x][left] == word.charAt(re.size()) && !isUse[x][left] && tsstExist(board, word, x, left, re)) {
            return true;
        }

        re.remove(re.size() - 1);
        isUse[x][y] = false;

        return false;
    }

}
