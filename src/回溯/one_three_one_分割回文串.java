package 回溯;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 回溯问题，树的每层添加一个分隔段，结束条件：分割到不能分割
 * @author wjw
 * @date 2020/9/16 17:25
 */
public class one_three_one_分割回文串 {

    @Test
    public void test(){
        String s = "aaabbaac";
        partition(s);
        System.out.println(res.toString());
    }

//    private List<List<String>> res = new ArrayList<>();
//
//    public List<List<String>> partition(String s) {
//        backtrace(s, new ArrayList<>(), 0);
//        return res;
//    }
//
//    public void backtrace(String s, List<String> path, int splitIndex){
//        if (splitIndex == s.length()){
//            res.add(new ArrayList<>(path));
//            return ;
//        }
//        for (int i = splitIndex; i < s.length(); i++) {
//            String a = s.substring(splitIndex, i + 1);
//            if (!check(a)) continue;
//            path.add(a);
//            backtrace(s, path, i + 1);
//            path.remove(path.size() - 1);
//        }
//    }
//
//    //检验回文
//    public boolean check(String str){
//        for (int i = 0; i < str.length() / 2; i++) {
//            if (str.charAt(i) != str.charAt(str.length() - i - 1)) return false;
//        }
//        return true;
//    }

    private List<List<String>> res = new ArrayList<>();
    private boolean[][] isPalindrome;

    public List<List<String>> partition(String s) {
        int n = s.length();
        isPalindrome = new boolean[n][n];

        for (int i = 0; i < n; ++i) {
            Arrays.fill(isPalindrome[i], true);
        }

        for (int r = 0; r < n; ++r) {
            for (int l = 0; l < r; ++l) {
                isPalindrome[l][r] = s.charAt(l) == s.charAt(r) && isPalindrome[l + 1][r - 1];
            }
        }

//        for (int i = n - 1; i >= 0; --i) {
//            for (int j = i + 1; j < n; ++j) {
//                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
//            }
//        }

        backtrace(s, new ArrayList<>(), 0);
        return res;
    }

    public void backtrace(String s, List<String> path, int splitIndex){
        if (splitIndex == s.length()){
            res.add(new ArrayList<>(path));
            return ;
        }
        for (int i = splitIndex; i < s.length(); i++) {
            String a = s.substring(splitIndex, i + 1);
            if (!isPalindrome[splitIndex][i]) continue;
            path.add(a);
            backtrace(s, path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
