package 动态规划;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @create 2021-03-20  22:55
 */
public class three_six_eight_最大整除子集 {

    @Test
    public void test(){
        int nums[] = {1,2,3,4,6,24};
        List<Integer> list = largestDivisibleSubset1(nums);
        System.out.println(list.toString());
    }

    //dp[i]:为到数组 i 位置前的最大整除子集
    //状态转移方程  max = Math.max(max,dp[j]+1); 其中 0<j<i nums[i]%nums[j] == 0
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int dp[] = new int[length];
        List<List<Integer>> ans = new ArrayList<>();
        dp[0] = 1;
        List<Integer> tem1 = new ArrayList<>();
        tem1.add(nums[0]);
        ans.add(tem1);
        int ans_index = 0;
        for(int i=1;i<length;i++){
            int max = Integer.MIN_VALUE;
            int index = -1;
            for(int j=i-1;j>=0;j--){
                if(nums[i]%nums[j] == 0){
                    if(dp[j]+1>max){
                        max = dp[j]+1;
                        index = j;
                    }
                }
            }
            dp[i] = max==Integer.MIN_VALUE ? 1:max ;
            if(index == -1){//加自己
                List<Integer> tem2 = new ArrayList<>();
                tem2.add(nums[i]);
                ans.add(tem2);
            }else { //拿出index里面的List + 自己的这边
                List<Integer> list = new ArrayList<>(ans.get(index));
                list.add(nums[i]);
                ans.add(list);
            }
        }
        int curr = dp[0];
        for(int i=1;i<length;i++){
            if(dp[i]>curr){
                curr = dp[i];
                ans_index = i;
            }
        }
        return ans.get(ans_index);
    }

    //空间优化
    public List<Integer> largestDivisibleSubset1(int[] nums) {

        Arrays.sort(nums);
        int length = nums.length;
        int dp[] = new int[length];
        dp[0] = 1;
        List<Integer> ans = new ArrayList<>();
        int max_index = 0;
        int max_ans = Integer.MIN_VALUE;
        for(int i=1;i<length;i++){
            int max = Integer.MIN_VALUE;
            for(int j=i-1;j>=0;j--){
                if(nums[i]%nums[j] == 0){
                    max = Math.max(max,dp[j]+1);
                }
            }
            dp[i] = max==Integer.MIN_VALUE ? 1:max ;
            if(dp[i]>max_ans){
                max_ans = dp[i];
                max_index = i;
            }
        }
        ans.add(nums[max_index]);
        int curr = nums[max_index];
        for(int i=max_index-1;i>=0;i--){
            if(curr % nums[i] == 0 &&  dp[i]==max_ans-1){
                ans.add(nums[i]);
                curr = nums[i];
                max_ans--;
            }
        }
        return ans;
    }

    //w温帅解决时间复杂度
    public List<Integer> largestDivisibleSubset2(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int dp[] = new int[length];
        List<List<Integer>> ans = new ArrayList<>();
        dp[0] = 1;
        List<Integer> tem1 = new ArrayList<>();
        tem1.add(nums[0]);
        ans.add(tem1);
        int ans_index = 0;
        int ans_max = 0 ;
        for(int i=1;i<length;i++){
            int max = Integer.MIN_VALUE;
            int index = -1;
            for(int j=i-1;j>=0;j--){
                if(nums[i]%nums[j] == 0){
                    if(dp[j]+1>max){
                        max = dp[j]+1;
                        index = j;
                    }
                }
            }
            dp[i] = max==Integer.MIN_VALUE ? 1:max ;
            if(dp[i]>ans_max){
                ans_max = dp[i];
                ans_index = i;
            }
            if(index == -1){//加自己
                List<Integer> tem2 = new ArrayList<>();
                tem2.add(nums[i]);
                ans.add(tem2);
            }else { //拿出index里面的List + 自己的这边
                List<Integer> list = new ArrayList<>(ans.get(index));
                list.add(nums[i]);
                ans.add(list);
            }
        }

        return ans.get(ans_index);
    }
}
