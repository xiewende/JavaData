package 滑动窗口;

import org.junit.Test;

/**
 * @author wjw
 * @date 2021/2/6 22:17
 */
public class one_four_two_three_可获得的最大点数 {

    @Test
    public void test(){
        int[] cardPoints = {1,2,3,4,5,6,1};
        int k = 3;
        int res = maxScore(cardPoints, k);
        System.out.println(res);
    }

    public int maxScore(int[] cardPoints, int k) {
        int l = cardPoints.length - k, r = 0, res = 0, curSum = 0;

        for(int i = l; i < cardPoints.length; i++){
            curSum += cardPoints[i];
        }
        res = curSum;

        if(k == cardPoints.length) return res;  //优化：如果窗口大小就是数组大小，3ms -> 2ms

        while (l < cardPoints.length){
            //左减右加
            curSum -= cardPoints[l];
            l++;
            curSum += cardPoints[r];
            r++;
            res = curSum > res ? curSum : res;  //莫名其妙的比Math.max快1ms
        }

        return res;
    }
}
