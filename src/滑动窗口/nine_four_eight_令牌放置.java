package 滑动窗口;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author wjw
 * @date 2021/3/23 23:52
 */
public class nine_four_eight_令牌放置 {

    @Test
    public void test(){
        int[] tokens = {100,200,300,400};
        int P = 200;
        int res = bagOfTokensScore(tokens, P);
        System.out.println(res);
    }

    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int l = 0, r = tokens.length - 1;
        int res = 0;
        while(l <= r){
            if(P >= tokens[l]){
                res++;
                P -= tokens[l];
                l++;
            }else{
                if(res >= 1 && P + tokens[r] >= tokens[l] && l != r){
                    res--;
                    P += tokens[r];
                    r--;
                }
                else break;
            }
        }

        return res;
    }
}
