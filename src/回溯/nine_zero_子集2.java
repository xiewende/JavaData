package 回溯;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @create 2021-03-15  17:52
 */
public class nine_zero_子集2 {

    @Test
    public void test(){
        int nums[] = {1,2,2};
        List<List<Integer>> lists = subsetsWithDup(nums);
        System.out.println(lists.toString());
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> tem = new ArrayList<>();
        backTrace(nums,tem,0,0);
        return res;
    }
    List<List<Integer>> res = new ArrayList<>();
    public void backTrace(int[] nums,List<Integer> tem,int length,int index){

        //接入结果集,由于是子集直接加
        res.add(new ArrayList<>(tem));
        //返回，遍历到了最后
        if(length==nums.length){
            return;
        }
        for(int i=index;i<nums.length;i++){
            //这边去重很重要 i>index 细细品味
            if(i>index && nums[i]==nums[i-1]){
                continue;
            }
            tem.add(nums[i]);
            backTrace(nums,tem,length+1,i+1);
            tem.remove(tem.size()-1);
        }
    }
}
