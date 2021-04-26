import org.junit.Test;

import java.util.*;

/**
 * @author wjw
 * @date 2021/3/2 22:57
 */
public class two_six_four_丑数II {

    @Test
    public void test(){
        int res = nthUglyNumber2(11);
        System.out.println(res);
    }

    public int nthUglyNumber(int n) {
        Map<Integer, Boolean> dp = new HashMap<>();   //dp[i]表示数字i是否是丑数
        int count = 1;
        dp.put(0, false); dp.put(1, true);

        int i = 1;
        while (count != n) {
            i++;
            if (i % 2 == 0){
                if (dp.getOrDefault(i / 2, false)){
                    dp.put(i, true);
                    count++;
                    continue;
                }
            }
            if (i % 3 == 0){
                if (dp.getOrDefault(i / 3, false)){
                    dp.put(i, true);
                    count++;
                    continue;
                }
            }
            if (i % 5 == 0){
                if (dp.getOrDefault(i / 5, false)){
                    dp.put(i, true);
                    count++;
                    continue;
                }
            }
        }
        return i;
    }

    public int nthUglyNumber2(int n) {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);

        int i2 = 0, i3 =  0, i5 = 0;
        for(int i = 0; i < n - 1; i++){
            int val = Math.min(nums.get(i2) * 2, Math.min(nums.get(i3) * 3, nums.get(i5) * 5));
            nums.add(val);

//            while (nums.get(i2) * 2 <= val) i2 += 1;
//            while (nums.get(i3) * 3 <= val) i3 += 1;
//            while (nums.get(i5) * 5 <= val) i5 += 1;

            if (nums.get(i2) * 2 == val) i2 += 1;
            if (nums.get(i3) * 3 == val) i3 += 1;
            if (nums.get(i5) * 5 == val) i5 += 1;
        }

        return nums.get(nums.size() - 1);
    }
}

