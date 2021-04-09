package 滑动窗口;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @create 2021-03-30  22:51
 */
public class one_seven_one_one_大餐计数 {

    @Test
    public void test(){

        int deliciousness[] = {1,3,5,7,9};
        int i = countPairs(deliciousness);
        System.out.println(i);
        System.out.println(Math.pow(2,20));
    }

    public boolean istrueOfnum[];
    public int countPairs(int[] deliciousness) {
        Arrays.sort(deliciousness);
        int len = deliciousness.length;
//        int max = deliciousness[len-1]+deliciousness[len-2]+1;
//        istrueOfnum = new boolean[max];
        int left = 0;
        int right = 1;
        int ans = 0;

        int countOfone = 0;
        int lastLeft =0;
        int lastCountOfone=0;

        while(left < len-1){

            if(left>=1 && deliciousness[lastLeft]==deliciousness[left]){
                if(isTrue(deliciousness[lastLeft]+deliciousness[left])){
                    lastCountOfone--;
                }
                ans = (ans+lastCountOfone) % 1000000007;
                lastLeft = left;
                left++;
                right = left+1;
                continue;
            }
            long sum = deliciousness[left] + deliciousness[right];
            if(isPowerOfTwo(sum)){
                //ans = (ans+1) % 1000000007;
                countOfone++;
            }
            right++;
            if(right == len){
                lastLeft = left;
                lastCountOfone = countOfone;
                left++;
                right = left+1;
                //一轮的
                ans = (ans+countOfone) % 1000000007;
                countOfone = 0;
            }
        }
        return ans;
    }

    public boolean isTrue(int num){

        if(istrueOfnum[num])return true;
        int tem = num;
        int count = 0;
        while(num != 0){
            if((num & 1) == 1) count++;
            num = num >> 1;
        }
        if(count==1){
            istrueOfnum[tem] = true;
        }
        return count==1;
    }

    public boolean isPowerOfTwo(long n) {
        return n > 0 && (n & (n - 1)) == 0;
    }


    public int countPairs1(int[] deliciousness) {
        Map<Integer, Integer> map = new HashMap<>();
        int mod = 1000000007;
        int answer = 0;
        int length = deliciousness.length;
        for (int num : deliciousness) {
            int powerOfTwo = 1;
            // 为什么是21？ 因为数字最大为2^20, 2^20 + 2^20 = 2^21为可能的最大值，不可能再大啦！
            for (int i = 0; i <= 21; i++) {
                if (powerOfTwo >= num && map.containsKey(powerOfTwo - num)) {
                    answer += map.get(powerOfTwo - num);
                    answer %= mod;
                }
                powerOfTwo *= 2;
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return (int)answer;
    }


}
