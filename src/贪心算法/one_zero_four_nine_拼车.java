package 贪心算法;

import java.util.HashMap;
import java.util.Map;

/**
 * @create 2020-02-12  11:52
 */



/*
* 本题直接解答比较复杂，可以采用统计学的方法进行加加减减操作，可以很容易解答本题。
因为 0 <= trips[i][1] < trips[i][2] <= 1000，可以开一个大小为 1001 的数组 cnt 来代表每个地点的人数。
遍历 trips，在上车点加上对应人数，在下车点减去对应人数。
最终数组 cnt 每个位置的前缀和就是对应地点上的乘客数量，判断是否满足条件就比较简单了
*
* */
public class one_zero_four_nine_拼车 {

    public static void main(String[] args) {
        Map<Integer, Integer> start = new HashMap<>();
        start.put(1, 9);
        System.out.println(start.getOrDefault(1, 2));
    }

    /*
输入：trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11
输出：true
*/
    public boolean carPooling(int[][] trips, int capacity) {
        int[] cnt = new int[1001];
        for (int[] trip : trips) {
            cnt[trip[1]] += trip[0];
            cnt[trip[2]] -= trip[0];
        }
        if (cnt[0] > capacity) return false;
        for (int i = 1; i < 1001; ++i) {
            cnt[i] += cnt[i - 1];
            if (cnt[i] > capacity) {
                return false;
            }
        }
        return true;
    }

    /*
    *一个Map(上车点，上车人数)，一个Map(下车点，下车人数)。
    * 然后for循环整个路程，在每个下车点减下车的人数，每个上车点加上车的人数，
    * 期间如果总人数大于capacity，返回false，否则返回true。
    *
    * 输入：trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11
      输出：true
    * */
    public boolean carPooling1(int[][] trips, int capacity) {
        Map<Integer, Integer> start = new HashMap<>();
        Map<Integer, Integer> end = new HashMap<>();

        //min———max：整个行驶区间
        int max = trips[0][2], min = trips[0][1];
        for (int[] t : trips) {
            //遇到上车点相同或者下车点相同，把它们的人数相加即可
            start.put(t[1], start.getOrDefault(t[1], 0) + t[0]);
            end.put(t[2], end.getOrDefault(t[2], 0) + t[0]);
            min = Math.min(min, t[1]);
            max = Math.max(max, t[2]);
        }
        int cur = 0; //现在车上的人数
        for (int i = min; i <= max; i++) {
            if (end.containsKey(i))
                cur -= end.get(i);
            if (start.containsKey(i))
                cur += start.get(i);
            if (cur > capacity)
                return false;
        }
        return true;
    }


}
