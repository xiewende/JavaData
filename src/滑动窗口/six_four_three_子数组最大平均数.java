package 滑动窗口;

import org.junit.Test;

/**
 * @create 2021-02-04  22:25
 */
public class six_four_three_子数组最大平均数 {

    @Test
    public void test(){
        int nums[] = {1,12,-5,-6,50,3};
        int k = 5;
        double maxAverage = findMaxAverage(nums, k);
        System.out.println(maxAverage);
    }

    //滑动窗口
    public double findMaxAverage(int[] nums, int k) {
        //区间k中的下标 left:区间第一个下标 right:区间后面第一个下标
        int left = 0;
        int right = k;
        //区间最大的和
        int maxSum = 0;
        //每个区间的和
        int qujianSum = 0;
        for(int i=0;i<k;i++){
            qujianSum += nums[i];
        }
        maxSum = qujianSum;
        while(right<nums.length){
            //区间和
            qujianSum = qujianSum +nums[right]-nums[left];
            //取最大
            maxSum = Math.max(maxSum,qujianSum);
            left++;
            right++;
        }
        return maxSum*1.0/k;
    }




}
