package 动态规划;

import org.junit.Test;

/**
 * @create 2021-02-19  15:15
 */
public class three_zero_zero_最长递增子序列 {

    @Test
    public void test(){
        int nums[] = {7,7,7,7,7,7,7};
        System.out.println(lengthOfLIS4(nums));
    }

    //方法1：完全采取递归的策略
    public int lengthOfLIS(int[] nums) {
        int re = 0;
        for(int i=0;i<nums.length;i++){
            re = Math.max(re,fun(i,nums));
        }
        return re;
    }

    //函数是以n为最后下标的最大不连续递增序列和  F[i] = max（1，F[j]+1）其中i<j
    public int fun(int n,int[] nums){
        int ans;
        if(n==0){
            ans = 1;
        }else {
            ans = 1;
            for(int i=0;i<n;i++){
                if(nums[i]<nums[n]){
                    ans = Math.max(ans,fun(i,nums)+1);
                }
            }
        }
        return ans;
    }


    //方法2：记忆化+递归
    public int lengthOfLIS1(int[] nums) {

        //建立记忆数组
        int rem[] = new int[nums.length];
        for(int j=0;j<nums.length;j++){
            rem[j] = -1;
        }

        int re = 0;
        for(int i=0;i<nums.length;i++){
            re = Math.max(re,fun1(i,nums,rem));
        }
        return re;
    }

    //函数是以n为最后下标的最大不连续递增序列和  F[i] = max（1，F[j]+1）其中i<j
    public int fun1(int n,int[] nums,int[] rem){

        //使用记忆
        if(rem[n]!=-1){
            return rem[n];
        }

        int ans;
        if(n==0){
            ans = 1;
        }else {
            ans = 1;
            for(int i=0;i<n;i++){
                if(nums[i]<nums[n]){
                    ans = Math.max(ans,fun1(i,nums,rem)+1);
                }
            }
        }

        //记忆
        rem[n] = ans;
        return ans;
    }


    //方法3：递推的方式也就是动态规划方法  F[i] = max（1，F[j]+1）其中i<j
    public int lengthOfLIS2(int[] nums) {
        //建立dp数组
        int dp[] = new int[nums.length];
        //完善dp数组
        for(int j=0 ;j<nums.length;j++){
            int ans;
            if(j==0){
                ans = 1;
            }else {
                ans = 1;
                for(int i=0;i<j;i++){
                    if(nums[i]<nums[j]){
                        ans = Math.max(ans,dp[i]+1);
                    }
                }
            }
            dp[j] = ans;
        }
        //查找结果了
        int re = 0;
        for(int i=0;i<nums.length;i++){
            re = Math.max(re,dp[i]);
        }
        return re;
    }

    /**
     方法4：
     dp[i]: 所有长度为i+1的递增子序列中, 最小的那个序列尾数.
     由定义知dp数组必然是一个递增数组, 可以用 maxL 来表示最长递增子序列的长度.
     对数组进行迭代, 依次判断每个数num将其插入dp数组相应的位置:
     1. num > dp[maxL], 表示num比所有已知递增序列的尾数都大, 将num添加入dp
     数组尾部, 并将最长递增序列长度maxL加1
     2. dp[i-1] < num <= dp[i], 只更新相应的dp[i]
     **/
    public int lengthOfLIS3(int[] nums) {

        int maxL = 0;
        int[] dp = new int[nums.length];
        for(int num : nums) {
            // 二分法查找, 也可以调用库函数如binary_search
            int lo = 0, hi = maxL;
            while(lo < hi) {
                int mid = lo+(hi-lo)/2;
                if(dp[mid] < num)
                    lo = mid+1;
                else
                    hi = mid;
            }

            dp[lo] = num;
            if(lo == maxL)
                maxL++;
        }
        return maxL;
    }

    /**
     方法5：不用二分 直接顺序查找
     dp[i]: 所有长度为i+1的递增子序列中, 最小的那个序列尾数.
     由定义知dp数组必然是一个递增数组, 可以用 maxL 来表示最长递增子序列的长度.
     对数组进行迭代, 依次判断每个数num将其插入dp数组相应的位置:
     1. num > dp[maxL], 表示num比所有已知递增序列的尾数都大, 将num添加入dp
     数组尾部, 并将最长递增序列长度maxL加1
     2. dp[i-1] < num <= dp[i], 只更新相应的dp[i]
     **/
    public int lengthOfLIS4(int[] nums) {

        int maxL = 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int num : nums) {
            // 二分法查找, 也可以调用库函数如binary_search
//            int lo = 0, hi = maxL;
////            while(lo < hi) {
////                int mid = lo+(hi-lo)/2;
////                if(dp[mid] < num)
////                    lo = mid+1;
////                else
////                    hi = mid;
////            }
            int i;
            for(i=0;i<maxL;i++){
                if(num<=dp[i]){
                   break;
                }
            }
            dp[i] = num;
            if(i == maxL)
                maxL++;
        }
        return maxL;
    }
}
