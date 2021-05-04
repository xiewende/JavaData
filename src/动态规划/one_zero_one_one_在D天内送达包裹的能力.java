package 动态规划;

import org.junit.Test;

/**
 * @create 2021-04-26  23:52
 */
public class one_zero_one_one_在D天内送达包裹的能力 {


    public static void main(String[] args){

    }

   /* @Test
    public void test(){
        int weights[] = {1,2,3,1,1};
        int D = 4;
        int i = shipWithinDays3(weights, D);
        System.out.println(i);
    }*/
// D = 3
//  1 2 3 4 5

// dp[1][j] = 1 3 6 10 15           10 ; 4,dp[i-1][j-1]=6  6 ; 7，dp[i-1][j-2]=3 7; 9 dp[i-1][j-2] 9
// dp[2][j] = 1 2 3  6                3 h dp[i-1][j-1] 3    5  dp[i-1][j-2]  5
// dp[3][j] = 1 2                    2,dp[i-1][j-1]=1 2
//                                    3,dp[i-1][j-1]=2  3   dp[i-1][j-2]=1, 5=dp[1][j]-dp[i-1][j-2]   5

    //超出内存限制  动态规划
    public int shipWithinDays(int[] weights, int D) {
        int len = weights.length;
        int dp[][] = new int[D+1][len+1];
        dp[1][1] = weights[0];
        for(int i=2;i<=len;i++){
            dp[1][i] = dp[1][i-1]+weights[i-1];
        }
        for(int i=2;i<=D;i++){
            for(int j=1;j<=len-D+i;j++){
                int min = Integer.MAX_VALUE;
                for(int k=1;k<=j;k++){
                    min = Math.min(min,Math.max(dp[1][j]-dp[1][j-k],dp[i-1][j-k]));
                }
                dp[i][j] = min;
            }
        }
        return dp[D][len];
    }

    //超出时间限制  动态规划
    public int shipWithinDays1(int[] weights, int D) {
        int len = weights.length;
        int sum[] = new int[len+1];
        sum[1] = weights[0];
        for(int i=2;i<=len;i++){
            sum[i] = sum[i-1]+weights[i-1];
        }
        int dp[] = new int[len+1];
        for(int i=len-D+1;i>0;i--){
            dp[i] = sum[i];
        }
        for(int i=2;i<=D;i++) {
            for (int j = len-D+i; j >= 1; j--) {
                int min = Integer.MAX_VALUE;
                for (int k = 1; k <= j; k++) {
                    min = Math.min(min, Math.max(sum[j] - sum[j - k], dp[j - k]));
                }
                dp[j] = min;
            }
        }
        return dp[len];
    }


    //看公众号文章，二分+贪心！！！牛
    public int shipWithinDays3(int[] weights, int D) {
        //确定左右边界
        int left=0;

        //right为全部和
        //int right = 0;
        for(int i=0;i<weights.length;i++){
            left = Math.max(left,weights[i]);
         //   right += weights[i];
        }

        //优化 缩小right的值，让她不再是和。最大应该是假设每个货物都为最大，平均每天能带多少
        //注：当D > weights.length 时, right < left 即 此时会直接返回 left。而背后的逻辑是，当天数大于货物数量，
        //那么只要每天至少搬一个货物上船即可，此时可以达到区间的最小，即货物的最大重量
        int right = left * weights.length / D + 1;

        int mid;
        //进行二分查找
        while (left<=right){
            mid = left + (right-left) / 2 ;
            if(judge(weights,D,mid)){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    //用于判断在 运载能力为sum的时候能否在D天内运输完毕！！采用贪心的策略
    public boolean judge(int[] weights, int D,int sum){
        int count = 0;
        int temSum = 0;
        for(int i=0;i<weights.length;i++){
            temSum += weights[i];
            if(temSum > sum){
                count++;
                temSum = weights[i];
            }
            if(count>D-1){
                return false;
            }
        }
        return true;
    }




}
