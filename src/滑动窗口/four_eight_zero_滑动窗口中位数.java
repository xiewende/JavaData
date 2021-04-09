package 滑动窗口;

import org.junit.Test;

import java.util.*;

public class four_eight_zero_滑动窗口中位数 {

    @Test
    public void test() {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        double[] res = medianSlidingWindow2(nums, k);
        System.out.println(Arrays.toString(res));
    }

    //暴力：每次截取其中的窗口并进行排序，然后取中位数，O(n^2 * logn)
    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new double[]{0.0};
        }
        double[] res = new double[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            int[] arr = new int[k];
            System.arraycopy(nums, i, arr, 0, k);

            //排序
            Arrays.sort(arr);
            int mid = k / 2;
            if (k % 2 == 0) {
                res[i] = arr[mid - 1] / 2.0 + arr[mid] / 2.0;
            } else {
                res[i] = arr[mid];
            }
        }

        return res;
    }

    //第一次窗口填值并排好序，后面的只需要删除和加入新的窗口元素，且加入新窗口元素时可以通过二分查找应该插入的位置，O(n^2)
    public double[] medianSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new double[0];
        }

        double[] res = new double[nums.length - k + 1];
        int mid = k / 2;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(nums[i]);
        }
        Collections.sort(list);

        for (int i = 0; i < nums.length - k + 1; i++) {
            //加入结果集
            if (k % 2 == 0) {
                res[i] = list.get(mid - 1) / 2.0 + list.get(mid) / 2.0;
            } else {
                res[i] = list.get(mid);
            }

            if (i + k == nums.length) break;

            //去掉一个
            list.remove(Integer.valueOf(nums[i]));

            //插入新的
            int idx = findIndex(list, nums[i + k]);
            list.add(idx, nums[i + k]);
        }

        return res;
    }

    // 最终优化：和2思想一样，只是该题其实窗口从头到尾都是有序的，细节优化为全局都使用二分
    // 优化1：第一次窗口填值就可以通过二分查找插入对应位置，无需排序
    // 优化2：不止是加入新元素的时候用二分，删除旧元素的时候也可通过二分查找位置，这样调用remove就不用遍历查找了
    // O(n * logn)
    public double[] medianSlidingWindow3(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new double[0];
        }
        double[] res = new double[nums.length - k + 1];
        int mid = k / 2;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            //优化：插入的时候就可以再利用二分查找顺便排好序
            int idx = findIndex(list, nums[i]);
            list.add(idx, nums[i]);
        }
        for (int i = 0; i < nums.length - k + 1; i++) {
            //加入结果集
            if (k % 2 == 0) {
                res[i] = list.get(mid - 1) / 2.0 + list.get(mid) / 2.0;
            } else {
                res[i] = list.get(mid);
            }
            if (i + k == nums.length) break;
            //去掉一个
            //优化：去掉的时候也可以利用二分查找删除，就可以remove下标而不是remove元素
            int idx = findIndex(list, nums[i]);
            list.remove(idx);
            //插入新的
            idx = findIndex(list, nums[i + k]);
            list.add(idx, nums[i + k]);
        }
        return res;
    }

    /**
     * 二分查找
     */
    public int findIndex (List <Integer > nums,int target){
        int l = 0, r = nums.size() - 1, mid;

        while (l <= r) {
            mid = l + (r - l) / 2;
            if (target < nums.get(mid)) r = mid - 1;
            else if (target == nums.get(mid)) return mid;
            else if (target > nums.get(mid)) l = mid + 1;
        }
        return l;
    }
}

