package 动态规划;

import org.junit.Test;

/**
 * @create 2021-05-22  23:56
 */
public class one_zero_three_five_不相交的线 {

    @Test
    public void test(){
        int nums1[] = {1,3,7,1,7,5};
        int nums2[] = {1,9,2,5,1};
        int i = maxUncrossedLines(nums1, nums2);
        System.out.println(i);
    }

    //动态规划
    public int maxUncrossedLines(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;

        int dp[][] = new int[len1+1][len2+1];

        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[len1][len2];

    }

}
