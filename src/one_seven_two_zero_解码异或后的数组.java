import org.junit.Test;

import java.util.Arrays;

/**
 * @date 2021/5/6 23:11
 */
public class one_seven_two_zero_解码异或后的数组 {

    @Test
    public void test(){
        int[] encoded = {1,2,3};
        int first = 1;
        int[] res = decode(encoded, first);
        System.out.println(Arrays.toString(res));
    }

    /**
     * 异或公式：a ^ b ^ b = a
     * a:arr[i]
     * b:arr[i+1]
     * a^b:encoded[i]
     * 本题中就是通过arr[i]不断获取arr[i+1]
     * 即arr[i+1] = encoded[i] ^ arr[i]
     */
    public int[] decode(int[] encoded, int first) {
        int[] arr = new int[encoded.length + 1];
        arr[0] = first;
        int idx = 1;

        while(idx < arr.length){
            arr[idx] = encoded[idx - 1] ^ first;
            first = arr[idx];
            idx++;
        }

        return arr;
    }
}
