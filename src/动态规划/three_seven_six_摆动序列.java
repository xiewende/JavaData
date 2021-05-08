package 动态规划;

import org.junit.Test;

import java.util.Arrays;

/**
 * @date 2021/5/6 23:41
 */
public class three_seven_six_摆动序列 {

    @Test
    public void test(){
        int[] nums = {0,0};
        int res = wiggleMaxLength3(nums);
        System.out.println(res);
    }

    // O(n²)
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int[] in = new int[n + 1];
        int[] de = new int[n + 1];

        Arrays.fill(in, 1);
        Arrays.fill(de, 1);

        for(int i = 2; i <= n; i++){
            for(int j = i - 2; j >= 0; j--){
                //填in，往前找比它小的
                if(nums[i - 1] > nums[j]) in[i] = Math.max(in[i], de[j + 1] + 1);
                //填de，往前找比它大的
                if(nums[i - 1] < nums[j]) de[i] = Math.max(de[i], in[j + 1] + 1);
            }
        }

        return Math.max(in[n], de[n]);
    }

    // O(n)优化  最大的一直累加过来，只需要跟前一个比较
    public int wiggleMaxLength2(int[] nums) {
        int n = nums.length;
        int[] in = new int[n + 1];
        int[] de = new int[n + 1];

        in[1] = 1;
        de[1] = 1;

        for(int i = 2; i <= n; i++){
            if(nums[i - 1] > nums[i - 2]) {
                in[i] = de[i - 1] + 1;
                de[i] = de[i - 1];
            }
            else if(nums[i - 1] < nums[i - 2]) {
                in[i] = in[i - 1];
                de[i] = in[i - 1] + 1;
            }
            else{
                in[i] = in[i - 1];
                de[i] = de[i - 1];
            }
        }

        return Math.max(in[n], de[n]);
    }

    // 空间优化  只需要跟前一个比较，所以一个变量即可，不需要数组
    public int wiggleMaxLength3(int[] nums) {
        int n = nums.length;
        int in = 1;
        int de = 1;

        for(int i = 2; i <= n; i++){
            if(nums[i - 1] > nums[i - 2]) {
                in = de + 1;
            }
            else if(nums[i - 1] < nums[i - 2]) {
                de = in + 1;
            }
        }

        return Math.max(in, de);
    }
}
