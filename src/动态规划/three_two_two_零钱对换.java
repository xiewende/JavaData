package 动态规划;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @create 2021-02-22  22:25
 */
public class three_two_two_零钱对换 {

    @Test
    public void test(){
        int coins[] = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange3(coins,amount));
    }

    //方法1，使用dfs，我的这个超时了
    public int coinChange(int[] coins, int amount) {
        int men[] = new int[10010] ;//
        Arrays.sort(coins);
        dfs(coins,0,0,amount,men,coins.length-1);
        for(int i = 0;i<men.length;i++){
            if(men[i]!=0){
                return i;
            }
        }
        return -1;
    }

    public void dfs(int [] coins,int index,int amountSum,int amount ,int [] men,int idx){
        if(amountSum > amount){
            return;
        }
        if(amountSum == amount){
            men[index] = 1;
            return;
        }
        for(int i=idx;i>=0;i--){
            amountSum = amountSum + coins[i];
            dfs(coins,index+1,amountSum,amount,men,i);
            amountSum = amountSum - coins[i];
        }
    }

    //方法2，动态规划 dp[i] = dp[j]+1  j就是减下来得值，里面最小得
    public int coinChange1(int[] coins, int amount) {

        int dp[] = new int[amount+1];
        for(int i=0 ;i<dp.length;i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<=amount;j++){
                if(dp[j-coins[i]] != Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);
                }
            }
        }
        System.out.println( dp[amount]);
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
    //方法2，动态规划 dp[i] = dp[j]+1  j就是减下来得值，里面最小得
    // dp[i] 表示 价值为 i 需要合成得最少硬币数量
    public int coinChange3(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        for(int i = 1; i <= amount; i++){
            int min = Integer.MAX_VALUE;
            //找最小个数
            for(int j = 0; j < coins.length; j++){
                /*if(i - coins[j] < 0 || dp[i - coins[j]] == -1){
                    continue;
                }*/
                if(i - coins[j]>=0 && dp[i - coins[j]] != -1){
                    min = Math.min(min, dp[i - coins[j]]);
                }
            }
            if(min == Integer.MAX_VALUE) dp[i] = -1;
            else dp[i] = min + 1;
        }
        return dp[amount];
    }

    //方法3 ：bfs
    public int coinChange2(int[] coins, int amount) {
        int dist_amount [] = new int[coins.length];
        Arrays.fill(dist_amount,amount);
        Queue<int []> queue = new LinkedList<int []>();
        queue.offer(coins);
        int index = 0;
        while (!queue.isEmpty()){
            int [] tem = queue.poll();
            index++;
            for(int i=0 ;i<tem.length;i++){
                dist_amount[i] = dist_amount[i] - tem[i];
                if( dist_amount[i]<0 || tem[i]>amount){
                    continue;
                }
                if( dist_amount[i] == 0){
                    return index;
                }
            }
            queue.offer(coins);
        }

        return -1;

    }
}
