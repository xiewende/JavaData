package 动态规划;

import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @create 2021-05-05  23:17
 */
public class seven_four_zero_删除并获得点数 {

    @Test
    public void test(){
        int nums[] = {2,3,4};
        int i = deleteAndEarn1(nums);
        System.out.println(i);
    }

    //主动删除 or 被动删除
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        int dp[] = new int[nums.length+1];
        dp[1] = nums[0];
        int curSum =nums[0];
        for(int i=2 ;i<dp.length;i++){
            if(nums[i-1] == nums[i-2]) curSum += nums[i-1];
            else  curSum = nums[i-1];

            int lastLastIdx=0;
            int lastIdx=0;
            for(int j=i-1;j>=0;j--){
                if(nums[j] != nums[i-1]-1 && nums[j]!=nums[i-1]){
                    lastLastIdx = j+1;
                    break;
                }
            }

            for(int k=i-1;k>=0;k--){
                if(nums[k] == nums[i-1]-1){
                    lastIdx = k+1;
                    break;
                }
            }
            dp[i] = Math.max(curSum+dp[lastLastIdx],dp[lastIdx]);
        }
        return dp[nums.length];

    }

    public int deleteAndEarn1(int[] nums) {
        Arrays.sort(nums);
        int dp[] = new int[nums.length+1];
        dp[1] = nums[0];
        int curSum =nums[0];
        ArrayList<Integer> nList = new ArrayList<>();
        ArrayList<Integer> iList = new ArrayList<>();
        nList.add(0);
        iList.add(0);
        for(int i=2 ;i<dp.length;i++){
            if(nums[i-1] == nums[i-2]) curSum += nums[i-1];
            else {
                nList.add(nums[i-2]);
                iList.add(i-1);
                curSum = nums[i-1];
            }
            int lastLastIdx;

            if(nList.contains(nums[i-1]-1))  lastLastIdx= nList.size()<2 ? 0 : iList.get(iList.size()-2) ;  //
            else lastLastIdx = iList.get(iList.size()-1);

            int lastIdx = nList.size()<2 ? 0 : iList.get(iList.size()-1);
            dp[i] = Math.max(curSum+dp[lastLastIdx],dp[lastIdx]);
        }
        return dp[nums.length];

    }
}
