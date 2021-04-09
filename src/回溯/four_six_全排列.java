package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @create 2019-10-17  22:17
 */
public class four_six_全排列 {


    private static Boolean[] used = null;

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> list = permute(nums);
        System.out.println(list.toString());

    }

    public static void generatePermutation(int[] nums, int index, List<Integer> p, List<List<Integer>> result) {

        //index代表的递归了几次，
        if (index == nums.length) {
           /* if (!result.contains(p)) {
                result.add(new ArrayList<>(p));
            }*/
            result.add(new ArrayList<>(p));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {  //判断这个元素是否背访问过
                p.add(nums[i]); //将元素添加到p中
                used[i] = true;
                generatePermutation(nums, index + 1, p, result);
                //很重要，一次找到结果后，要把原来标志的信息改回去
               /* int j = p.lastIndexOf(i);
                p.remove(j);*/
                p.remove(p.size() - 1);
                used[i] = false;
            }
        }
    }

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        result.clear();
        if (nums.length == 0) {
            return result;
        }


        used = new Boolean[nums.length];
        for (int i = 0; i < used.length; i++) {
            used[i] = false;
        }

        List<Integer> p = new ArrayList<>();
        generatePermutation(nums, 0, p, result);

        return result;

    }

}
