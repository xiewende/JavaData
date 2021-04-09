package 分治算法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @create 2020-03-01  17:25
 */
public class tow_four_one {

    @Test
    public void test() {
        String str = "234*52";
        List<Integer> list = diffWaysToCompute2(str);
        System.out.println(list.toString());
    }

    public static void main(String[] args) {
        List<Integer> list = diffWaysToCompute2("2*3-4*5");
        System.out.println(list.toString());
    }


    //不要被思维限制了，
    public List<Integer> diffWaysToCompute(String input) {
        if (input.length() == 0 || input == "") {
            return new ArrayList<>();
        }
        int num[] = Arrays.asList(input.split("\\D")).stream().mapToInt(Integer::parseInt).toArray();
        String[] op = input.split("\\d+");

        List<Integer> dp[][] = new ArrayList[num.length][num.length];
        String[][] opCh = new String[num.length][num.length];

        //对角线赋值
        for (int i = 0; i < num.length; i++) {
            List<Integer> b = new ArrayList<>();
            b.add(num[i]);
            dp[i][i] = b;
            if (i < num.length - 1) {
                opCh[i + 1][i] = op[i + 1];
            }
        }

        //从下到上  i代表行
        for (int i = num.length - 2; i >= 0; i--) {
            //从左到右 j代表列
            for (int j = i + 1; j < num.length; j++) {
                //定位到格子dp[i][j]，开始填可能的数：找左下角的op值
                //注意下面两层for循环有代表可能有多个结果，所以结果集要在这一层定义
                List<Integer> res = new ArrayList<>();
                for (int l = 0; l < j; l++) {
                    int k = l + 1;
                    //找矩形
                    //则右上角dp[i][j]为要填的格子，左下角opCh[k][l]为操作符
                    //左上角dp[i][l]为num1，右下角dp[k][j]为num2
                    if (k > i && opCh[k][l] != null) {
                        //找到矩形
                        //下面遍历格子里面的值
                        for (Integer num1 : dp[i][l]) {
                            for (Integer num2 : dp[k][j]) {
                                if ("+".equals(opCh[k][l])) {
                                    res.add(num1 + num2);
                                }
                                if ("-".equals(opCh[k][l])) {
                                    res.add(num1 - num2);
                                }
                                if ("*".equals(opCh[k][l])) {
                                    res.add(num1 * num2);
                                }
                            }
                        }
                    }
                }
                dp[i][j] = res;
            }
        }
        return dp[0][dp.length - 1];
    }


    //针对java本身String慢的优化，思路不变
    public static List<Integer> diffWaysToCompute2(String input) {
        if (input.length() == 0 || input == "") {
            return new ArrayList<>();
        }

        //1.转换成char[]  理论上很快
        char[] ch = input.toCharArray();
        char op[] = new char[ch.length];
        int num[] = new int[ch.length];
        int _i = 0;
        int _j = 0;
        int _k = 0;
        //"234*5"
        while (_i < ch.length - 1) {
            if (ch[_i] != '+' && ch[_i] != '*' && ch[_i] != '-') {
                //是数字
                //下一位
                if (ch[_i + 1] != '*' && ch[_i + 1] != '-' && ch[_i + 1] != '+') {
                    num[_j] += ch[_i] - '0';
                    num[_j] *= 10;
                } else {
                    num[_j] += ch[_i] - '0';
                    _j++;
                }
            } else {
                op[_k] = ch[_i];
                _k++;
            }
            _i++;
        }
        //加最后一个
        num[_j] += ch[ch.length - 1] - '0';

        List<Integer> dp[][] = new ArrayList[_j + 1][_j + 1];
        char[][] opCh = new char[_j + 1][_j + 1];

        //对角线赋值
        for (int i = 0; i < dp.length; i++) {
            List<Integer> b = new ArrayList<>();
            b.add(num[i]);
            dp[i][i] = b;
            if (i < dp.length - 1) {
                opCh[i + 1][i] = op[i];
            }
        }

        //从下到上
        for (int i = dp.length - 2; i >= 0; i--) {
            //从左到右
            for (int j = i + 1; j < dp.length; j++) {
                //定位到格子dp[i][j]，开始填可能的数：找左下角的op值
                //注意下面两层for循环有代表可能有多个结果，所以结果集要在这一层定义
                List<Integer> res = new ArrayList<>();
                for (int l = 0; l < j; l++) {
                    int k = l + 1;
                    //找到矩形
                    //则右上角dp[i][j]为要填的格子，左下角opCh[k][l]为操作符  构成矩形
                    //左上角dp[i][l]为num1，右下角dp[k][j]为num2
                    if (k > i && opCh[k][l] != '\0') {
                        //下面遍历格子里面的值
                        for (Integer num1 : dp[i][l]) {
                            for (Integer num2 : dp[k][j]) {
                                if ('+' == opCh[k][l]) {
                                    res.add(num1 + num2);
                                }
                                if ('-' == opCh[k][l]) {
                                    res.add(num1 - num2);
                                }
                                if ('*' == opCh[k][l]) {
                                    res.add(num1 * num2);
                                }
                            }
                        }
                    }

                }
                dp[i][j] = res;
            }
        }
        return dp[0][dp.length - 1];
    }
}
