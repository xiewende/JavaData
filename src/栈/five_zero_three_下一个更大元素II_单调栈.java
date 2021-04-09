package 栈;

import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wjw
 * @date 2021/3/6 22:36
 */
public class five_zero_three_下一个更大元素II_单调栈 {

    @Test
    public void test(){
        int[] nums = {5,4,3,2,1};
        int[] res = nextGreaterElements(nums);
        System.out.println(Arrays.toString(res));
    }

    //暴力
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] nums2 = new int[n * 2];
        int j = 0;
        for(int i = 0; i < n * 2; i++){
            nums2[i] = nums[j++];
            if(j == n) j = 0;
        }

        for(int i = 0; i < n; i++){
            int k = 0;
            for(k = i + 1; k < 2 * n; k++){
                if(nums[i] < nums2[k]){
                    res[i] = nums2[k];
                    break;
                }
            }
            if(k == 2 * n) res[i] = -1;
        }

        return res;
    }

    //单调递减栈
    public int[] nextGreaterElements2(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        //循环队列，判断是否为第二次
        boolean isSecond = false;

        Deque<Integer> stack = new LinkedList<>();
        stack.offerLast(0);
        for (int i = 1; i < n; i++) {
            //将比新来的那个小的全部出栈，把出栈的值对应的位置改为这个下一个更大的值
            while (!stack.isEmpty() && nums[i] > nums[stack.peekLast()]){
                int idx = stack.pollLast();
                if (res[idx] == -1) res[idx] = nums[i];
            }
            //每个新来的值都入栈
            stack.offerLast(i);
            //判断第二次
            if(i == n - 1){
                if (isSecond) break;
                i = -1;
                isSecond = true;
            }
        }
        return res;
    }
}
