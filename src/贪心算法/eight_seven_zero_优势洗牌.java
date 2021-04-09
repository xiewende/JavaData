package 贪心算法;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @create 2020-02-13  11:56   [2,0,4,1,2]
 * [1,3,0,0,2]
 */
public class eight_seven_zero_优势洗牌 {

    public static void main(String[] args) {
        int a[] = new int[]{2, 0, 4, 1, 2};
        int b[] = new int[]{1, 3, 0, 0, 2};
        advantageCount1(a, b);
    }

    public static int[] advantageCount(int[] A, int[] B) {

        if (A == null || B == null) {
            return null;
        }
        if (A.length < 0 || B.length < 0 || A.length != B.length) {
            return null;
        }

        Map<Integer, Integer> helpMap = new HashMap<>();

        for (int k = 0; k < B.length; k++) {
            helpMap.put(B[k], k);
        }

        Arrays.sort(A);
        Arrays.sort(B);
        System.out.println("A=" + Arrays.toString(A));
        System.out.println("B=" + Arrays.toString(B));

        int[] result = new int[A.length];


        Map<Integer, Integer> resultMap = new HashMap<>();
        int i = 0;//遍历A
        int j = 0;//遍历B
        /*
        *      8,12,24,32
               11,13,25,32
        * */
        while (i < A.length && j < B.length) {
            if (A[i] > B[j]) {
                resultMap.put(B[j], A[i]);
                j++;
            } else {
                resultMap.put(B[B.length - 1 - j], A[i]);
            }
            i++;

        }

   /*     for (Integer key : helpMap.keySet()) {
            Integer value = helpMap.get(key);
            System.out.println("Key0 = " + key + ", Value0 = " + value);
        }*/


        for (Integer key : resultMap.keySet()) {
            Integer value = resultMap.get(key);
            System.out.println("Key = " + key + ", Value = " + value);
        }

        for (int h = 0; h < B.length; h++) {
            result[helpMap.get(B[h])] = resultMap.get(B[h]);
        }

        System.out.println(Arrays.toString(result));

        return null;

    }


    public static int[] advantageCount1(int[] A, int[] B) {

        int[] result = new int[A.length];
        boolean flag[] = new boolean[A.length];
        for (int i = 0; i < flag.length; i++) {
            flag[i] = true;
        }
        Arrays.sort(A);

        int index = -1;

        for (int k = 0; k < B.length; k++) {  // B
            for (int j = 0; j < A.length; j++) {  // A
                if (flag[j]) {
                    if (A[j] > B[k]) {
                        index = j;
                        break;
                    }
                }
            }

            //遇到A中没有比B大的值，把A中最小的赋值过去

            if (index == -1) {
                for (int h = 0; h < A.length; h++) {
                    if (flag[h]) {
                        index = h;
                        break;
                    }
                }

            }

            result[k] = A[index];
            flag[index] = false;
            index = -1;
        }

        System.out.println(Arrays.toString(result));
        return null;

    }
}
