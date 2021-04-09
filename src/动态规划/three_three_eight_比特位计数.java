package 动态规划;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author wjw
 * @date 2021/3/3 22:18
 */
public class three_three_eight_比特位计数 {

    @Test
    public void test(){
        int[] res = countBits2(11);
        System.out.println(Arrays.toString(res));
    }

    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            String s = Integer.toBinaryString(i);
            int oneBitNum = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '1'){
                    oneBitNum++;
                }
            }
            res[i] = oneBitNum;
        }
        return res;
    }

    //动态规划
    // 找规律  dp【i】表示数字1得最少最小1个数
    //先定位数字 i 在哪一个区间，1 2 4 8，就是找到i在2的最小整数次幂上面,这个整数次幂的数值为j  j是整数次幂的值
    // 比如  数字 i=3 则j=2  数字 i= 5 6 7 ，则j = 4；以此类推   dp[j] = 1
    // dp[i] = dp[j] + dp[i-j]
    public int[] countBits2(int num) {
        int[] dp = new int[num + 1];
        int turn = -1;  //第几轮 base为1 << turn

        for (int i = 1; i <= num; i++) {
            if(1<<(turn+1) == i){
                dp[i] = 1;
                turn++;
                continue;
            }
            int base = 1<<turn;
            dp[i] = dp[base] + dp[i - base];
        }
        return dp;
    }

    //大佬级别 动态规划找规律
    public int[] countBits3(int num) {
        int[] ans = new int[num + 1];
        for(int i = 1; i < num + 1; i ++)
            ans[i] = ans[(i & (i - 1))] + 1;
        return ans;
    }
}
