package 数组;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author wjw
 * @date 2021/4/17 23:22
 */
public class two_two_zero_存在重复元素III {

    @Test
    public void test(){
        int[] nums = {1,2,3,1};
        int k = 3;
        int t = 0;
        boolean res = containsNearbyAlmostDuplicate2(nums, k, t);
        System.out.println(res);
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++){
            int idx;
            if(list.size() <= k){
                idx = findIndex(list, nums[i]);
                list.add(idx, nums[i]);
            }else { // list里面已有k个，达到了长度，需要先去除
                idx = findIndex(list, nums[i - k - 1]);
                list.remove(idx);
                idx = findIndex(list, nums[i]);
                list.add(idx, nums[i]);
            }
            //判断两边
            if (idx - 1 >= 0 && ((long)list.get(idx) - (long)list.get(idx - 1) <= t)) return true;
            if (idx + 1 < list.size() && ((long)list.get(idx + 1) - (long)list.get(idx) <= t)) return true;
        }
        return false;
    }

    private int findIndex(List<Integer> nums, int target){
        int l = 0, r = nums.size() - 1, mid;
        while(l <= r){
            mid = l + (r - l) / 2;
            if(target == nums.get(mid)) return mid;
            else if(target > nums.get(mid)) l = mid + 1;
            else if(target < nums.get(mid)) r = mid - 1;
        }
        return l;
    }

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<Long>();
        for (int i = 0; i < n; i++) {
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

}
