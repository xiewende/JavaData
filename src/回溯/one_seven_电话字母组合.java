package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @create 2019-10-14  20:10
 */
public class one_seven_电话字母组合 {

    public static void main(String[] args) {
        List<String> a = letterCombinations("23");
        System.out.println(a.size());
    }

    private static List<String> result = new ArrayList<>();
    private static String[] dis = new String[]{" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0 || digits.equals("")) {
            result.clear();
            return null;
        }

        findletterCombinations(digits, 0, "");
        return result;
    }

    public static void findletterCombinations(String digits, int index, String s) {

        //index  递归到第几层
        if (index == digits.length()) {
            result.add(s);
            return;
        }

        char c = digits.charAt(index); //拿到  2 或者 3
        String letter = dis[c - '0'];  //拿到2后者3对应的字母组合
        for (int i = 0; i < letter.length(); i++) {
            String mo = s + String.valueOf(letter.charAt(i));
            findletterCombinations(digits, index + 1, mo);
        }
    }
}
