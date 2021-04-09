package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @create 2020-02-01  22:21  就是全排列的思想，减枝
 */
public class five_two_six_优美排列 {
    static Boolean[] used = null;
    static private int count = 0;

    public static void main(String[] args) {
        System.out.println(countArrangement(15));
    }

    public static int countArrangement(int N) {
        //生成数组
        int[] nums = new int[N];
        for (int i = 1; i <= N; i++) {
            nums[i - 1] = i;
        }

        used = new Boolean[nums.length];
        for (int i = 0; i < used.length; i++) {
            used[i] = false;
        }

        List<Integer> p = new ArrayList<>();
        generatePermutation(nums, 0, p);
        return count;
    }

    public static void generatePermutation(int[] nums, int index, List<Integer> p) {
        if (index == nums.length) {
            count++;
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {  //判断这个元素是否背访问过
                if ((p.size() + 1) % nums[i] != 0 && nums[i] % (p.size() + 1) != 0) {
                    continue;
                }
                p.add(nums[i]); //将元素添加到p中
                used[i] = true;
                generatePermutation(nums, index + 1, p);
                //很重要，一次找到结果后，要把原来标志的信息改回去
                p.remove(p.size() - 1);
                used[i] = false;
            }
        }
    }
}
