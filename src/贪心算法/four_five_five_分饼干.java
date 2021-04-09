package 贪心算法;

import java.util.Arrays;

/**
 * @create 2020-02-12  11:26
 */
public class four_five_five_分饼干 {

    public int findContentChildren(int[] g, int[] s) {

        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                count++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        System.out.println(count);
        return count;


    }
}
