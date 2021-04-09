package 动态规划;

import org.junit.Test;

/**
 * @create 2021-03-18  23:48
 */
public class one_one_zero_five_填充书架 {

    @Test
    public void test(){
        int books[][] = {{1,1},{2,3},{2,3},{1,1},{1,1},{1,1},{1,2}};
        int shelf_width = 4;
        int i = minHeightShelves(books, shelf_width);
        System.out.println(i);
    }

    public int minHeightShelves(int[][] books, int shelf_width) {
        int row = books.length;
        int dp[] = new int[row+1];  //到第i本书为止得最小高度
        dp[0] = 0;

        int leave_Wid =  0;
        int index = 0;
        for(int i=1;i<=row;i++){
            //判断能不同一行
            if(books[i-1][1] > leave_Wid){
                dp[i] = dp[i-1]+books[i-1][1];
                leave_Wid = shelf_width - books[i-1][0]; //剩余宽度
                index = i-1;
            }else {
                //同一行
                dp[i] = Math.max(dp[i-1],books[i-1][1]+dp[index]);
                leave_Wid = leave_Wid - books[i-1][0];
            }
        }

        return dp[row];
    }
}
