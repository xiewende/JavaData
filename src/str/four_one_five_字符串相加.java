package str;

import org.junit.Test;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @create 2021-03-09  17:40
 */
public class four_one_five_字符串相加 {

    @Test
    public void test(){
//        String num1 = "98";
//        String num2 = "9";
//        System.out.println(addStrings(num1,num2));
        char str[] = {'1','2','3'};
        System.out.println(String.valueOf(str));
        char str1[] = new char[3];
        int tem = 1;
        for(int i=0;i<str1.length;i++){
            str1[i] = (char)tem;
        }
        System.out.println(String.valueOf(str1));
        System.out.println(Arrays.toString(str1));
    }
    public String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int max = len1>len2?len1:len2;
        int ans[] = new int[max+1];

        int jinwei = 0;
        int index1 = len1-1;
        int index2 = len2-1;

        while(max>=0){
            int numFirst = index1>=0?num1.charAt(index1)-'0':0;
            int numSecond =index2>=0? num2.charAt(index2)-'0':0;
            int temSum = jinwei + numFirst +numSecond ;

            if(temSum>=10){
                jinwei = 1;
            }else {
                jinwei = 0;
            }
            //char tem = temSum + '0';
            ans[max--] = temSum % 10;
            index1--;
            index2--;
        }


        String ans1 = "";
        for(int i=0 ;i<ans.length;i++){
            if(i==0 && ans[i]==0){
                continue;
            }
            ans1 += String.valueOf(ans[i]);
        }
        return ans1;

//        int tem1 = Integer.valueOf(num1);
//        int tem2 = Integer.valueOf(num2);
//        return String.valueOf(tem1+tem2);
//        BigInteger a = new BigInteger(num1);
//        BigInteger b = new BigInteger(num2);
//        return   a.add(b).toString();

    }
}
