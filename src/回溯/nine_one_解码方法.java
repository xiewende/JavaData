package 回溯;

import org.junit.Test;

/**
 * @create 2021-04-21  23:09
 */
public class nine_one_解码方法 {

    @Test
    public void test(){
        String str = "2101";
        int i = numDecodings1(str);
        System.out.println(i);
    }

    public int numDecodings(String s) {
        backtrace(s,0);
        return res;
    }
    public int res = 0;
    public void backtrace(String s,int index){
        if(index == s.length()){
            res++;
            return;
        }
        for(int i=index+1;i<=s.length();i++){
            String str = s.substring(index,i);
            if(str.startsWith("0") || str.length()>2) continue;
            int num = Integer.parseInt(str);
            if(num <=0 || num > 26) continue;
            backtrace(s,i);
        }
    }


    public int numDecodings1(String s) {
        int length = s.length();
        int dp[] = new int[length+1];
        dp[0] = 1;
        if(s.charAt(0) != '0') dp[1] = 1;
        else return 0;
        for(int i=2;i<=length;i++){

            if(s.charAt(i-1)!='0') dp[i] += dp[i-1];
            //判断优化
            if(s.charAt(i-2) == '1' || s.charAt(i-2)=='2' && s.charAt(i-1)<'7') dp[i] += dp[i-2];

            /*String str = s.substring(i-2,i);
            if(str.startsWith("0")) continue;
            int num = Integer.parseInt(str);
            if(num >0 && num < 27) dp[i] += dp[i-2];*/
        }
        return dp[length];
    }
}
