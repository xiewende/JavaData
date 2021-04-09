package str;

import org.junit.Test;

/**
 * @create 2020-04-12  15:02
 */
public class KMP_two_eight {

    @Test
    public void test(){
        String haystack = "hello";
        String needle = "ll";
        System.out.println(strStr(haystack,needle));

    }

    //简单模式匹配算法   时间复杂度O（n*m）
    //匹配成功 最好时间复杂度：主串第一个开始就匹配到了 为O（m）
    //匹配失败的最好时间复杂度 ：都比较第一个不相等，到最后一个  为O（n-m+1）=O(n-m)=O(n)
    public int strStr(String haystack, String needle) {

        int i = 0 ; //主串指针
        int j = 0;  //字串指针
        int k = 0;  //返回的位置

        while (i<haystack.length() && j<needle.length()){
            if(haystack.charAt(i) == needle.charAt(j)){  //若相等，往后走
                i++;
                j++;
            }else {   //不等回退指针
                k++;
                i=k;
                j=0;
            }
        }

        //判断输出
        if(j>needle.length()-1){
            return k;
        }else {
            return -1;
        }

    }


    //KMP算法
    int Index_Kmp(String haystack,String needle,int next[]){
        int i=0;
        int j = 0;
        while (i<haystack.length() && j<needle.length()){
            if(j == 0 || haystack.charAt(i)==needle.charAt(j)){  //相等都后挪，若是字串第一个也是一样
                i++;
                j++;
            }else {  //不等，字串的指针j移到指定数组位置
                j = next[j];
            }
        }

        if(j>needle.length()-1){
            return i-needle.length();
        }else {
            return -1;
        }
    }

    //求next数组


    public int[] get_Next(String string){
        return null;
    }
}
