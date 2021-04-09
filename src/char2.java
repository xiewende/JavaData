import java.util.Arrays;
import java.util.HashMap;

/**
 * @create 2019-09-02  22:23
 */
public class char2 {
    public static void main(String[] args) {

        carFleet(12, new int[]{10, 8, 3, 3}, new int[]{1, 3, 3, 4});


    }

    public static int carFleet(int target, int[] position, int[] speed) {

        if (position.length == 0) {
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < position.length; i++) {
            map.put(position[i], speed[i]);
        }

        Arrays.sort(position);

        for (int i = 0; i < position.length; i++) {
            speed[i] = map.get(position[i]);
        }

        int i = position.length - 2, j = position.length - 1;
        int sum = 0;
        double time1;
        double time2;
        while (i >= 0) {

            if (map.get(position[i]) < map.get(position[j])) {  //没有追上
                sum++;
                i--;
                j--;
            } else {
                time1 = (target - position[i]) * 1.0 / map.get(position[i]);
                time2 = (target - position[j]) * 1.0 / map.get(position[j]);
                if (time1 <= time2) { //追上
                    position[i] = position[j];
                    speed[i] = speed[j];

                    i--;
                    j--;
                } else {
                    sum++;  //规定时间内没有追上
                    i--;
                    j--;

                }
            }


        }

        sum++;
        return sum;
    }
}
