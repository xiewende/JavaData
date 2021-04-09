package 动态规划;

import org.junit.Test;

/**
 * @create 2021-02-22  15:46
 */
public class four_one_three_等差数列划分 {


    @Test
    public void test(){
        int nums[] = {1,2,3,4,8,9,10};//
        System.out.println(numberOfArithmeticSlices1(nums));
    }


    //方法1 dp[i]表示以下标i为结尾,其前面全部的等差数列的个数
    /*
    这个方法比较麻烦，统计的是全部的个数，很多细节的东西需要处理
    状态转移方程：若新增的数符合前面的数组规则 dp[i] = dp[i-1]+(新增一个数后增多的数列个数)
                  若新增的数不符合前面的数组规则 dp[i] = dp[i-1]
    */
    public int numberOfArithmeticSlices(int[] A) {

        if(A.length == 0 || A ==null){
            return 0;
        }
        //等差值
        int dist=0;
        //差距
        int left = 0;
        int right = 2;
        //dp数组
        int dp[] = new int[A.length];

        while(right<A.length){
            dist = A[left+1]-A[left]; //差值
            if(dist == A[right] - A[left+1]){
                //dp[right] = 1+dp[right];
                //开始遍历形成dp数组
                for(int i=right;i<A.length;i++){
                    if(A[i]-A[i-1] == dist){
                        dp[i] = dp[i-1]+(i-1-left);
                    }else {
                        dp[i] = dp[i-1];
                        dp[i+1] = dp[i-1]; //赋值给后面的
                        left = i-1; //改名 left righ的值
                        right = i+1;
                        break;
                    }
                    if(i==A.length-1){
                        return dp[A.length-1]; //到达了最后一个，可以返回额
                    }
                }
            }else {
                dp[right] = dp[right-1];
            }
            left++;
            right++;
        }

        return dp[A.length-1];
    }
/*
    //经验：dp[i]选择的含义够好，问题就会变得更加简单
    //第一步：dp[i]  表示以A[i]结束的等差数列的个数
    例子
    1 2 3 4 5
    1) 1 2 3 这时dp[2] = 1 说明以3为结尾的数列个数为1 就为 【1，2，3】
    2）添加一个4后
       1 2 3 4 这时dp[3] = 2 说明以4为结尾的数列个数为2 即为【1，2，3，4】 【2，3，4】
    3）再添加一个5后
       1，2，3，4，5 这时dp[4] = 3 说明以5为结尾的数列个数为3 即为【1，2，3，4，5】【2，3，4，5】【3，4，5】
    归纳状态转移方程
    若新添加的一个数符合前面的数组规则 则dp[i] = dp[i-1]+1
    若新添加的一个数符合前面的数组规则 则不做任何处理

    //第二步：在统计dp中所有的值的和就为所求的结果
*/
    public int numberOfArithmeticSlices1(int[] A) {

        int sum = 0;
        int dp[] = new int[A.length];
        for(int i=2;i<A.length;i++){
            if(A[i]-A[i-1] == A[i-1]-A[i-2]){
                dp[i] = dp[i-1]+1;
            }
        }

        //统计最后的结果
        for(int j=0;j<dp.length;j++){
            sum += dp[j];
        }
        return sum;

    }
}
