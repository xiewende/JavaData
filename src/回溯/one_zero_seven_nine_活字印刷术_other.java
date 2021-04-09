/**
 * @author wjw
 * @date 2020/2/17 21:22
 */
package 回溯;


public class one_zero_seven_nine_活字印刷术_other {


    public int numTilePossibilities(String tiles) {

        int[] counter = new int[26];
        for (int i = 0; i < tiles.length(); i++) {
            counter[tiles.charAt(i) - 'A']++;
        }
        return dfs(counter);
    }

    public int dfs(int[] counter) {

        int sum = 0;
        for (int i = 0; i < 26; i++) {

            if (counter[i] > 0) {
                // 当前情况算一个
                sum++;
                counter[i]--;
                sum += dfs(counter);
                counter[i]++;
            }
        }
        return sum;
    }
}
