package 滑动窗口;

import org.junit.Test;

import java.util.HashMap;

/**
 * @create 2021-02-10  18:27
 */
public class five_six_seven_字符串的排列 {

    @Test
    public void test(){
        String s1 =  "ab";
        String s2 = "eidboaoo";
        System.out.println(checkInclusion1(s1,s2));


    }
    /*
    分析：
    采取滑动窗口，[left,right]固定为s1的长度
    然后依次滑动left和right，
    每次都判断区间[left,right]是否符合s1的排序
    此方法比较暴力，执行时间较久，不是很理想
    */
    public boolean checkInclusion(String s1, String s2) {

        int s1Len = s1.length();
        int s2Len = s2.length();

        //统计s1出现的个数
        int flag[] = new int[26];
        for(int i=0 ;i<flag.length;i++){
            flag[i] = 0;
        }
        for(int i=0 ;i<s1Len;i++){
            flag[s1.charAt(i)-'a']++;
        }

        //寻找s2中的是否存在
        int left = 0;
        int right = s1Len-1;
        while(right<s2Len){
            boolean tag = true;
            int temLeft = left;
            int temright = right;

            //判断区间[left,right]是否符合s1的排序
            while(temLeft<=temright){
                flag[s2.charAt(temLeft)-'a']--;
                if(flag[s2.charAt(temLeft)-'a'] < 0){
                    //不符合
                    tag = false;
                }
                temLeft++;
            }
            int temLeft1 = left;
            //恢复flag的采用个数。
            while(temLeft1<=temright){
                flag[s2.charAt(temLeft1)-'a']++;
                temLeft1++;
            }
            if(tag){
                return true;
            }
            left++;
            right++;
        }
        return false;
    }
/*
    分析：
    相对上面的解法，这个具有较大的优化
    窗口【left，right】是随机滑动的
    只要 right-left == s1的长度 即找到了s1的排序字串
  */
    public boolean checkInclusion1(String s1, String s2) {

        int s1Len = s1.length();
        int s2Len = s2.length();
        //统计s1出现的个数
        int flag[] = new int[26];
        for(int i=0 ;i<flag.length;i++){
            flag[i] = 0;
        }
        for(int i=0 ;i<s1Len;i++){
            flag[s1.charAt(i)-'a']++;
        }

        //寻找s2中的是否存在
        int left = 0;
        int right = 0;
        while(right<s2Len){
            //判断s2中的字符是否符合s1
            int at_right = flag[s2.charAt(right)-'a']-1;
            //不符合，左指针右移动
            if(at_right < 0){
                flag[s2.charAt(left)-'a']++; //同时加回来那个字符的统计
                left++;
            }else {
                //符合 右指针移动
                flag[s2.charAt(right)-'a']--;
                right++;
            }

            //判断结果
            if(right-left == s1Len){
                return true;
            }
        }
        return false;
    }
}
