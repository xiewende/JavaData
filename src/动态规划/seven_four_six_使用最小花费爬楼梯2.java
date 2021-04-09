package 动态规划;

/**
 * @create 2021-03-12  23:42
 */
public class seven_four_six_使用最小花费爬楼梯2 {
    public int minCostClimbingStairs(int[] cost) {

        int n = cost.length;
        int dp[] = new int[n+1];
        dp[0]=0;
        dp[1] = 0;
        for(int i=2;i<=n;i++){
            dp[i] = Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[n];

    }
}
