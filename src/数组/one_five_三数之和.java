package 数组;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @create 2021-01-09  11:52
 */
public class one_five_三数之和 {

    @Test
    public void test(){
        int nums[] = {-1,0,1,2,-1,-4}; // -4 -1 -1 0 1 2
        threeSum(nums);
        System.out.println(res.toString());
    }

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        for(int i = 0 ; i<nums.length;i++){
            int j = i+1;
            int k = nums.length-1;

            while (j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    List<Integer> tem = new ArrayList<>();
                    tem.add(nums[i]);
                    tem.add(nums[j]);
                    tem.add(nums[k]);

                    if(!res.contains(tem)){
                        res.add(tem);
                    }
                    k--;
                    j++;
                }else if(sum>0){
                    k--;
                }else {
                    j++;
                }
            }
        }
        return res;
    }

}
