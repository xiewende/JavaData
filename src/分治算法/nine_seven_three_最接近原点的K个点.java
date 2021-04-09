/**
 * @author wjw
 * @date 2020/3/15 20:51
 */
package 分治算法;

import org.junit.Test;

import java.util.*;

public class nine_seven_three_最接近原点的K个点 {
    @Test
    public void test(){
        int[][] points ={{1, 3}, {-2, 2}};
//        int[][] points ={{3, 3}, {5,-1}, {-2, 4}};
        int[][] res = kClosest3(points, 1);
        System.out.println(Arrays.toString(res));
    }

    public int[][] kClosest1(int[][] points, int K) {
        int[][] res = new int[K][2];
        if (points.length == 0 || points[0].length == 0 || K == 0){
            return res;
        }
        int[] dis = new int[points.length];
        //计算距离
        for (int i = 0; i < points.length; i++){
            dis[i] = (int) (Math.pow(points[i][0], 2) +  Math.pow(points[i][1], 2));
        }
        //找k个
        for (int i = 0; i < K; i++){
            //每次遍历dis找最小值
            int min = Integer.MAX_VALUE;
            //最小值对应的下标
            int cur = 0;
            for (int j = 0; j < dis.length; j++){
                if (dis[j] < min) {
                    min = dis[j];
                    cur = j;
                }
            }
            dis[cur] = Integer.MAX_VALUE;
            res[i] = points[cur];
        }
        return res;
    }

    public int[][] kClosest2(int[][] points, int K) {
        int[][] res = new int[K][2];
        if (points.length == 0 || points[0].length == 0 || K == 0){
            return res;
        }
        int[] dis = new int[points.length];
        Map<Integer, List<Integer>> map = new HashMap<>();
        //计算距离
        for (int i = 0; i < points.length; i++){
            dis[i] = (int) (Math.pow(points[i][0], 2) +  Math.pow(points[i][1], 2));
            if (map.get(dis[i]) == null){
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(dis[i], list);
            }else {
                map.get(dis[i]).add(i);
            }
        }
        Arrays.sort(dis);
        int i = 0;  //用来记录res下标
        int j = 0;  //dis下标
        while (i != K){
            List<Integer> list = map.get(dis[j]);
            for (Integer index : list) {
                res[i] = points[index];
                i++;
                //某个dis的集合里面就已经大于K了
                if(i == K){
                    break;
                }
            }
            j++;
        }
        return res;
    }

    public int[][] kClosest3(int[][] points, int K) {
        int N = points.length;
        int[] dists = new int[N];
        for (int i = 0; i < N; ++i) {
            dists[i] = dist(points[i]);
        }

        Arrays.sort(dists);
        int distK = dists[K-1];

        int[][] ans = new int[K][2];
        int t = 0;
        for (int i = 0; i < N; ++i) {
            if (dist(points[i]) <= distK) {
                ans[t++] = points[i];
            }
        }
        return ans;
    }

    public int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
