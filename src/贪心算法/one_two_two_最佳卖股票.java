package 贪心算法;

import org.junit.Test;

/**
 * @create 2020-03-18  16:05
 */
public class one_two_two_最佳卖股票 {


    @Test
    public void test(){
        //int[] ar = new int[]{1,2,3,4,5};
       //int[] ar = new int[]{7,1,5,3,6,4};
         //int[] ar = new int[]{2,1,4};
        //int[] ar = new int[]{6,1,3,2,4,7};
        //int[] ar = new int[]{7,6,4,3,1};
        int[] ar = new int[]{2,1,2,0,1};

        System.out.println(maxProfit1(ar));
    }


    //扫描一遍 只要后一天比前一天大 就把这两天的差值加一下
    public int maxProfit1(int[] prices) {
        if(prices.length < 2 ){
            return 0;
        }
        int score = 0;
        int differ ;
        for(int i=0 ;i<prices.length-1;i++){
            differ = prices[i+1]-prices[i];
            if(differ>0){
                score=score+differ;
            }
        }
        return score;
    }

    public int maxProfit(int[] prices) {

        if(prices.length < 2 ){
            return 0;
        }
        boolean[] tag = new boolean[prices.length];
        for(int i=0 ; i<tag.length ; i++){
            tag[i] = true;
        }

        int first = 0;
        int second = 1;
        int score = 0;

        while (second+1<prices.length){
            if(prices[first]>=prices[second]){ //前一天的值比后一天大，即是没有利益  都往后面加一
                first++;
                second++;
            }else {  //前一天的值比后一天小
                if(prices[second]>prices[second+1]){  //再比较后面和后面的后面比较 后面的大于后面的后面 出卖 反之 后面的指针继续后退 继续这个操作
                    score = score + (prices[second]-prices[first]);
                    tag[second] = false;
                    tag[first] = false;
                    first = second+1;
                    second = first+1;
                }else {
                    second++;
                }
            }
        }


        if(second<prices.length){ //second 大于长度就不用计算后面了
            if(tag[first] && tag[second] &&  prices[second]-prices[first]>0){   //没有用过的数和值大于0即可
                score = score + (prices[second]-prices[first]);
            }
        }

        /*while (second<prices.length){
            if(prices[first]>=prices[second]){ //前一天的值比后一天大，即是没有利益  都往后面加一
                first++;
                second++;
            }else {  //前一天的值比后一天小
                if(second<prices.length-1 && prices[second]>prices[second+1]){  //再比较后面和后面的后面比较 后面的大于后面的后面 出卖 反之 后面的指针继续后退 继续这个操作
                    score = score + (prices[second]-prices[first]);
                    tag[second] = false;
                    tag[first] = false;
                    first = second+1;
                    second = first+1;
                }else {
                    if(second == prices.length-1){
                        score = score + (prices[second]-prices[first]);
                    }
                    second++;
                }
            }
        }*/

        return score;
    }
}
