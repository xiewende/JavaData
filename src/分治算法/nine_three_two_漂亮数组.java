/**
 * @author wjw
 * @date 2020/3/11 16:36
 */
package 分治算法;

import org.junit.Test;

import java.util.*;

/*
 隔着取数，逐步打消他们之间的关系，递归的算法
 1 2 3 4 5 6 7 8 9 10 11 12
 1 3 5 7 9 11          2 4 6 8 10 12
 1 5 9    3 7 11     2 6 10     4 8 12
 19  5    3 11  7    2 10   6    4 12  8
* */
public class nine_three_two_漂亮数组 {
    @Test
    public void test(){
        int[] res = beautifulArray(15);
        System.out.println(Arrays.toString(res));
    }

    List<Integer> res = new ArrayList<>();

    public int[] beautifulArray(int N) {
        List<Integer> temp = new ArrayList<>();
        for(int i=1 ; i<=N ;i++){
            temp.add(i);
        }
        dfs(temp);
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    public void dfs(List<Integer> num){
        if(num.size() < 3){
            res.addAll(num);
            return ;
        }

        //2分
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i = 0; i < num.size(); i++){
            if ((i & 1) == 0){
                //奇
                left.add(num.get(i));
            }else {
                //偶
                right.add(num.get(i));
            }
        }
        dfs(left);
        dfs(right);
    }
}
