package 数组;

import org.junit.Test;

/**
 * @author wjw
 * @date 2021/4/8 23:45
 */
public class eight_zero_删除有序数组中的重复项II {

    @Test
    public void test(){
        int[] nums = {0,0,1,1,1,1,2,3,3};
        int res = removeDuplicates(nums);
        System.out.println(res);
    }

    public int removeDuplicates(int[] nums) {
        int pNew = 1, pOld = 1;     //pNew记录删除后应该插入的位置，pOld是直接遍历的位置，该题实际表现为双指针
        boolean view = true;

        while(pOld < nums.length){
            if(nums[pOld] != nums[pOld - 1]){
                nums[pNew] = nums[pOld];
                pNew++;
                view = true;
            }else if(nums[pOld] == nums[pOld - 1] && view){
                nums[pNew] = nums[pOld];
                pNew++;
                view = false;
            }

            pOld++;
        }

        return pNew;
    }
}
