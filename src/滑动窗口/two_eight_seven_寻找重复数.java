package 滑动窗口;

import java.util.Arrays;

/**
 * @create 2021-05-08  0:18
 */
public class two_eight_seven_寻找重复数 {

    //排序+遍历找相同
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i] == nums[i+1]){
                return nums[i];
            }
        }
        return 0;
    }

    //计数法
    public int findDuplicate1(int[] nums) {
        int n = nums.length;
        int count[] = new int[n+1];
        for(int i=0;i<n;i++){
            count[nums[i]]++;
            if(count[nums[i]]>1) return nums[i];
        }
        return 0;
    }

    //神奇法：将一个nums值放到对应下标为nums的数组中
    public int findDuplicate2(int[] nums) {
        int num = nums[0];
        while(true){
            int temNum = nums[num];
            if(nums[num] == num) return num;
            nums[num] = num;
            num = temNum;
        }
    }

    /**
     快慢指针思想, fast 和 slow 是指针, nums[slow] 表示取指针对应的元素
     注意 nums 数组中的数字都是在 1 到 n 之间的(在数组中进行游走不会越界),
     因为有重复数字的出现, 所以这个游走必然是成环的, 环的入口就是重复的元素,
     即按照寻找链表环入口的思路来做
     **/
    public int findDuplicate3(int[] nums) {
        int fast = 0, slow = 0;
        while(true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            //找环入口！！
            if(slow == fast) {
                fast = 0;
                while(nums[slow] != nums[fast]) {
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return nums[slow];
            }
        }
    }
}
