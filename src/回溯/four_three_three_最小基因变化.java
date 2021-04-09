package 回溯;

import org.junit.Test;

/**
 * @author wjw
 * @date 2021/3/28 23:45
 */
public class four_three_three_最小基因变化 {

    @Test
    public void test(){
        String start = "AACCGGTT";
        String end = "AAACGGTA";
        String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
        int re = minMutation(start, end, bank);
        System.out.println(re);
    }

    public int minMutation(String start, String end, String[] bank) {
        if(bank == null || bank.length == 0) return start.equals(end) ? 0 : -1;
        backtrace(end, start, bank, 0, new boolean[bank.length]);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int res = Integer.MAX_VALUE;
    public void backtrace(String end, String path, String[] bank, int idx, boolean[] isPass){
        if(path.equals(end)){
            res = Math.min(res, idx);
            return ;
        }

        for(int i = 0; i < bank.length; i++){
            if(isPass[i]) continue;
            int diff = diff(path, bank[i]);
            if(diff == 1){
                isPass[i] = true;
                backtrace(end, bank[i], bank, idx+1, isPass);
                isPass[i] = false;
            }
        }
    }

    public int diff(String str1, String str2){
        int num = 0;
        for(int i = 0; i < str1.length(); i++){
            if(str1.charAt(i) != str2.charAt(i)) num++;
        }
        return num;
    }
}
