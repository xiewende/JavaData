package 栈;

import java.util.Stack;

/**
 * @create 2019-09-20  19:43
 */
public class two_zero_有效括号 {

    public boolean isValid(String s) {
        Stack stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                if (stack.size() == 0) {
                    return false;
                }
                //取栈顶的元素
                char c = (char) stack.peek();
                //出栈
                stack.pop();

                char match;
                if (s.charAt(i) == ')') {
                    match = '(';
                } else if (s.charAt(i) == ']') {
                    match = '[';
                } else {
                    assert (s.charAt(i) == '}');
                    match = '{';
                }

                if (c != match) {
                    return false;
                }

            }
        }

        if (stack.size() != 0) {
            return false;
        } else {
            return true;
        }
    }
}
