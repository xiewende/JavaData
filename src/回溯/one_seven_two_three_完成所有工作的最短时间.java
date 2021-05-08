package 回溯;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author wjw
 * @date 2021/5/8 23:36
 */
public class one_seven_two_three_完成所有工作的最短时间 {

    @Test
    public void test(){
        int[] jobs = {5,5,4,4,4};
        int k = 2;
        int re = minimumTimeRequired(jobs, k);
        System.out.println(re);
    }

    // 二分+试探，每次试探需要通过回溯判断能否成功
    // 优化：从后往前可以减少栈帧深度
    public int minimumTimeRequired(int[] jobs, int k) {
        Arrays.sort(jobs);
        int l = jobs[jobs.length - 1], r = Arrays.stream(jobs).sum();
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(jobs, k, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean check(int[] jobs, int k, int limit) {
        int[] workloads = new int[k];
        return backtrack(jobs, workloads, jobs.length - 1, limit);
    }

    public boolean backtrack(int[] jobs, int[] workloads, int i, int limit) {
        if (i < 0) {
            return true;
        }
        int cur = jobs[i];
        for (int j = 0; j < workloads.length; ++j) {
            if (workloads[j] + cur <= limit) {
                workloads[j] += cur;
                if (backtrack(jobs, workloads, i - 1, limit)) {
                    return true;
                }
                workloads[j] -= cur;
            }
            // 如果当前工人未被分配工作，那么下一个工人也必然未被分配工作
            // 或者当前工作恰能使该工人的工作量达到了上限
            // 这两种情况下我们无需尝试继续分配工作
            if (workloads[j] == 0 || workloads[j] + cur == limit) {
                break;
            }
        }
        return false;
    }
}
