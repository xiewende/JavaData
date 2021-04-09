package 动态规划;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author wjw
 * @date 2021/3/8 23:24
 */
public class one_three_two_分割回文串II {

    @Test
    public void test(){
        String s = "";
        int res = minCut("abbab");
        System.out.println(res);
    }

    public int minCut(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();
        if (n == 0) return 0;
        int[] dp = new int[n];
        dp[0] = 0;

        for (int r = 1; r < n; r++){
            int min = Integer.MAX_VALUE;
            int l;
            for (l = 0; l < r; l++) {
                if (chars[l] == chars[r]){
                    if (isPalindrome(chars, l, r)){
                        if (l == 0) {
                            min = 0;
                            break;
                        }
                        else min = Math.min(min, dp[l - 1] + 1);
                    }
                }
            }
            if (l == r) min = Math.min(min, dp[l - 1] + 1);
            dp[r] = min;
        }
        return dp[n - 1];
    }

    private boolean isPalindrome(char[] chars, int l, int r){
        while (l < r){
            if (chars[l] != chars[r]) return false;
            l++;
            r--;
        }
        return true;
    }

    // 思想和方法1一样，只是不需要每次判断回文子串，而是一开始就记录下s[i:j]是否回文
    public int minCut2(String s) {
        int n = s.length();
        boolean[][] g = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(g[i], true);
        }

        // 一次记录，终生享受
        for (int r = 0; r <n; ++r) {
            for (int l = 0; l < r; ++l) {
                g[l][r] = s.charAt(l) == s.charAt(r) && g[l + 1][r - 1];
            }
        }

        int[] f = new int[n];
        Arrays.fill(f, Integer.MAX_VALUE);
        for (int i = 0; i < n; ++i) {
            if (g[0][i]) {
                f[i] = 0;
            } else {
                for (int j = 0; j < i; ++j) {
                    if (g[j + 1][i]) {
                        f[i] = Math.min(f[i], f[j] + 1);
                    }
                }
            }
        }

        return f[n - 1];
    }
}
