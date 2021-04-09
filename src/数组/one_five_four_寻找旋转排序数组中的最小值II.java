package 数组;

import org.junit.Test;

/**
 * @author wjw
 * @date 2021/4/9 22:50
 */
public class one_five_four_寻找旋转排序数组中的最小值II {

    @Test
    public void test(){
//        int[] nums = {2,2,2,0,1};
//        int[] nums = {2,2,2,0,1,2};
//        int[] nums = {2,2,2,2,2,2};
//        int[] nums = {1,3,3};
//        int[] nums = {3,3,3,1};
//        int[] nums = {1,1,3};
        int[] nums = {2,2,2,0,0,1};

        int res = findMin(nums);
        System.out.println(res);
    }

    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1, mid;

        while (l <= r) {
            mid = l + (r - l) / 2;

            boolean lessL = true, lessR = true;
            if(mid - 1 >= l) lessL = nums[mid] < nums[mid - 1];  //跟左右相比
            if(mid + 1 <= r) lessR = nums[mid] < nums[mid + 1];
            if (lessL && lessR) return nums[mid];

            if(nums[mid] == nums[l]) l++;
            else if(nums[mid] == nums[r]) r--;
            else if(nums[mid] < nums[r]){    //右边有序
                r = mid;
            }else if (nums[mid] > nums[l]) { //左边有序
                l = mid;
            }
        }

        return nums[r];
    }

    //官方题解秒 降的节点在哪秒啊秒   暴力 + 二分
    public int findMin2(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) { //中间比右边小，说明降的节点在左边
                high = pivot;
            } else if (nums[pivot] > nums[high]) {//中间比右边大，说明降的节点在右边
                low = pivot + 1;
            } else {
                high -= 1;   //去重的一个问题，有点暴力  中间等于右边，直接右边减1
            }
        }
        return nums[low];
    }
}
