package 贪心算法;

import java.util.Arrays;

/**
 * @create 2020-02-13  22:33
 */
public class nine_four_eight_令牌放置 {

    public static void main(String[] args) {

        int tokens[] = new int[]{100, 200};
        int p = 150;
        System.out.println(bagOfTokensScore(tokens, p));

    }


    public static int bagOfTokensScore(int[] tokens, int P) {

        if (tokens.length == 1) {
            if (P >= tokens[0]) {
                return 1;
            } else {
                return 0;
            }
        }

        Arrays.sort(tokens);

        //两个遍历指针
        int start = 0;
        int end = tokens.length - 1;

        //分数
        int count = 0;

        while (start <= end) {
            if (P >= tokens[start]) {
                P = P - tokens[start];
                count++;
                start++;
                //count = Math.max(count)
            } else {
                if (count > 0 && P + tokens[end] > tokens[start] && start != end - 1 && start != end) {
                    P = P + tokens[end];
                    count--;
                    end--;
                } else {
                    break;
                }
            }
        }

        System.out.println(count);

        return count;

    }
}
