package 动态规划;

/**
 * @create 2021-03-20  10:38
 */
public class offer_four_two_连续子数组的最大和 {

    //状态定义： 设动态规划列表 dpdp ，dp[i]dp[i] 代表以元素 nums[i]nums[i] 为结尾的连续子数组最大和。
    //
    //为何定义最大和 dp[i]dp[i] 中必须包含元素 nums[i]nums[i] ：保证 dp[i]dp[i] 递推到 dp[i+1]dp[i+1] 的正确性；如果不包含 nums[i]nums[i] ，递推时则不满足题目的 连续子数组 要求。
    //转移方程： 若 dp[i-1] \leq 0dp[i−1]≤0 ，说明 dp[i - 1]dp[i−1] 对 dp[i]dp[i] 产生负贡献，即 dp[i-1] + nums[i]dp[i−1]+nums[i] 还不如 nums[i]nums[i] 本身大。
    //
    //当 dp[i - 1] > 0dp[i−1]>0 时：执行 dp[i] = dp[i-1] + nums[i]dp[i]=dp[i−1]+nums[i] ；
    //当 dp[i - 1] \leq 0dp[i−1]≤0 时：执行 dp[i] = nums[i]dp[i]=nums[i] ；
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int dp[] = new int[len];
        dp[0] = nums[0];
        int ans = dp[0];
        for(int i=1;i<len;i++){
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            ans = Math.max(ans,dp[i]);
        }

        return ans;
    }
}
