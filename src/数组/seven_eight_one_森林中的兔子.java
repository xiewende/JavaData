package 数组;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author wjw
 * @date 2021/4/15 23:09
 */
public class seven_eight_one_森林中的兔子 {

    @Test
    public void test(){
        int[] answers = {1,1,1,1,1,1,1,1,1,1,1};
        int res = numRabbits1(answers);
        System.out.println(res);
    }

    public int numRabbits(int[] answers) {
        Arrays.sort(answers);
        int num = 0, i = 0;
        while(i < answers.length){
            int otherSameColor = answers[i];
            num += otherSameColor + 1;  // 从该兔子口中得知当前颜色一共有多少只
            // 往后跳过nums[i]个
            while(otherSameColor-- != 0 && i + 1 < answers.length && answers[i] == answers[i + 1]){
                i++;
            }
            i++;
        }
        return num;
    }

    public int numRabbits1(int[] answers) {
        int alph[] = new int[1000];
        int ans = 0;
        for(int i=0 ; i<answers.length;i++){
            //需要统计
            if(alph[answers[i]] == 0){
                ans = ans + answers[i] +1;
                alph[answers[i]] = answers[i];
            }else {
                alph[answers[i]]--;
            }
        }
        return ans;
    }
}
