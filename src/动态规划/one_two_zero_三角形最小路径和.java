package 动态规划;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wjw
 * @date 2021/2/28 23:18
 */
public class one_two_zero_三角形最小路径和 {

    @Test
    public void test(){
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add( Arrays.stream(new int[]{2}).boxed().collect(Collectors.toList()));
        triangle.add( Arrays.stream(new int[]{3,4}).boxed().collect(Collectors.toList()));
        triangle.add( Arrays.stream(new int[]{6,5,7}).boxed().collect(Collectors.toList()));
        triangle.add( Arrays.stream(new int[]{4,1,8,3}).boxed().collect(Collectors.toList()));
        int res = minimumTotal4(triangle);
        System.out.println(res);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> list = new ArrayList<>();
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.size(); i++){
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int lParent = (i - 1 >= 0 && j - 1 >= 0) ? list.get(i - 1).get(j - 1) : Integer.MAX_VALUE;
                int rParent = (i - 1 >= 0 && j < list.get(i - 1).size()) ? list.get(i - 1).get(j) : Integer.MAX_VALUE;
                if(lParent == Integer.MAX_VALUE && rParent == Integer.MAX_VALUE) rParent = 0;

                int cur = Math.min(lParent, rParent) + triangle.get(i).get(j);
                row.add(cur);

                if (i == triangle.size() - 1){
                    res = Math.min(res, cur);
                }
            }
            list.add(row);
        }
        return res;
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] arr = new int[n];
        int res = Integer.MAX_VALUE;
        int lParent = Integer.MAX_VALUE, rParent = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++){
            for (int j = 0; j <= i; j++) {
                rParent = (i - 1 >= 0 && j < i) ? arr[j] : Integer.MAX_VALUE;
                if(lParent == Integer.MAX_VALUE && rParent == Integer.MAX_VALUE) lParent = 0;
                int cur = Math.min(lParent, rParent) + triangle.get(i).get(j);

                arr[j] = cur;
                lParent = rParent;

                if (i == n - 1){
                    res = Math.min(res, cur);
                }
            }
        }
        return res;
    }

    public int minimumTotal3(List<List<Integer>> triangle) {

        int re = Integer.MAX_VALUE;
        int len1 = triangle.size();
        int len2 = triangle.get(triangle.size()-1).size();
        int dp[][] = new int[len1+1][len2+1];
        for(int i=0;i<=len1;i++){
            for(int j=0;j<=len2;j++){
                dp[i][j] =0;
            }
        }
        //dp[1][1] = triangle.get(0).get(0);
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=i;j++){
                //左边
                if(j==1){
                    dp[i][j] = dp[i-1][j]+triangle.get(i-1).get(j-1);
                }else if(j==i){ //右边
                    dp[i][j] = dp[i-1][j-1]+triangle.get(i-1).get(j-1);
                }else { //中间
                    dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-1])+triangle.get(i-1).get(j-1);
                }
                if(i==len1){
                    re = Math.min(re,dp[i][j]);
                }
            }
        }
        return re;
    }

    //从后往前装 ，优化空间数组
    public int minimumTotal4(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] arr = new int[n];
        for(int i = 0; i < triangle.get(n - 1).size(); i++) arr[i] = triangle.get(n - 1).get(i);
        for (int i = n - 2; i >= 0; i--){
            for (int j = 0; j <= i; j++) {
                arr[j] = Math.min(arr[j], arr[j + 1]) + triangle.get(i).get(j);
            }
        }
        return arr[0];
    }
}
