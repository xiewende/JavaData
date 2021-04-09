package 动态规划;

import org.junit.Test;

/**
 * @author wjw
 * @date 2021/3/16 22:51
 */
public class one_two_seven_seven_统计全为1的正方形子矩阵 {

    @Test
    public void test(){
        int[][] matrix = {
                {1,0,1},
                {1,1,0},
                {1,1,0}
        };
        int res = countSquares(matrix);
        System.out.println(res);
    }

    //dp[i][j] 表示的是点【i】【j】向上向左区域的最大边长，边长为几，个数就为几
    public int countSquares(int[][] matrix) {
        int res = 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == 0) dp[i][j] = 0;    //当前为0，不能组成正方形
                else {
                    int edge = 0;
                    if (dp[i - 1][j - 1] > 0){
                        edge = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
                    }
                    dp[i][j] = edge + 1;
                    res += dp[i][j];
                }
            }
        }

        return res;
    }
}
