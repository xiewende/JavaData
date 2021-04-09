package str;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wjw
 * @date 2021/3/9 22:27
 */
public class one_zero_four_seven_删除字符串中的所有相邻重复项 {

    @Test
    public void test(){
        String S = "abbaca";
        String res = removeDuplicates(S);
        System.out.println(res);
    }

    // 栈
    public String removeDuplicates(String S) {
        char[] chars = S.toCharArray();
        Deque<Character> stack = new LinkedList<>();

        for(int i = chars.length - 1; i >= 0; i--){
            if(stack.isEmpty()) stack.offerLast(chars[i]);
            else{
                if(chars[i] == stack.peekLast()){
                    stack.pollLast();
                }else{
                    stack.offerLast(chars[i]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }

    // 也是栈的思想，不过直接修改了原数组，妙
    public String removeDuplicates2(String S) {
        if(S.length() == 1) return S;
        char[] ss = S.toCharArray();
        int index = -1;     //index就是右边界
        for (char c : ss) {
            if (index != -1 && c == ss[index]) {
                index--;
            } else {
                ++index;
                ss[index] = c;
            }
        }
        return new String(ss, 0, index + 1);
    }
}
