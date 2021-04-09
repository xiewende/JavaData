package 回溯;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @create 2021-03-15  20:10
 */
public class five_two_n皇后问题2 {

    @Test
    public void test(){
        int i = totalNQueens(4);
        System.out.println(i);
    }

    public int totalNQueens(int n) {
        int[][] chs = new int[n][n];
        return backTracing1(chs, 0, n);
    }

    public int backTracing1(int[][] chs, int row, int n) {
        //每行都摆满皇后时，则产生了一种解法
        if (row == n) {
            return 1;
        }
        int count = 0;
        //一行一行地摆放，在确定一行中的那个皇后应该摆在哪一列时，需要当前列是否合法。
        //如果合法，则将皇后放置在当前位置，并进行递归，回溯。
        for (int col = 0; col < chs[0].length; col++) {
            if (isValid(chs, row, col)) {
                chs[row][col] = 1;
                //递归
                count  += backTracing1(chs, row + 1, n);
                //回溯
                chs[row][col] = 0;
            }
        }
        return count;
    }

    //判断合法
    public boolean isValid1(int[][] path,int row,int col) {
        //左上
        for (int i = row-1, j = col-1; i >=0 && j>=0; i--,j--)
            if(path[i][j]==1) return false;
        //右上上
        for (int i = row-1, j = col+1; i >=0 && j<path[0].length; i--,j++)
            if(path[i][j]==1) return false;
        //正上方
        for (int i = row-1; i >=0; i--)
            if(path[i][col]==1) return false;

        return true;
    }



    public int ans = 0;
    public void backTracing(int[][] chs, int row, int n) {
        //每行都摆满皇后时，则产生了一种解法
        if (row == n) {
            ans++;
            return;
        }
        //一行一行地摆放，在确定一行中的那个皇后应该摆在哪一列时，需要当前列是否合法。
        //如果合法，则将皇后放置在当前位置，并进行递归，回溯。
        for (int col = 0; col < chs[0].length; col++) {
            if (isValid(chs, row, col)) {
                chs[row][col] = 1;
                //递归
                backTracing(chs, row + 1, n);
                //回溯
                chs[row][col] = 0;
            }
        }
    }
    //判断合法：当前将要摆放'Q'的位置和其他已摆放‘Q’的位置不能在同一列，且不能在同一条45度斜线或135度斜线上。
    //这里判断是否在同一条斜线上可通过当前将要摆放'Q'的位置和其他已摆放‘Q’的位置横坐标之差和纵坐标之差的绝对值是否相等来判断。
    public boolean isValid(int[][] chs, int x, int y) {
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j < chs[0].length; j++) {
                if (chs[i][j] == 1 && (j == y || Math.abs(x - i) == Math.abs(y - j))) {
                    return false;
                }
            }
        }
        return true;
    }
}
