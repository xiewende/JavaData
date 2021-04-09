package 动态规划;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wjw
 * @date 2021/3/5 22:46
 */
public class nine_six_不同的二叉搜索树 {

    @Test
    public void test(){
        int re = numTrees2(5);
        System.out.println(re);
    }

    public int numTrees(int n) {
        if (n == 0) return 0;
        int[] nums = new int[(int)Math.pow(2, n)];
        Arrays.fill(nums, -1);
        boolean[] used = new boolean[n + 1];
        backtrace(n, nums, 0, used);
        return set.size();
    }

    private Set<String> set = new HashSet<>();
    public void backtrace(int n, int[] nums, int index, boolean[] used) {
        //结束条件
        if (index == n){
            set.add(Arrays.toString(nums));
            return ;
        }

        for (int i = 1; i <= n; i++) {
            if (!used[i]){
                int idx = findIdx(nums, i);
                nums[idx] = i;  //存入数组
                used[i] = true;
                backtrace(n, nums, index + 1, used);
                used[i] = false;
                nums[idx] = -1;
            }
        }
    }

    private int findIdx(int[] nums, int target){
        int i = 1;
        while (nums[i] != target || i > nums.length){
            if (nums[i] == -1) return i;
            else if (target < nums[i]) i = i * 2;
            else if (target > nums[i]) i = i * 2 + 1;
        }
        return i;
    }


    public int numTrees2(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= i; j++) {   //从1开始的根节点
                //左右节点个数
                int left = j - 1;
                int right = i - j;
                sum = sum + dp[left] * dp[right];
            }
            dp[i] = sum;
        }
        return dp[n];
    }
}
