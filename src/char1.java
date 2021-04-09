import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @create 2019-09-02  20:18
 */

//给定两个数组，编写一个函数来计算它们的交集。
public class char1 {

    public static void main(String[] args) {

       /* Object re[] = intersection(new int[]{1,2,2,1},new int[]{2,2});
        for(Object i :re){
            System.out.println(i);
        }*/

        System.out.println(sqrt(2.0));
    }

    public static Object[] intersection(int[] nums1, int[] nums2) {
        /*int result[] = null;
        if(nums1.length>nums2.length){
            result = new int[nums2.length];
        }else {
            result = new int[nums1.length];
        }*/

        Map<Integer, Integer> map1 = new HashMap();
        // Map<Integer, Integer> map2=new HashMap();
        for (int i = 0; i < nums1.length; i++) {
            map1.put(nums1[i], null);
        }
        for (Integer i : map1.keySet()) {
            System.out.println("key=" + i + "value=" + map1.get(i));
        }

        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> resultSet = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        //int j=0;
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                //result[j] = nums2[i];
                resultSet.add(nums2[i]);
                set.remove(nums2[i]);
                //j++;
            }
        }

        // System.out.println(set);
        Object result[] = resultSet.toArray();
        return result;
    }


    public static Double sqrt(Double x) {
        if (x == 0) return 0.0;
        double last = 0;
        double res = 1;
        while (res != last) {
            last = res;
            res = (res + x / res) / 2;
        }
        return res;
    }
}
