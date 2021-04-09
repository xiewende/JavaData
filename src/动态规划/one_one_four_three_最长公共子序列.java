package 动态规划;

import org.junit.Test;

/**
 * @create 2021-02-20  15:22
 */
public class one_one_four_three_最长公共子序列 {

    @Test
    public void test(){
        String text1 = "abc";
        String text2 =  "abc";
        System.out.println(longestCommonSubsequence(text1,text2));
    }


    //方法1 采取动态规划的方法
    /*
    dp[i][j] 表示字符串text1以i 字符串text2以j为下标 的最长公共子序列的长度

    状态转移方程为  若text1[i] = text2[j]    dp[i][j] = dp[i-1][j-1]+1;
                    否之                     dp[i][j] = Max(dp[i-1][j],dp[i][j-1])
    */
    public int longestCommonSubsequence(String text1, String text2) {
        //结果长度
        int maxLen = 0;
        //建立dp数组
        int dp[][] = new int[text1.length()][text2.length()];
        //初始化
        boolean tag = false;
        for(int i=0;i<text1.length();i++){
            if(text1.charAt(i)==text2.charAt(0) || tag==true){
                dp[i][0] = 1;
                tag = true;
            }else {
                dp[i][0] = 0;
            }
            maxLen = Math.max(maxLen,dp[i][0]);
        }

        boolean tag1 = false;
        for(int j=0;j<text2.length();j++){
            if(text2.charAt(j)==text1.charAt(0) || tag1==true){
                dp[0][j] = 1;
                tag1 = true;
            }else {
                dp[0][j] = 0;
            }
            maxLen = Math.max(maxLen,dp[0][j]);
        }

        //遍历
        for(int i=1 ; i<text1.length();i++){
            for(int j= 1 ;j<text2.length();j++){
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
                maxLen = Math.max(maxLen,dp[i][j]);
            }
        }

        //查找最大的

       // return maxLen;
        return dp[text1.length()-1][text2.length()-1];
    }

    //优化1：加空格，免去不必要的初始化过程
    public int longestCommonSubsequence1(String text1, String text2) {

        //加空格的很绝，避免了越界的相关事项
        text1 = " "+text1;
        text2 = " "+text2;
        //结果长度
        int maxLen = 0;
        //建立dp数组
        int dp[][] = new int[text1.length()][text2.length()];
        //遍历
        for(int i=1 ; i<text1.length();i++){
            for(int j= 1 ;j<text2.length();j++){
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
                maxLen = Math.max(maxLen,dp[i][j]);
            }
        }

        //查找最大的

        return maxLen;
    }



    //方法2 递归
    public int longestCommonSubsequence2(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        //加空格的很绝，避免了越界的相关事项
        text1 = " "+text1;
        text2 = " "+text2;
        return fun(len1,len2,text1,text2);
    }

    public int fun(int i,int j,String test1,String test2){
        int ans;
        if(i==0 || j==0){
            ans = 0;
        }else {
            if(test1.charAt(i)==test2.charAt(j)){
                ans = fun(i-1,j-1,test1,test2)+1;
            }else {
                ans = Math.max(fun(i-1,j,test1,test2),fun(i,j-1,test1,test2));
            }
        }
        return ans;
    }

    //方法2 递归+记忆化
    public int longestCommonSubsequence3(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        //加空格的很绝，避免了越界的相关事项
        text1 = " "+text1;
        text2 = " "+text2;

        //记忆数组
        int reme[][] = new int[text1.length()][text2.length()];
        for(int i=0;i<text1.length();i++){
            for(int j=0;j<text2.length();j++){
                reme[i][j] = -1;
            }
        }

        return fun1(len1,len2,text1,text2,reme);
    }

    public int fun1(int i,int j,String test1,String test2,int reme[][]){
        if(reme[i][j]!=-1){
            return reme[i][j];
        }
        int ans;
        if(i==0 || j==0){
            ans = 0;
        }else {
            if(test1.charAt(i)==test2.charAt(j)){
                ans = fun1(i-1,j-1,test1,test2,reme)+1;
            }else {
                ans = Math.max(fun1(i-1,j,test1,test2,reme),fun1(i,j-1,test1,test2,reme));
            }
        }
        reme[i][j] = ans;
        return ans;
    }


}
