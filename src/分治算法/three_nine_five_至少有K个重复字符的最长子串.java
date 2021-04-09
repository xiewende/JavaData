package 分治算法;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wjw
 * @date 2021/2/27 22:49
 */
public class three_nine_five_至少有K个重复字符的最长子串 {

    @Test
    public void test(){
        String s = "aaabb";    int k = 3;
        int res = longestSubstring(s, k);
        System.out.println(res);
    }

    int res = 0;
    public int longestSubstring(String s, int k) {
        if (k == 1) return s.length();  //优化1
        if (s.length() < k) return 0;   //优化2
        if (s.length() < res) return res; //优化3

        char[] strs = s.toCharArray();
        int[] alph = new int[26];   //s中的字母统计

        for (char c : strs) alph[c - 'a']++;

        int i = 0;
        for (i = 0; i < strs.length; i++) {
            if (alph[strs[i] - 'a'] < k) break;
        }

        //递归出口
        if (i == s.length()) return s.length();

        String[] str = s.split(String.valueOf(strs[i]));

        for (String p : str) {
            int ret = longestSubstring(p, k);
            res = Math.max(res, ret);
        }

        return res;
    }
}
