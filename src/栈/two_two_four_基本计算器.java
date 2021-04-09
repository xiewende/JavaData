package 栈;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @create 2021-03-10  22:50
 */
public class two_two_four_基本计算器 {

    @Test
    public void test(){
        String s = "2-(5-6)";
        System.out.println(calculate(s));
//        String s = "5-6";
//        System.out.println(seekNumWithString(s));
    }

    //不可行
    boolean flag = true; //true 表示正数
    int last_flag = 1;
    public int calculate(String s) {
        //加上必要的括号，统一规范

        s = "("+s+")";

        char[] chars = s.toCharArray();
        int ans = 0;
        //使用栈
        LinkedList<Character> list = new LinkedList<>();
        list.addFirst(s.charAt(0));
        for(int i = 1;i<chars.length;i++){
            char ch = chars[i];
            if(ch == ' '){
                continue;
            }else if(ch == ')'){
                StringBuffer stringBuffer = new StringBuffer();
                //退栈
                while(list.peekLast()!='('){
                    char ch1 = list.pollLast();
                    stringBuffer.append(ch1);
                }
                //去求值，返回，放入栈
                //先退出左括号，再塞入值
                list.pollLast();
                String temStr = stringBuffer.reverse().toString();
                int tem = seekNumWithString(temStr);
                //判断正负
                if(flag == false && !list.isEmpty() && list.peekLast()=='+'){ //一正一负
                    list.pollLast();
                    list.addLast('-');
                }
                if(flag == false && !list.isEmpty() && list.peekLast()=='-'){ //负负得正
                    list.pollLast();
                    list.addLast('+');
                }

                //

                String s1 = String.valueOf(tem);
                int idx=0;
                while(idx<s1.length()){
                    list.addLast(s1.charAt(idx));
                    idx++;
                }


                //每次跟新结果

                ans = flag==true? (last_flag * tem):(-tem *last_flag) ;

                last_flag = flag==true?1:-1;

            }else {
                list.addLast(ch);
            }
        }
        return ans;
    }
    //给定一个字符串求值
    public int seekNumWithString(String str){
        char[] chars = str.toCharArray();
        int res = 0;
        int sign = 1;
        int index = 0;
        while(index<chars.length){
            char ch = chars[index];
            if(ch == '+' || ch == '-'){
                sign = ch=='+'? 1 : -1;
                index++;
            } else if(ch>='0' && ch<='9'){
                long num = 0;
                while (index < chars.length && '0' <= chars[index] && chars[index] <= '9') {
                    num = num * 10 + chars[index] - '0';
                    index++;
                }
                res += sign*num;
            }
        }
        flag = res>=0?true:false;
        return Math.abs(res);
    }


    //分为三个部分
    //（前面）（+/-）（后面）
    //栈里面就是 前面，'('又括号右边得符号   ==》 一个前面的结果一个符号
    //遇到右括号就退栈，将后面的值和前面的值加减
    //(1-(4+5+2)-3)+(6+8)  11 12-3 9 10 14
    //stack :
    // 10 +
    public static int calculate1(String s) {
//        计算结果，部分计算结果，括号中计算结果
        int res = 0;
//        当前的数字，例如：1+23中的1或者23
        int num = 0;
//        符号，加号(+1)或者减号(-1)
        int sign = 1;
//        当右括号时，用于存储计算结果
        Stack<Integer> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            char c = chars[i];
//            如果当前字符为' '，则直接continue
            if (c == ' ') {
                continue;
            }
//            如果当前字符是一个数字，则用num进行记录
//            当前有可能是一个>9的数字，所以需要num = num * 10 + c - '0'
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
//                判断当前数字是否已经取完
//                例如：123+4，只有当取到+时，才能确定123为当前的num
                if (i < len-1 && '0' <= chars[i+1] && chars[i+1] <= '9') {
                    continue;
                }
//            如果当前字符为'+'或者'-'
            } else if (c == '+' || c == '-') {
//                将num置为0，用来存放当前符号(+/-)之后的数字
                num = 0;
//                如果当前符号为+，则sign为+1
//                如果当前符号为-，则sign为-1
                sign = c=='+' ? 1 : -1;
//            如果当前符号为'('
            } else if (c == '(') {
//                例如当前表达式为：'123+(...)'
//                则将res:123，入栈
                stack.push(res);
//                则将sign:+，入栈
                stack.push(sign);
//                同时res置为0，用来保存()中的计算结果
                res = 0;
//                sign置为初始状态，为1
                sign = 1;
//            如果当前符号为')'
            } else if (c == ')') {
//                '('前边的符号出栈
                sign = stack.pop();
//                将num替换为括号中的计算结果
                num = res;
//                将res替换为括号前边的计算结果
                res = stack.pop();
            }
//            每遍历一次，得到一个res
            res += sign * num;
        }
        return res;
    }

    //会把括号里面得正负号改为对应得正负号，再进行加减，
    //相当于去括号，改正负号，再以此左到右加起来就好
    public int calculate2(String s) {
        Deque<Integer> ops = new LinkedList<Integer>();
        ops.push(1);
        int sign = 1;

        int ret = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            char ch = s.charAt(i);
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ret += sign * num;
            }
        }
        return ret;
    }

}
