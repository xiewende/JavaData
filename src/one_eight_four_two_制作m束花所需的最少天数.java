import org.junit.Test;

import java.util.Arrays;

/**
 * @create 2021-05-09  23:32
 */
public class one_eight_four_two_制作m束花所需的最少天数 {

    @Test
    public void test(){
        int bloomDay[] = {7,7,7,7,12,7,7};
        int m = 2;
        int k = 3;
        int i = minDays(bloomDay, m, k);
        System.out.println(i);
    }

    public int minDays(int[] bloomDay, int m, int k) {

        if(m * k > bloomDay.length) return -1;

        int left = Arrays.stream(bloomDay).min().getAsInt();
        int right = Arrays.stream(bloomDay).max().getAsInt();

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(judge(bloomDay,m,k,mid)){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;

    }

    public boolean judge(int[] bloomDay, int m, int k,int mid){

        boolean flag[] = new boolean[bloomDay.length];
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=mid) flag[i] = true;
        }
        int count = 0;
        int index = 0;
        int temK = 0;
        while(index < bloomDay.length){
            if(flag[index] == true){
                temK++;
                if(temK == k){
                    count++;
                    temK = 0;
                }
            }else {
                temK = 0;
            }
            index++;
        }
        return count >= m;
    }
}
