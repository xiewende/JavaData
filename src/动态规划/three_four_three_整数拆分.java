package 动态规划;

/**
 * @create 2021-03-07  23:40
 */
public class three_four_three_整数拆分 {

    //数学解决
    //对于 n >= 4，拆分后总是收益更大，因此最终所有 >= 4 的数都可以拆分为 2，3的组合（当然不可能有1）。
    //而 2*2*2 < 3*3 ，2*2 > 3*1 ；因此拆分后所有的 2 三个一组合并为 3*3，剩下的2保留，最后计算乘积即可。
    //先把多少个三拿出来，若剩下2，直接乘上就好，若剩下1，则分一个3给他凑成4，2*2 > 1*3
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int quotient = n / 3;
        int remainder = n % 3;
        if (remainder == 0) {
            return (int) Math.pow(3, quotient);
        } else if (remainder == 1) {
            return (int) Math.pow(3, quotient - 1) * 4;
        } else {
            return (int) Math.pow(3, quotient) * 2;
        }
    }

    //动态规划的方法
    public int integerBreak1(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }

}
