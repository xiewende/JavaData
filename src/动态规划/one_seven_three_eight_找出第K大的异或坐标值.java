package 动态规划;

import org.junit.Test;

import java.util.Arrays;

/**
 * @create 2021-05-20  0:04
 */
public class one_seven_three_eight_找出第K大的异或坐标值 {

    @Test
    public void test(){
        int mar[][] = {{5,2},{1,6}};
        int i = kthLargestValue(mar,3);
        System.out.println(i);
    }


    public int kthLargestValue(int[][] matrix, int k) {
        int length = matrix.length;
        int width = matrix[0].length;

        int dp[] = new int[length*width];
        int tem[][] = new int[length][width];
        tem[0][0] = matrix[0][0];
        int ans = 0;
        int index = 0;
        dp[index++] = tem[0][0];
        for(int i=0;i<length;i++){
            for(int j=0;j<width;j++){
                if(i==0 && j==0){
                    continue;
                }else if(i==0){
                    tem[0][j] = tem[0][j-1] ^ matrix[0][j];
                }else if(j==0){
                    tem[i][0] = tem[i-1][0] ^ matrix[i][0];
                }else{
                    tem[i][j] = tem[i-1][j] ^ tem[i][j-1] ^ tem[i-1][j-1] ^ matrix[i][j];
                }

                dp[index++] = tem[i][j];
            }
        }

        Arrays.sort(dp);

        return dp[length*width - k];

    }


}
