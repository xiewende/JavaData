package 动态规划;

/**
 * @create 2021-03-20  10:42
 */
public class one_one_eight_six_删除一次得到子数组最大和 {


//    设d[i][0]表示以元素A[i]结束，没有删除元素的最大子数组和。
//    设d[i][1]表示以元素A[i]结束，删除1个元素（可能删除A[i]，也可能是之前的元素）的最大子数组和。
//    初始值：d[0][0]=A[0]，d[0][1]=负无穷大。
//    递推关系：
//        ans = max(d[0][0],d[0][1]);解
//        for(i in [1,N-1]){
//        d[i][0] = max(d[i-1][0] + A[i],A[i]);
//        d[i][1] = max(d[i-1][1] + A[i],d[i-1][0]);
//        ans =max(ans,max(d[i][0],d[i][1]));

    public int maximumSum(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][2];// dp[i][0] // 没有删除数  dp[i][1] : 删除了一个数

        int res = arr[0];
        dp[0][0] = arr[0];
        dp[0][1] = arr[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0] + arr[i], arr[i]);//就是求 最大的连续子数组的和
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + arr[i]);//删了前面的或者当前这一个
            res = Math.max(Math.max(dp[i][0], dp[i][1]), res);
        }
        return res;
    }



}
