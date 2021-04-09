package 滑动窗口;

import org.junit.Test;

/**
 * @create 2021-03-27  23:10
 */
public class eight_five_four_数组中的最长山脉 {

    @Test
    public void test(){
        int arr[] = {1,2,3,4,4,1};
        int i = longestMountain(arr);
        System.out.println(i);
    }

    public int longestMountain(int[] arr) {
        int len = arr.length;
        int res = 0;
        int upOrdown = 0;
        int left = 0;

        while(left+1 < len && arr[left]>=arr[left+1]){
            left++;
        }
        int right = left;
        while(right<len-1){
            //先判断是否曾
            if(upOrdown == 0){
                if(arr[right+1]<arr[right]){
                    upOrdown = 1;
                }else if(arr[right+1]==arr[right]){
                    left = right;
                }
            }else{
                if(arr[right+1]>=arr[right]){
                    //res = Math.max(res,right-left+1);
                    left = right;
                    upOrdown = 0;
                }
            }
            right++;
            if(upOrdown == 1){
                res = Math.max(res,right-left+1);
            }
        }
        return res;
    }
}
