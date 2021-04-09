package 滑动窗口;

import org.junit.Test;

import java.util.Arrays;

public class one_two_zero_eight_尽可能使字符串相等 {

    @Test
    public void test(){
        String s = "abcd", t = "bcdf";
        int cost = 3;
        int res = equalSubstring(s, t, cost);
        System.out.println(res);
    }

    public int equalSubstring(String s, String t, int maxCost) {
        int res = 0;
        int[] dis = new int[s.length()];
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        //统计s[i]和t[i]的差距
        for (int i = 0; i < s.length(); i++) {
            dis[i] = Math.abs(sArr[i] - tArr[i]);
        }

        //因为子字符串要求连续，所以滑动窗口
        int l = 0, r = 0, len = 0;
        while (r < s.length()){
            if ((len + dis[r]) <= maxCost){
                len += dis[r];
                r++;
            }else {
                len -= dis[l];
                l++;
            }
            res = Math.max(res, r - l);
        }

        return res;
    }
}
