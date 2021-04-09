package 分治算法;

import javafx.beans.binding.NumberBinding;
import org.junit.Test;

import java.util.Arrays;

/**
 * @create 2021-02-28  17:17
 */
public class two_one_five_数组中的第K个最大元素 {

    @Test
    public void test(){
        int[] nums = {-1,-1};
        int k=2;
        System.out.println(findKthLargest(nums,k));
    }


    public int findKthLargest(int[] nums, int k) {
/*        Arrays.sort(nums);
        int index = nums.length-1;
        if(k==1){
            return nums[index];
        }
        index--;
        int number = 1;
        while(index>=0){
            number++;
            if(number == k){
                return nums[index];
            }
            index--;
        }
        return 0;
    }*/

        Arrays.sort(nums);
        int index = nums.length-1;
        int number = 0;
        while(index>=0){
            number++;
            if(number == k){
                return nums[index];
            }
            index--;
        }
        return 0;
    }
}
