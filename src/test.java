import org.junit.Test;

import java.io.FileFilter;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @create 2021-03-05  22:45
 */

public class test {

    @Test
    public void test(){

        int nums[] = {-2,1,2,-2,1,2};
        System.out.println(find132pattern(nums));
    }

    //方法1  暴力
    public boolean find132pattern(int[] nums) {

        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(nums[i]<nums[j] && nums[j]>nums[k] && nums[i]<nums[k]){
                        return true;
                    }
                }
            }
        }
        return false;

    }

    //方法2  貌似不可以
    public boolean find132pattern1(int[] nums) {

        dfs(nums,0,nums.length-1);
        return tag;
    }

    public boolean tag;
    public void dfs(int[] nums,int begin,int end){

        if(end-begin == 1){
            tag =  false;
            return;
        }

        int max = nums[begin];
        for(int i=begin;i<=end;i++){
            max = nums[i]>max ? nums[i]:max;
        }
        int index=0;
        for(int i=begin;i<=end;i++){
            if(max == nums[i]){
                index = i;
                break;
            }
        }
        if(index == begin){
             dfs(nums,begin+1,end);
        }else if(index==end){
             dfs(nums,begin,end-1);
        } else {
            tag =  true;
        }

    }

}
