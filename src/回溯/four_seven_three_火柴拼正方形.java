package 回溯;

import org.junit.Test;

import java.security.spec.ECGenParameterSpec;
import java.util.Arrays;

/**
 * @create 2021-03-16  23:51
 */
public class four_seven_three_火柴拼正方形 {

    @Test
    public void test(){

        int nums[] = {3,3,3,3,4};
        System.out.println(makesquare(nums));
    }

    public boolean makesquare(int[] nums) {
        if(nums == null || nums.length == 0){
            return false;
        }
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if(sum % 4 != 0) return false;
        int edgeLen = sum / 4;
        int edge[] = new int[4];
        return dfs(nums,nums.length-1,edge,edgeLen);
    }

    public boolean dfs(int[] nums,int index,int edge[],int edgeLen){
        if(index == 0){
            if(edge[0]==edge[1] && edge[1]==edge[2] &&edge[3]==edge[2] ) return true;
            return false;
        }
        for(int i=0;i<4;i++){
            if(edge[i] + nums[index]>edgeLen || (i>0&&edge[i]==edge[i-1]) ){
                continue;
            }
            //加入边
            edge[i] += nums[index];
            if(dfs(nums,index-1,edge,edgeLen)) return true;
            edge[i] -= nums[index];
        }
        return false;
    }
}
