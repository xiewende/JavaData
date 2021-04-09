package 动态规划;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @create 2021-03-01  17:52
 */
public class offer_one_seven_two_three_最大黑方针 {

    @Test
    public void test(){
        int max[][] = {{0,1,1},{1,0,1},{1,1,0}};
//        int max[][] =  {
//                {0, 0, 0},
//                {0, 0, 0},
//                {1, 0, 0},
//
//        };

//        int max[][] =  {
//                {1, 1, 1, 0, 1, 1, 0, 1, 0, 0},
//                {0, 1, 0, 1, 1, 0, 0, 0, 1, 1},
//                {0, 0, 1, 1, 0, 0, 1, 1, 1, 0},
//                {0, 1, 1, 1, 0, 1, 0, 0, 1, 0},
//                {1, 1, 0, 1, 1, 0, 1, 0, 0, 1},
//                {0, 1, 1, 0, 0, 0, 0, 1, 1, 0},
//                {1, 0, 0, 0, 0, 1, 1, 1, 1, 1},
//                {1, 0, 1, 0, 1, 0, 0, 0, 1, 0},
//                {1, 1, 1, 1, 0, 1, 0, 1, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0}
//        };
     // int max[][] = {{1,0,1},{0,0,1},{0,0,1}};
        //int max[][] = {{1}};
        int re[] = findSquare1(max);
        System.out.println(Arrays.toString(re));
    }


    //思路有点问题的
    public int[] findSquare(int[][] matrix) {

        int len1 = matrix.length;
        int len2 = matrix[0].length;

        if(len1 == 0 || matrix == null){
            return new int[0];
        }
        if(len1 == 1 && len2==1 && matrix[0][0] == 1){

            return new int[0];
        }
        int ans[] = new int[3];
        int size = 0;//边长
        //建立dp数组
        int dp[][] = new int[len1][len2];

        //第一列的值
        for (int i = 0; i < len1;i++)
        {
            if(matrix[i][0] == 1){
                dp[i][0] = 0;
            }else{
                dp[i][0] = 1;
                size = 1;
                if(ans[2] == 0){
                    ans[0] = i;
                    ans[1] = 0;
                    ans[2] = size;

                }
            }
        }
        //第一行的值
        for (int j = 0; j <len2; j++)
        {
            if(matrix[0][j] == 1){
                dp[0][j] = 0;
            }else{
                dp[0][j] = 1;
                size = 1;
                if(ans[2] == 0){
                    ans[0] = 0;
                    ans[1] = j;
                    ans[2] = size;

                }
            }
        }

        //开始遍历
        for (int i = 1; i < len1;i++)
        {
            for (int j = 1; j < matrix[i].length; j++)
            {
                if(i==1 || j==1){
                    if(dp[i-1][j-1]>0 && dp[i-1][j]>0 && dp[i][j-1]>0 && matrix[i][j]==0){ //上下
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }else if(matrix[i][j]==0){
                        dp[i][j] = 1;
                    }
                }else {
                    if(dp[i-1][j-1]>1 && dp[i-1][j]>1 && dp[i][j-1]>1 && matrix[i][j]==0){ //上下
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }else if(matrix[i][j]==0 && dp[i-1][j]==1 && dp[i][j-1] == 1 && dp[i-1][j-1]>=1 ){
                        dp[i][j] = 2;
                    }else {
                        dp[i][j] = 1;
                    }

                }

                //判断结果即可
                if(dp[i][j] > size){
                    size = dp[i][j];
                    ans[0] = i - size + 1;
                    ans[1] = j - size + 1;
                    ans[2] = dp[i][j];

                }else if(dp[i][j] == size){
                    int row = i - size + 1;
                    int col = j - size + 1;
                    if(row<ans[0]){
                        ans[0] = row;
                        ans[1] = col;
                    }else if(row == ans[0]){
                        if(col<ans[1]){
                            ans[0] = row;
                            ans[1] = col;
                        }
                    }

                }

            }
        }
        return ans;
    }

    //另外的思路
    /*
    第一步：求两个矩阵的值
    maxRow[i][j]:表示i，j位置往右方向0的个数，包括本身，也就是有效位
    maxCol[i][j]:表示i，j位置往下方向0的个数，包括本身，也就是有效位
    第二步：
    1）遍历 matrix 每个位置
    2）在位置 matrix[i][j]时
                            查看这个往右和往下为0的个数，取往下和往右的最小值 即是 min = in{maxRow[i][j],maxCol[i][j]}
                            若 min = 0；直接跳过这个位置，否则执行3）。
    3）根据min的值，
                    找到方阵的右上角的位置，在看这个右上角的位置往下的有效位置是否大于min
                    找到方阵的左下角的位置，在看这个左上角的位置往右的有效位置是否大于min
                    若上面两个位置的有效位都大于min，则保存这个答案
                    若上面两个位置有一个不满足，就说明这个方阵不是黑方阵，则缩小min的值（min--）继续步骤3）
    */
    public int[] findSquare1(int[][] matrix) {
        int len1 = matrix.length;
        int len2 = matrix[0].length;

        if(len1 == 0 || matrix == null){
            return new int[0];
        }
        if(len1 == 1 && len2==1 && matrix[0][0] == 1){
            return new int[0];
        }

        //创造结果集
        int ans[] = new int[3];

        // 长度内的值有效
        int maxRow[][] = new int[len1+1][len2+1]; //各个位置向右最长的黑点
        int maxCol[][] = new int[len1+1][len2+1]; //各个位置向下的最长黑点

        //从后往前比较好记忆，
        for(int i=len1-1 ; i>=0 ;i--){
            for(int j=len2-1 ; j>=0 ; j--){
                if(matrix[i][j] == 0){
                    maxRow[i][j] = maxRow[i][j+1] + 1;
                    maxCol[i][j] = maxCol[i+1][j] + 1;
                }
            }
        }

        for(int i=0;i<len1;i++){
            for(int j = 0;j<len2;j++){
                int min = Math.min(maxRow[i][j],maxCol[i][j]);

                //若min==0，直接跳过这个位置
                if(min == 0){
                    continue;
                }
                //[i][j]  左上角
                int nextCol = j+min-1; //右上角
                int nextRow = i+min-1; //左下角

                //随着min的变小，判断是否满足黑方阵
                while(min>0){
                    //判断是否满足黑方阵，若满足立即直接退出，即为最大
                    if(maxCol[i][nextCol]>=min && maxRow[nextRow][j]>=min){
                        break;
                    }
                    //不满足，缩小min，也就是缩小方阵大小
                    nextCol--;
                    nextRow--;
                    min--;
                }

                //拿到一个更大的了,封装答案，按照规定一步一步封装
                if(min>ans[2]){
                    ans[0] = i;
                    ans[1] = j;
                    ans[2] = min;
                }else if(min == ans[2]){
                    if(i<ans[0]){
                        ans[0] = i;
                        ans[1] = j;
                    }else if(i==ans[0]){
                        ans[1] = j<ans[1]?j:ans[1];
                    }
                }
            }
        }
        return ans;
    }

}
