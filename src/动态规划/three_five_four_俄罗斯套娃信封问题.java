package 动态规划;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wjw
 * @date 2021/3/4 22:51
 */

//与最长递增子序列一模一样
public class three_five_four_俄罗斯套娃信封问题 {

    @Test
    public void test(){
        int[][] envelopes = {{46,89},{50,53},{52,68},{72,45},{77,81}};
//        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        int res = maxEnvelopes2(envelopes);
        System.out.println(res);
    }

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || envelopes[0].length == 0) return 0;
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0]==o2[0]) return o1[1]-o2[1];
            return o1[0]-o2[0];
        });

        int n = envelopes.length;
        int[] dp = new int[n];   //到dp[i]的最大套娃数
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                //envelopes[i][0] > link[0] && envelopes[i][1] > link[1]
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
        }

        int res = 0;
        for (int i : dp) {
            res = Math.max(res, i);
        }

        return res;
    }

    public int maxEnvelopes2(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }

        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] e1, int[] e2) {
                if (e1[0] != e2[0]) {
                    return e1[0] - e2[0];
                } else {
                    return e2[1] - e1[1];
                }
            }
        });

        List<Integer> f = new ArrayList<Integer>();
        f.add(envelopes[0][1]);
        for (int i = 1; i < n; ++i) {
            int num = envelopes[i][1];
            if (num > f.get(f.size() - 1)) {
                f.add(num);
            } else {
                int index = binarySearch(f, num);
                f.set(index, num);
            }
        }
        return f.size();
    }

    public int binarySearch(List<Integer> f, int target) {
        int low = 0, high = f.size() - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (f.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
