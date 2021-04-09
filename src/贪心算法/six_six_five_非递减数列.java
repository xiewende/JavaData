package 贪心算法;

import org.junit.Test;

/**
 * @author xwd
 * @date 2021/2/7 21:54
 */
public class six_six_five_非递减数列 {

    @Test
    public void test(){

        int nums[] = {5,7,1,8};
        boolean b = checkPossibility(nums);
        System.out.println(b);

    }

    //判断是否是否可以改变一个的值使之成为递增数列
    //1 2 2 3 4 6 3 5 5 6 7 9
    /*
    分析：
    遇到递减：两种选择，要么改前面，要么改后面。
    贪心选择：优先选择前面的进行修改，若修改后面的会影响后面的判断，贪心选择前者改变
    但是有的时候必须修改后面的，以至于不可以修改前面的，下面给出例子

    1 3 2：遍历的时候遇到 3 2 递减了，此时是修改前面还是后面的？经发现num[i+1]>num[i-1]
    此时二者都可以改变，根据贪心算法，选择前者进行改变即可
    2 3 1：遍历的时候遇到 3 2 递减了，此时是修改前面还是后面的？经发现num[i+1]<num[i-1]
    此时只可以改变后者的值了，只能将 1 变为 3，就成为递增数列了。
    */

    public boolean checkPossibility(int[] nums) {
        int len = nums.length;
        int[] nums2 = new int[len + 2];
        System.arraycopy(nums, 0, nums2, 1, len);
        nums2[0] = Integer.MIN_VALUE; nums2[len + 1] = Integer.MAX_VALUE;

        boolean flag = false;

        for(int i = 1;i < nums2.length-1;i++){

            if(nums2[i] > nums2[i+1]){
                //比较i-1和i+1两个端点
                if(nums2[i + 1] < nums2[i - 1]){
                    nums2[i + 1] = nums2[i];
                }else{
                    nums2[i] = nums2[i + 1];
                }

                //判断第二次
                if(flag){
                    return false;
                }
                flag = true;

            }
        }
        return true;
    }
}
