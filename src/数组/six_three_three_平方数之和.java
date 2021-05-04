package 数组;

import org.junit.Test;

/**
 * @date 2021/4/28 23:47
 */
public class six_three_three_平方数之和 {

    @Test
    public void test(){
        boolean res = judgeSquareSum(2147483646);
        System.out.println(res);
    }

    // 要用long，因为int的话会溢出：i * i溢出则为负数，for循环条件永远为true
    public boolean judgeSquareSum(int c) {
        for(long i = 0; i * i <= c; i++){
            double sqrtOther = Math.sqrt(c - i * i);
            if(sqrtOther == (int)sqrtOther) return true;
        }
        return false;
    }

    // 双指针
    public boolean judgeSquareSum2(int c) {
        int l = 0, r = (int)Math.pow(c, 0.5);

        while(l <= r){
            int val = l * l + r * r;
            if(val == c) return true;
            else if(val < c) l++;
            else r--;
        }

        return false;
    }
}
