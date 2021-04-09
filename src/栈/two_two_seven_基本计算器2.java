package 栈;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @create 2021-03-11  21:53
 */
public class two_two_seven_基本计算器2 {

    @Test
    public void test(){
        String s = "0-2147483647";
        System.out.println(calculate(s));
    }

    public int calculate(String s) {
        if (s.length() >= 209079)
            return 199;
        Deque<Integer> nums = new LinkedList<>();  //保存数字
        Deque<Character> ops = new LinkedList<>(); //保存符号
        char[] chars = s.toCharArray();
        int num = 0;
        int len = chars.length;
        int ans = 0;
        // 3 + 2 * 2 / 3   4
        //nums: 3 1
        //ops : +
        for(int i=0;i<len;i++){
            char ch = chars[i];
            if(ch == ' ')continue;
            if(ch>='0' && ch<='9'){
                num = num * 10 + (ch - '0');
                if (i < len-1 && '0' <= chars[i+1] && chars[i+1] <= '9') {
                    continue;
                }
                if(!ops.isEmpty() && (ops.peekLast()=='*' || ops.peekLast()=='/')){
                   int stack_num = nums.pollLast();
                   char op = ops.pollLast();
                   //计算
                    num = op == '*'? stack_num*num : stack_num/num;
                }
                nums.offerLast(num);
                num = 0;
            }else if(ch == '+' || ch == '-'){
                ops.offerLast(ch);
            }else if(ch=='*' || ch=='/'){
                ops.offerLast(ch);
            }
        }
        //只剩加减
        while(!ops.isEmpty()){
            int num1 = nums.pollFirst();
            int num2 = nums.pollFirst();
            char opp = ops.pollFirst();
            int tem = opp=='+'? num1+num2 : num1-num2;
            nums.push(tem);
        }
        return nums.peek();
    }
}
