package 栈;

import org.junit.Test;

import java.util.Stack;

/**
 * @create 2021-03-26  18:46
 */
public class four_zero_two_移掉K位数字 {

    @Test
    public void test(){
        String num = "10";
        int k = 1;
        System.out.println(removeKdigits(num,k));
    }

    public String removeKdigits(String num, int k) {



        int ansLen = num.length() -  k;

        if(ansLen <= 0){
            return "0";
        }

        char first = num.charAt(0);

        int i;
        for(i=1;i<num.length() - ansLen+1;i++){
            if(num.charAt(i)-'0' < first-'0'){
                first = num.charAt(i);
            }
        }

        String end = num.substring(i,num.length());
        String res = "";
        if(first=='0'){
            res = end.length() == 0 ? "0":end;
        }else {
            res = String.valueOf(first) + end;
        }
        return res;

    }
}
