package 滑动窗口;

import org.junit.Test;

/**
 * @author wjw
 * @date 2021/3/29 23:45
 */
public class eight_four_five_数组中的最长山脉 {

    @Test
    public void test(){
//        int[] arr = {1,2,3,4,5,4,3,2,1};
//        int[] arr = {1,2,3,3,2,1};
//        int[] arr = {2,2,2};
        int[] arr = {2,1,4,7,3,2,5};
        int res = longestMountain(arr);
        System.out.println(res);
    }

    public int longestMountain(int[] arr) {
        // 从上升开始
        int l = findNextUp(0, arr);
        int r = l + 1, len = arr.length, res = 0;
        if(l == len - 1) return 0;  // 一直都没有上升

        boolean up = true;
        while(r < len){
            while (r + 1 < len && arr[r + 1] > arr[r] && up) r++;    //找到最顶端的r
            up = false;

            int temp = r;
            while(r + 1 < len && arr[r + 1] < arr[r] && !up) r++;    //找到一个山谷
            if(r != temp) res = Math.max(res, r - l + 1);   //有变动才记录

            l = findNextUp(r, arr);
            r = l + 1;
            if(l == len - 1) return res;  // 一直都没有上升
            up = true;
        }
        return res;
    }

    public int findNextUp(int begin, int[] arr){
        while(begin + 1 < arr.length && arr[begin + 1] <= arr[begin]){
            begin++;
        }
        return begin;
    }

    //others，代码很好，思想也很好，用两个变量记录了上升和下降的个数，可以方便的表述：两个都要出现
    public int longestMountain2(int[] arr) {
        int len = arr.length;
        if(len < 3)return 0;
        int i = 1;
        int res = 0;
        while(i < len){
            int deNumber = 0;
            int enNumber = 0;
            while(i < len && arr[i - 1] < arr[i]){
                enNumber++;
                i++;
            }
            while(i < len && arr[i - 1] > arr[i]){
                deNumber++;
                i++;
            }
            if(enNumber > 0 && deNumber > 0){   //必定要有上有下
                res = Math.max(res, enNumber + deNumber + 1);
            }

            while(i < len && arr[i - 1] == arr[i]) i++;
        }

        return res;
    }
}
