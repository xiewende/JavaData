package 数组;

import org.junit.Test;

/**
 * @create 2021-04-07  23:15
 */

public class eight_one_搜索旋转排序数组2 {

    @Test
    public void test(){
        int nums[] = {1,1,1,1,1,1,1,1,1,13,1,1,1,1,1,1,1,1,1,1,1,1}; //[]
        int target = 13;
        boolean re = search(nums, target);
        System.out.println(re);
    }
    public boolean search(int[] nums, int target) {
        int l=0;
        int r = nums.length-1;
        int mid;
        while(l<=r){
            mid = l + (r-l) / 2;
            if(nums[mid] == target) return true;
            if(nums[mid] > nums[l]){
                if(nums[mid] > target && target>=nums[l]){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }

            }else if(nums[mid] < nums[r]){
               if(nums[mid] < target && target <= nums[r]){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }else{
                //nums[l] nums[r]相等，左右缩进区间
                if(target == nums[l])return true;
                else l++;
                if(target == nums[r])return true;
                else r--;
            }

            // 全部为同一个值得时候，特例
            if(r == mid && l == mid) return false;
        }
        return false;
    }
}
