package 数组;

import org.junit.Test;

/**
 * @author wjw
 * @date 2021/4/8 22:37
 */
public class one_five_eight_寻找旋转排序数组中的最小值 {

    @Test
    public void test(){
        int[] nums = {1};
//        int[] nums = {2, 11};
//        int[] nums = {0,1,2,4,5,6,7};
//        int[] nums = {7,0,1,2,4,5,6};
//        int[] nums = {6,7,0,1,2,4,5};
//        int[] nums = {5,6,7,0,1,2,4};
//        int[] nums = {4,5,6,7,0,1,2};
//        int[] nums = {2,4,5,6,7,0,1};
//        int[] nums = {1,2,4,5,6,7,0};

        int res = findMin(nums);
        System.out.println(res);
    }

    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1, mid;

        while(l <= r){
            mid = l + (r - l) / 2;
            boolean lessL = true, lessR = true;
            if(mid - 1 >= 0) lessL = nums[mid] < nums[mid - 1];             // 左边有就要比左边小
            if(mid + 1 < nums.length) lessR = nums[mid] < nums[mid + 1];    // 右边有就要比右边小
            if(lessL && lessR) return nums[mid];                            // 比两边都要小就说明是最小值

            if(nums[r] > nums[mid]){    //右边有序，那就说明最小的在左边
                r = mid - 1;
            }else{                      //左边有序，那就说明最小的在右边
                l = mid + 1;
            }
        }
        return nums[l];
    }
}
