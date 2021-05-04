package 动态规划;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author wjw
 * @date 2021/5/4 23:17
 */
public class one_four_seven_three_粉刷房子III {

    @Test
    public void test(){
        int[] houses = {0,2,1,2,0};
        int[][] cost = {{1,10},{10,1},{10,1},{1,10},{5,1}};
        int m = 5;
        int n = 2;
        int target = 3;
        int res = minCost(houses, cost, m, n, target);
        System.out.println(res);
    }

    /**
     * 回溯，超时
     */
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        backtrace(houses, cost, m, n, target, 0, 0);
        return min1 == Integer.MAX_VALUE ? -1 : min1;
    }

    private int min1 = Integer.MAX_VALUE;
    public void backtrace(int[] houses, int[][] cost, int m, int n, int target, int index, int costNum) {
        // 结束条件
        if(index == m && isTarget(houses, target)){
            min1 = Math.min(min1, costNum);
            return ;
        }
        if(index >= m) return;

        if(houses[index] != 0) {
            backtrace(houses, cost, m, n, target, index + 1, costNum);
        }else{
            //有cost列可以选
            for(int j = 0; j < n; j++){
                houses[index] = j + 1;
                backtrace(houses, cost, m, n, target, index + 1, costNum + cost[index][j]);
                houses[index] = 0;
            }
        }
    }

    public boolean isTarget(int[] houses, int target){
        int num = 1;
        for(int i = 1; i < houses.length; i++){
            if(houses[i] != houses[i - 1]) num++;
        }
        return num == target;
    }

    /**
     * other
     * 动态规划
     */
    public int minCost2(int[] houses, int[][] cost, int m, int n, int target) {
        int[][][] dp=new int[m][target+1][n];//房子序号 区数 颜色
        int[] prefixs=new int[n];
        int[] suffixs=new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<=target;j++){
                Arrays.fill(dp[i][j],Integer.MAX_VALUE);
            }
        }
        if(houses[0]==0){
            for(int k=0;k<n;k++){
                dp[0][1][k]=cost[0][k];
            }
        }else{
            dp[0][1][houses[0]-1]=0;
        }
        for(int i=1;i<m;i++){
            if(houses[i]==0){
                for(int j=0;j<n;j++){
                    if(dp[i-1][1][j]!=Integer.MAX_VALUE){
                        dp[i][1][j]=cost[i][j]+dp[i-1][1][j];
                    }
                }
            }else{
                int color=houses[i]-1;
                dp[i][1][color]=dp[i-1][1][color];
            }
        }
        for(int i=1;i<m;i++){
            for(int j=2;j<=target;j++){
                if(houses[i]!=0){
                    int c=houses[i]-1;
                    int min=dp[i-1][j][c];
                    for(int kk=0;kk<n;kk++){
                        if(kk!=c){
                            min=Math.min(min,dp[i-1][j-1][kk]);
                        }
                    }
                    dp[i][j][c]=min;
                }else{
                    //dp[i][j][k]
                    prefixs[0]=dp[i-1][j-1][0];
                    for(int k=1;k<n;k++){
                        prefixs[k]=Math.min(prefixs[k-1],dp[i-1][j-1][k]);
                    }
                    suffixs[n-1]=dp[i-1][j-1][n-1];
                    for(int k=n-2;k>=0;k--){
                        suffixs[k]=Math.min(suffixs[k+1],dp[i-1][j-1][k]);
                    }
                    for(int k=0;k<n;k++){
                        int min=Math.min(dp[i-1][j][k],
                                Math.min((k>0?prefixs[k-1]:Integer.MAX_VALUE),
                                        (k+1<n?suffixs[k+1]:Integer.MAX_VALUE)));
                        if(min!=Integer.MAX_VALUE){
                            dp[i][j][k]=min+cost[i][k];
                        }
                    }
                }
            }
        }
        int min=Integer.MAX_VALUE;
        for(int k=0;k<n;k++){
            min=Math.min(min,dp[m-1][target][k]);
        }
        return min==Integer.MAX_VALUE?-1:min;
    }

    /**
     * other
     * 记忆化搜索，比动态规划快3ms
     */
    public int minCost3(int[] houses, int[][] cost, int m, int n, int target) {
        //dp[i][j][k]表示 下标为i及以后的房子，在i - 1房子颜色为j的情况下，凑出k个街区所需的最小代价
        int[][][] dp = new int[m][n + 1][target + 1];

        return dfs(houses, cost, 0, 0, target, dp);
    }

    private int dfs(int[] houses, int[][] cost, int i, int formerColor, int target, int[][][] dp) {
        //前面base case 一顿过滤
        if (i == houses.length && target == 0) {
            return 0;
        }

        if (houses.length - i < target || target < 0) {
            return -1;
        }

        if (dp[i][formerColor][target] != 0) {
            return dp[i][formerColor][target];
        }

        int ans = Integer.MAX_VALUE;

        //如果当前状态可选
        if (houses[i] == 0) {
            for (int j = 0; j < cost[i].length; ++j) {
                int p3 = j + 1 == formerColor ? dfs(houses, cost, i + 1, j + 1, target, dp) : dfs(houses, cost, i + 1, j + 1, target - 1, dp);
                if (p3 != -1) {
                    p3 += cost[i][j];
                    ans = Math.min(p3, ans);
                }
            }
            //如果当前状态不可选
        } else {
            //如果当前房子颜色与前一个房子颜色相同，那么当前i与前一个房子的街区相同，target不用减少
            if (houses[i] == formerColor) {
                int p1 = dfs(houses, cost, i + 1, formerColor, target, dp);
                if (p1 != -1) {
                    ans = Math.min(p1, ans);
                }
                //如果当前房子颜色与前一个房子颜色不同，那么当前i与前一个房子的街区不同，是一个新街区，targer - 1
            } else {
                int p2 = dfs(houses, cost, i + 1, houses[i], target - 1, dp);
                if (p2 != -1) {
                    ans = Math.min(p2, ans);
                }
            }
        }

        ans = ans == Integer.MAX_VALUE ? -1 : ans;
        dp[i][formerColor][target] = ans;
        return ans;
    }
}
