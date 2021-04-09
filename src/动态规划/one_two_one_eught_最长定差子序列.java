package 动态规划;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @create 2021-03-15  22:58
 */
public class one_two_one_eught_最长定差子序列 {

    @Test
    public void test(){
        int[] arr = {1,5,7,8,5,3,4,2,1};
        int difference = -2;
        int i = longestSubsequence2(arr, difference);
        System.out.println(i);
    }

    public int longestSubsequence(int[] arr, int difference) {
        if(arr == null || arr.length == 0){
            return 0;
        }
        int dp[] = new int[arr.length];
        dp[0] = 1;
        for(int i=1;i<arr.length;i++){
            int max = Integer.MIN_VALUE;
            for(int j=i-1;j>=0;j--){
                if(arr[i]-arr[j]==difference){
                    max = Math.max(max,dp[j]);
                    break;
                }
            }
            dp[i] =  max==Integer.MIN_VALUE ? 1: max+1;
        }
        int ans = 0;
        for(int i=0;i<dp.length;i++){
            ans = dp[i]>ans ? dp[i]:ans;
        }
        return ans;
    }

    //超时的优化
    public int longestSubsequence4(int[] arr, int difference) {
        int res = 0;

        int len = arr.length;
        int[] dp = new int[len];

        Map<Integer,Integer> map = new HashMap();//用map存储已经求过的最长子序列值

        for(int i = 0; i < len;i++) {
            dp[i] = 1;//将自己计算在内

            if(map.containsKey(arr[i] - difference)) {//判断是否存在差值为difference的最长子序列
                dp[i] = Math.max(dp[i], map.get(arr[i] - difference) + 1);
            }

            map.put(arr[i],dp[i]);//存于map，以便后续查找
            //双重遍历，超时
            // for(int j = i-1; j >= 0; j--) {
            //     if(arr[i] - arr[j] == difference) {
            //         dp[i] = Math.max(dp[i], dp[j] + 1);
            //         break;
            //     }
            // }
            res = Math.max(res,dp[i]);
        }

        return res;
    }


    //和上面的思想一致，就是实现的问题
    public int longestSubsequence3(int[] arr, int difference) {
        int[] dp = new int[20001];
        int ans = 1;
        for(int i=0; i<arr.length; i++){
            arr[i] += 10000;
        }
        for(int i=0; i<arr.length; i++){
            if(arr[i]-difference < 0 || arr[i]-difference > 20000){
                dp[arr[i]] = 1;
            }
            else{
                dp[arr[i]] = dp[arr[i] - difference] + 1;
                ans = Math.max(dp[arr[i]], ans);
            }
        }
        return ans;
    }

    public int longestSubsequence1(int[] arr, int difference) {
        if(arr == null || arr.length == 0){
            return 0;
        }
        int ans = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                int curr = map.get(arr[i]);
                if(map.containsKey(arr[i]+difference)){
                    int curr_next = map.get(arr[i]+difference);
                    map.put(arr[i]+difference,Math.max(curr_next,curr+1));
                }else {
                    map.put(arr[i]+difference,curr+1);
                }
                ans = Math.max(map.get(arr[i]+difference)-1,ans);
                //map.remove(arr[i]);
            }else {
                map.put(arr[i]+difference,2);
            }
        }
        return ans;
    }


    public int longestSubsequence2(int[] arr, int difference) {
        if(arr == null || arr.length == 0){
            return 0;
        }
        for(int i=0; i<arr.length; i++){
            arr[i] += 20000;
        }
        int ans = 1;
        int dp[] = new int[40001];
        for(int i=0;i<arr.length;i++){
            if(dp[arr[i]]!=0){
                int curr = dp[arr[i]];
                if(dp[arr[i]+difference]!=0){
                    int curr_next = dp[arr[i]+difference];
                    dp[arr[i]+difference] = Math.max(curr_next,curr+1);
                }else {
                    dp[arr[i]+difference] = curr+1;
                }
                ans = Math.max(dp[arr[i]+difference]-1,ans);
                //map.remove(arr[i]);
            }else {
                dp[arr[i]+difference] = 2;
            }
        }
        return ans;
    }
}
