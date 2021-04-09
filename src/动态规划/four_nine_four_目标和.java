package 动态规划;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @create 2021-03-21  23:19
 */
public class four_nine_four_目标和 {

    @Test
    public void test(){
        int nums[] = {0,1}; // []
        int s = 1;
        int targetSumWays = findTargetSumWays1(nums, s);
        System.out.println(targetSumWays);
    }

    //回缩，这样写不超时
    public int findTargetSumWays(int[] nums, int S) {
        int length = nums.length;
        int all_num[][] = new int[2][length];

        for(int j=0;j<length;j++){
            all_num[0][j] = nums[j];
            all_num[1][j] = -nums[j];
        }

        dfs(all_num,0,0,0,length,S);
        return total;
    }
    int total = 0;
    public void dfs(int all_num[][],int sum,int index,int curr_length,int legth, int s){
        if(curr_length == legth){
            if(sum == s){
                total++;
            }
            return;
        }

        for(int i=0;i<2;i++){
            sum = sum + all_num[i][index];
            dfs(all_num,sum,index+1,curr_length+1,legth,s);
            sum = sum - all_num[i][index];
        }

    }

    //回溯，另外一种写法
    public int findTargetSumWays1(int[] nums, int S) {
        dfs1(nums, S, 0, 0);
        return ans;
    }
    private int ans = 0;
    private int[] signs = {1,0};           // 表示符号
    private void dfs1(int[] nums, int S, int depth, int sum) {
        if(depth == nums.length) {
            if(sum == S) {
                ans++;
            }
            return;
        }

        for (int sign: signs) {
            if(sign == 1) {
                sum += nums[depth];
            } else{
                sum -=nums[depth];
            }

            dfs1(nums, S, depth+1, sum);

            if(sign == 1) {
                sum -= nums[depth];
            } else {
                sum += nums[depth];
            }
        }

    }

    //垃圾
    public int findTargetSumWays2(int[] nums, int S) {
        int length = nums.length;
        if(length == 1 && (nums[0]==S || nums[0]==-S)){
            return 1;
        }
        List<Integer> curr = new ArrayList<>();
        List<Integer> next = new ArrayList<>();
        curr.add(S);
        int ans = 0;
        for(int i=length-1;i>=0;i--){
            for(int num:curr){
                int small = num - nums[i];
                int big = num + nums[i];
                if(i==1){
                    if(small == -nums[0] || small == nums[0]){
                        ans++;
                    }
                    if(big == -nums[0] || big == nums[0]){
                        ans++;
                    }
                }
                next.add(small);
                next.add(big);
            }
            curr = next;
            next = new ArrayList<>();
        }
        return ans;
    }

    //动态规划的方法
    //这道题也是一个常见的背包问题，我们可以用类似求解背包问题的方法来求出可能的方法数。
    //我们用 dp[i][j] 表示用数组中的前 i 个元素，组成和为 j 的方案数。考虑第 i 个数 nums[i]，它可以被添加 + 或 -，因此状态转移方程如下：
    //dp[i][j] = dp[i - 1][j - nums[i]] + dp[i - 1][j + nums[i]]

    public static int findTargetSumWays3(int[] nums, int s) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        // 绝对值范围超过了sum的绝对值范围则无法得到
        if (Math.abs(s) > Math.abs(sum)) return 0;

        int len = nums.length;
        // - 0 +
        int t = sum * 2 + 1;
        int[][] dp = new int[len][t];
        // 初始化
        if (nums[0] == 0) {
            dp[0][sum] = 2;
        } else {
            dp[0][sum + nums[0]] = 1;
            dp[0][sum - nums[0]] = 1;
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < t; j++) {
                // 边界
                int l = (j - nums[i]) >= 0 ? j - nums[i] : 0;
                int r = (j + nums[i]) < t ? j + nums[i] : 0;
                dp[i][j] = dp[i - 1][l] + dp[i - 1][r];
            }
        }
        return dp[len - 1][sum + s];
    }

}
