package 动态规划;

import org.junit.Test;

/**
 * @create 2021-03-11  18:09
 */
public class six_five_zero_只有两个键的键盘 {

    @Test
    public void test(){
        int n=2;
        System.out.println(minSteps(n));
    }

    public int minSteps(int n) {
        int dp[] = new int[n+1];
        dp[1] = 0;
        for(int i=2;i<=n;i++){
            int min = Integer.MAX_VALUE;
            //优化1，降低j得循环
            int sqrt = i/2;
            for(int j=1;j<=sqrt;j++){
                int tem = i%j;
                if(tem == 0){
                    int time = i / j;
                    min = Math.min(min,dp[j]+time);
                }
            }
            dp[i] = min;
        }
        return dp[n];
    }

    public int minSteps1(int n) {
        int dp[] = new int[n+1];
        dp[1] = 0;
        for(int i=2;i<=n;i++){
            dp[i] = i;
            int sqrt = (int)Math.sqrt(i);
            for(int j=2;j<=sqrt;j++){
                int tem = i % j;
                if(tem == 0){
                    int time = i / j;
                    dp[i] =dp[j]+dp[time];
                    break;
                }
            }
        }
        return dp[n];
    }
}
