package 贪心算法;

import java.util.Arrays;

/**
 * @create 2020-02-16  22:33
 */

/*
 * 1 2 2 3
 * 1 2
 * */
public class eight_eight_one_救生艇 {

    public static void main(String[] args) {
        int people[] = new int[]{1, 2};
        int limit = 3;
        numRescueBoats(people, limit);
    }

    public static int numRescueBoats1(int[] people, int limit) {

        Arrays.sort(people); //排序从小到大
        int count = 0; //记录救生艇数
        int right = people.length - 1;
        int left = 0;//遍历的index
        while (left <= right) {

            if (limit - people[left] >= people[right]) { // 最小的和最大的可以做同一艘救生艇
                left++;
                right--;
            } else {   //最小的和最大的不可以做同一艘救生艇，所以最大的要一个人做一艘救生艇
                right--;
            }
            count++;

        }
        return right == left ? count++ : count;
    }


    public static int numRescueBoats(int[] people, int limit) {

        Arrays.sort(people); //排序从小到大
        int count = 0; //记录救生艇数
        int right = people.length - 1;
        int left = 0;//遍历的index
        while (left <= right) {

            if (limit - people[left] >= people[right]) { // 最小的和最大的可以做同一艘救生艇
                left++;
                right--;
                count++;

            } else {   //最小的和最大的不可以做同一艘救生艇，所以最大的要一个人做一艘救生艇
                count++;
                right--;
            }

            if (right == left) {
                left++;
                count++;
            }
        }

        System.out.println("count=" + count);
        return 0;
    }

}
