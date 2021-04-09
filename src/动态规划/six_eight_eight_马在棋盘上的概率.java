package 动态规划;

import org.junit.Test;
import utils.ArrayUtil;

/**
 * @author wjw
 * @date 2021/3/14 23:38
 */
public class six_eight_eight_马在棋盘上的概率 {

    @Test
    public void test(){
//        double res = knightProbability(3, 2, 0, 0);
        double res = knightProbability(8, 30, 6, 4);
        System.out.println(res);
    }

    public double knightProbability(int N, int K, int r, int c) {
        double[][] dp_old = new double[N][N]; //dp_old数组，dp[x][y]表示第i次到达dp[x][y]的方案数
        double[][] dp_new = new double[N][N]; //dp_new数组，dp[i][j]表示第i+1次到达dp[x][y]的方案数

        //初始化
        dp_old[r][c] = 1;   //一开始的位置
        for(int i = 0; i < K; i++){ //K次

            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    //四面八方累加dp
                    dp_new[x][y] = computeSumFromDirection(dp_old, x, y);
                }
            }

            ArrayUtil.showArray(dp_old);
            ArrayUtil.showArray(dp_new);
            System.out.println("==============================" + i);

            dp_old = dp_new;
            dp_new = new double[N][N];
        }

        //遍历这个数组的总和就是落在棋盘内所有格子的方案数
        double in = 0;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                in += dp_old[x][y];
            }
        }

        return in;
    }

    public double computeSumFromDirection(double[][] dp_old, int x, int y){
        double sum = 0;
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};    //方向导向数组
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
        for (int i = 0; i < dx.length; i++){
            if(!check(dp_old, x + dx[i], y + dy[i])) continue;
            sum += dp_old[x + dx[i]][y + dy[i]];
        }
        return sum / 8.0;
    }

    public boolean check(double[][] dp_old, int x, int y){     //越界判断
        return x >= 0 && x < dp_old.length && y >= 0 && y < dp_old[0].length;
    }
}
