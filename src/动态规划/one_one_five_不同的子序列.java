package 动态规划;

import org.junit.Test;

/**
 * @author wjw
 * @date 2021/3/17 23:46
 */
public class one_one_five_不同的子序列 {

    @Test
    public void test(){
        String s = "babgbag";
        String t = "bag";
        int res = numDistinct(s, t);
        System.out.println(res);
    }

    public int numDistinct(String s, String t) {
        char[] sch = s.toCharArray();
        char[] tch = t.toCharArray();
        int row = t.length(), col = s.length();
        int[][] dp = new int[row + 1][col + 1];

        //巧妙的把第一行置为1
        for (int i = 0; i <= col; i++){
            dp[0][i] = 1;
        }

        for(int i = 1; i <= row; i++){
            for(int j = i; j <= col; j++){
                if(tch[i - 1] != sch[j - 1]) dp[i][j] = dp[i][j - 1];
                else dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
            }
        }

        return dp[row][col];
    }
}

/*
    r   a   b   b   b   i   t

r   1   0   0   0   0   0   0

a   0   1   0   0   0   0   0

b   0   0   1   2   3   0   0

b   0   0   0   1   3   0   0

i   0   0   0   0   0   3   0

t   0   0   0   0   0   0   3


    r   a   b   b   b   b   i   t

r   1   1   1   1   1   1   1   1

a   0   1   1   1   1   1   1   1

b   0   0   1   2   3   4   4   4

b   0   0   0   1   3   6   6   6

i   0   0   0   0   0   0   6   6

t   0   0   0   0   0   0   0   6


    b   a   b   g   b   a   g

b   1   1   2   2   3   3   3

a   0   1   1   1   1   4   4

g   0   0   0   1   1   1   5

观察可得：
不等：左
相等：左+左上

数学解释(以上面的第三个为例)：
当遍历到s串为babgba，t串为ba时：
如果用了当前的a，则描述为：在前面的babgb中找b，那么就是dp[i-1][j-1]的意义
如果不用当前的a，则描述为：在前面的babgb中找ab，那么就是dp[i][j-1]的意义
故：dp[i][j] = dp[i-1][j-1] + dp[i][j-1]
*/