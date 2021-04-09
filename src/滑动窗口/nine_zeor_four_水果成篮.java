package 滑动窗口;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wjw
 * @date 2021/3/22 23:00
 */
public class nine_zeor_four_水果成篮 {

    @Test
    public void test(){
        int[] tree = {3,3,3,1,2,1,1,2,3,3,4};
        int res = totalFruit2(tree);
        System.out.println(res);
    }

    public int totalFruit(int[] tree) {
        int l = 0, r = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        while(r != tree.length){
            if(map.size() < 2 || map.containsKey(tree[r])){
                map.put(tree[r], map.getOrDefault(tree[r], 0) + 1);
                r++;
            }else{
                int num = map.get(tree[l]);
                if (num == 1) map.remove(tree[l]);
                else map.put(tree[l], num - 1);
                l++;
            }
            res = Math.max(res, r - l);
        }

        return res;
    }

    public int totalFruit2(int[] tree) {
        int l = 0, r = 0, n = tree.length;
        int[] nums = new int[n];
        int res = 0;
        int[] box = new int[2];

        while(r != n){
            if((box[0] != 1 || box[1] != 1) || nums[tree[r]] != 0){
                if(nums[tree[r]] == 0) box[findEmpty(box)] = 1;
                nums[tree[r]]++;
                r++;
                res = Math.max(res, r - l);
            }else{
                nums[tree[l]] = Math.max(nums[tree[l]] - 1, 0);
                if (nums[tree[l]] == 0) box[0] = 0;
                l++;
            }
        }

        return res;
    }

    //找空蓝子
    private int findEmpty(int[] box){
        return box[0] == 1 ? 1 : 0;
    }
}
