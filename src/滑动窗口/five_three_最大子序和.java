package 滑动窗口;

import org.junit.Test;

/**
 * @create 2021-02-12  16:31
 */
public class five_three_最大子序和 {


    @Test
    public void test(){
        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        int re = maxSubArray1(nums);
        System.out.println(re);
    }
    //存粹递归实现//存粹递归实现
    public int maxSubArray(int[] nums) {
        //需要遍历这个数组，求出每一个位置的最大值
        //比较即可
        int re = Integer.MIN_VALUE;
        for(int i=0 ;i<nums.length ;i++){
            re = Math.max(re,fun(i,nums));
        }

        return re;
    }
    //以每个n位置结束的位置的最大和
    public static int fun(int n,int[] nums){
        int ans = 0;
        if(n==0){
            ans = nums[0];
        }else {
            ans = Math.max(nums[n],nums[n]+fun(n-1,nums));
        }
        return ans;
    }

    //存粹递归 + 记忆化，比方法1以优化了一些
    public int maxSubArray1(int[] nums) {
        //定义记忆数组
        int reme[] = new int[nums.length];
        for(int i=0;i<reme.length;i++){
            reme[i] = Integer.MIN_VALUE;
        }
        //需要遍历这个数组，求出每一个位置的最大值
        //比较即可
        int re = Integer.MIN_VALUE;
        for(int i=0 ;i<nums.length ;i++){
            re = Math.max(re,fun2(i,nums,reme));
        }

        return re;
    }
    //以每个n位置结束的位置的最大和  具有记忆化辽
    public static int fun2(int n,int[] nums,int reme[]){
        int ans = 0;

        //寻找记忆
        if(reme[n]!=Integer.MIN_VALUE){
            ans = reme[n];
        }
        //没有记忆，干算
        if(n==0){
            ans = nums[0];
        }else {
            ans = Math.max(nums[n],nums[n]+fun2(n-1,nums,reme));
        }
        //记忆赋值
        reme[n] = ans;
        return ans;
    }

    //使用动态规划来求 状态方程  前j个的最大+第j个值  与 第j个值比较  谁大取谁
    //dp[i] = Math.max(nums[i],nums[i]+dp[i-1]); i是指下标
    public int maxSubArray2(int[] nums) {
        //结果
       int max = nums[0];
       int dp[] = new int[nums.length];
       dp[0] = nums[0];  //初始化
       for(int i=1;i<nums.length;i++){
           dp[i] = Math.max(nums[i],nums[i]+dp[i-1]);
           max = Math.max(max,dp[i]);
       }
       return max;
    }
}
