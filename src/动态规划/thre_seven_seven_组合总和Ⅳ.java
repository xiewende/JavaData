package 动态规划;

import org.junit.Test;

import java.util.Arrays;

/**
 * @create 2021-04-24  23:40
 */
public class thre_seven_seven_组合总和Ⅳ {

    @Test
    public void test()
    {
        int nums[] = {1,2,3};
        int target = 4;
        int i = combinationSum4(nums, target);
        System.out.println(i);
    }
    // dp[i] 表示target=i的时候总数
    // nums[] = 1 ,2,3  tager =4    j遍历nums数组
// dp[1]  = 1  i=1   i=nums[j]  ==> +1
// dp[2]  = 1+dp[1] = 2    i=2    i=nums[j]  ==> +1        i-nums[j] : 2-1 =1 ==> + dp[1]
// dp[3] = 1 + dp[2] + dp[1] = 4   i=3 i=nums[j] ==> +1   i-nums[j] : 3-1=2 ==> +dp[2]    3-2 = 1  ==> +dp[1]
// dp[4] = dp[3] + dp[2] + dp[1] = 7 i=4    i-nums[j] : 4-1=3 ==> +dp[3]    4-2=2  ==> +dp[2]  4-3=1 ==> +dp[1]
    public int combinationSum4(int[] nums, int target) {
        int dp[] = new int[target+1];
        dp[0] = 1;
        for(int i = 1;i<dp.length;i++){
            for(int j=0;j<nums.length;j++){
                //if(nums[j] == target) dp[i] += 1;
                if(i-nums[j]>=0) dp[i] += dp[i-nums[j]];
            }
        }
        return dp[target];
        /*Arrays.sort(nums);
        int dp[] = new int[target+1];
        dp[0] = 1;
        for(int i = 1;i<dp.length;i++){
            for(int j=0;j<nums.length&&nums[j]<=i;j++){
                //if(nums[j] == target) dp[i] += 1;
                if(i-nums[j]>=0) dp[i] += dp[i-nums[j]];
            }
        }
        return dp[target];*/
    }

    //回说，直接超时
    public int res = 0;
    public void backtrack1(int[] nums, int target,int sum){
        if(sum == target){
            res++;
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(sum+nums[i]>target) continue;
            backtrack1(nums,target,sum +nums[i]);
        }
    }

}
