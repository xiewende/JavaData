package 回溯;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @create 2019-11-18  21:49
 */
public class seven_seven_组合 {

    @Test
    public void test(){
        int n=4;
        int k = 2;
        combine(n,k);
        System.out.println("en");
    }

    public List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || n < k) {
            return null;
        }
        List<Integer> re = new ArrayList<>();
        cpnbit(n, k, 1, re);
        return result;
    }

    public void cpnbit(int n, int k, int start, List<Integer> re) {

        //Start就是n中开始的数字
        if (re.size() == k) {
            result.add(new ArrayList<>(re));
            return;
        }
        //进行递归
        for (int i = start; i <= n; i++) {  // 优化 n = n-(k-c.size())+1
            re.add(i);
            cpnbit(n, k, i + 1, re);
            re.remove(re.size() - 1);
        }

    }


}
