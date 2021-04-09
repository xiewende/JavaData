import org.junit.Test;

/**
 * @create 2020-03-23  18:21
 *
 * 假设原始数组为 A。先构造一个临时数组 tmp，初始化为 0，大小为A.size().
 * 遍历 A，把 A[i] 复制到 tmp[A[i]-1] 的位置。如果 A[i] - 1 超过了 tmp 的范围，
 * 就直接扔掉。如此一来，tmp[0...size) 中就保存了一部分 A 的值。然后从位置 0 开始检查 tmp，
 * 如果发现该位置的值和索引号不匹配，就说明找到了缺失的数了。
 *
 */
public class four_one_最小正数 {

    @Test
    public void test(){
        int nums[] = {1};
        System.out.println(firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {

        if(nums.length == 0){
            return 1;
        }

        int[] temp = new int[nums.length];
        for(int i=0 ; i<nums.length ; i++){
            if(nums[i]-1<nums.length && nums[i]-1>=0){
                temp[nums[i]-1] = nums[i];
            }
        }

        for(int j=0 ; j<temp.length ; j++){
            if(temp[j]==0){
                return j+1;
            }
        }

        if(nums.length==1){
            return nums[0]==1?2:1;
        }else {
            return nums.length+1;
        }

    }
}
