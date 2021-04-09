package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @create 2019-11-29  17:59
 */
public class seven_eight_子集 {
    public static void main(String[] args) {
        seven_eight_子集 res = new seven_eight_子集();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = res.subsets(nums);
        for (List<Integer> a : result) {
            System.out.println(a.toString());
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> rs = new ArrayList<>();
        rs.add(list);
        dfs(nums, list, rs, 0);
        return rs;
    }

    public void dfs(int[] nums, List<Integer> list, List<List<Integer>> rs, int start) {
        rs.add(new ArrayList(list));
        /*if(list.size() > 0)
        {
            rs.add(new ArrayList(list));
            if(list.get(list.size()-1) == nums[nums.length-1])
            {
                return;
            }
        }*/

        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, list, rs, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
