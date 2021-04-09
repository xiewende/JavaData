package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @create 2019-11-23  16:37
 */
public class two_two_括号 {

   /* public static List<String> generateParenthesis(int n) {
        List<String> re = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add(0,"(");
        list.add(1, ")");
        insert(n,1,list, re);
        return re;
    }

    public static void insert (int n , int start , List<String> list, List<String> re){
        if(start == n){
            String del1 = String.valueOf(new ArrayList<String>(list)).replace(", ", "");
            String del2 = del1.replace("[", "");
            String del3 = del2.replace("]", "");
            if(!re.contains(del3)){
                re.add(del3);
            }

            return ;
        }

        for(int i=0;i< (list.size() / 2) + 1 ; i++){
            int center = list.size() / 2 + i;
            if (center == list.size() || !"(".equals(list.get(center)))
            {
                list.add(center,"(");
                list.add(center + 1, ")");
                insert(n,start+1,list, re);
                list.remove(center + 1);
                list.remove(center);

            }
        }
    }*/

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper("", n, 0, 0, result);
        return result;
    }

    void helper(String curr, int n, int left, int right, List<String> result) {
        if (right == n) {
            result.add(curr);
            return;
        }
        //加左括号
        if (left < n) {
            helper(curr + '(', n, left + 1, right, result);
        }
        //加右括号
        if (right < left) {
            helper(curr + ')', n, left, right + 1, result);
        }
    }

}
