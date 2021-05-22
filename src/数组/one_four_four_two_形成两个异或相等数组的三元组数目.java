package 数组;

import org.junit.Test;

/**
 * @create 2021-05-19  0:01
 */
public class one_four_four_two_形成两个异或相等数组的三元组数目 {

    @Test
    public void test(){
        int arr[] = {1,3,5,7,9};
        int i = countTriplets(arr);
        System.out.println(i);
    }

    public int countTriplets(int[] arr) {

        int len = arr.length;
        int a = 0;
        int b = 0;
        int ans = 0;
        for(int i=0;i<len;i++){
            a = 0;
            for(int j=i+1;j<len;j++){
                b = 0;
                a = a ^ arr[j-1];
                for(int k=j;k<len;k++){
                    b = b ^ arr[k];
                    if(a == b) ans++;
                }
            }
        }
        return ans;
    }

    //降重
    /**
     * a ^ b = a[i]^...^a[k] = 0, 题目转化为求子串的异或结果等于0
     */
    public static int countTriplets1(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int t = arr[i];
            for (int k = i + 1; k < arr.length; k++) {
                t ^= arr[k];
                if (t == 0) {
                    // j 无所谓呐，i~k任意一个数都行
                    res += k - i;
                }
            }
        }
        return res;
    }
}
