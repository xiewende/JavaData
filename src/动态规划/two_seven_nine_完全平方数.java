package 动态规划;

import org.junit.Test;

/**
 * @create 2021-03-01  23:02
 */
public class two_seven_nine_完全平方数 {

    @Test
    public void test(){
        int n =13;
        System.out.println(numSquares1(n));
    }

    // j = i - k*k
    //dp[i] = dp[j]+1
    public int numSquares(int n) {
        int dp[] = new int[n+1];
        dp[0] = 0;
        for(int i= 1;i<=n ;i++){
            int sqNum = (int)Math.sqrt(i);
            if(sqNum*sqNum == i){
                dp[i] = 1;
            }else {
                int ans = Integer.MAX_VALUE;
                for(int j=sqNum;j>0;j--){
                    int leave = i-j*j;
                    //dp[i] = dp[leave]+1;
                    ans = Math.min(ans,dp[leave]+1);
                }
                dp[i] = ans;
            }
        }
        return dp[n];
    }

    public int numSquares1(int n) {
        int dp[] = new int[n+1];
        dp[0] = 0;
        for(int i= 1;i<=n ;i++){
            int ans = Integer.MAX_VALUE;
            //int sqNum = (int)Math.sqrt(i);
            for(int j=1;j*j<i;j++){
                ans = Math.min(ans,dp[i-j*j]+1);
            }
            dp[i] = ans;
        }
        return dp[n];
    }
}
