package 滑动窗口;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @create 2021-02-09  21:53
 */
public class nine_nine_two_不同整数的子数组 {

    @Test
    public void test(){
        int A[] = {1,2,1,3,4};
        int k=3;
        int i = subarraysWithKDistinct2(A, k)-subarraysWithKDistinct2(A, k-1);
        System.out.println(i);
    }

    //3毫秒 打败100%  和下面的区别在于在窗口滑动的过程中，就找恰好有k个子数组个数
    public int subarraysWithKDistinct2(int[] A, int K) {
        int length = A.length, left = 0, right = 0, diff = 0, ans = 0;
        int[] arr = new int[length + 1];

        //处理数字重复的好方法
        while (right < length) {
            //第一次出现，不同的数字个数统计就加一；同时某个数字的出现次数加1
            if (arr[A[right]]++ == 0) {
                diff++;
            }
            while (diff > K) {
                if (--arr[A[left]] == 0) {
                    diff--;
                }
                left++;
            }
            if (diff == K) {
                //计算恰巧为k的时候，统计子数组的个数
                int leftTemp = left;
                while (diff == K) {//正在统计中
                    if (--arr[A[leftTemp]] == 0) {
                        diff--;
                    }
                    leftTemp++;
                    ans++;
                }
                //还原这个区间内的diff
                for (int i = left; i < leftTemp; i++)
                    if (arr[A[i]]++ == 0) {
                        diff++;
                    }
                //ans = ans+(right-left);
            }
            right++;
        }
        return ans;
    }

    //未实现
    public int subarraysWithKDistinct(int[] A, int K) {
        ArrayList<Integer> remenber = new ArrayList<>();
        int left = 0;
        int right = 0;
        int count = 0; //不用元素个数
        int re = 0;  //结果集合
        //1,2,1,2,3
        while(left<A.length){
            //符合即是加入结果集
            if(count == K){
                re++;
            }
            if(remenber.contains(A[right])){
                right++;
            }else {
                if(count==2 || right==A.length-1){
                    remenber.remove(0);
                    left++;
                    right = left+1;
                }
                if(count<2 && right<A.length){
                    remenber.add(A[right]);
                    count++;
                    right++;
                }
            }
        }
    return re;


    }
    /*
    思路：
    先计算 最多有K个不同数字的子数组
    再利用最多k个的 - 最多k-1个的  答案即为恰巧为k的
    */
    public int subarraysWithKDistinct1(int[] A, int K) {
        return subarraysMaxWithKDistinct(A,K) - subarraysMaxWithKDistinct(A,K-1);
    }

    // 904 对比
    public int subarraysMaxWithKDistinct(int []A,int k){
        int left = 0;
        int right = 0;
        int flag[] = new int[20010];
        for(int i=0;i<flag.length;i++){
            flag[i] = 0;
        }
        int count = 0;
        int res = 0;

        //认真体会这样处理判断重复的搔操作，简直完美，不动声色就解决了问题
        while(right<A.length){
            if(flag[A[right]] == 0){
                count++;
            }
            flag[A[right]]++;
            right++;

            //左指针开始移动
            while(count>k){
                flag[A[left]]--;
                if(flag[A[left]] == 0){
                    count--;
                }
                left++;
            }
            res = res+(right-left);
        }
        return res;
    }
}
