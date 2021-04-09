package sort;

import org.junit.Test;

/**
 * @create 2021-01-04  16:09
 */
public class quickSort {

    @Test
    public void test(){
        int srt[] = {12,34,45,53,46,27,23,87,78,34,23,34,23,0,3,-3,-45};
        int low = 0;
        int high = srt.length-1;
        quicksotr(srt,low,high);
        for (int i=0; i<srt.length ; i++){
            System.out.print(srt[i]+"->");
        }
    }

    //递归实现
    public void quicksotr(int srt[] , int low ,int high){

        if(low<high){
            int partition = Partition(srt, low, high);
            quicksotr(srt,low,partition-1);  //枢纽左边
            quicksotr(srt,partition+1,high); //枢纽右边
        }

    }


    //分块操作，和枢纽比较，大的小的各一边
    public int Partition(int srt[] , int low ,int high){

        //默认第一个为枢纽元素
        int pivort = srt[low];

        while (low<high){

            while (low<high && srt[high] >= pivort){  //比枢纽大的在右边不变
                high--;
            }
            srt[low] = srt[high];  //找到右边第一个比枢纽小的和第一个元素对换

            while (low<high && srt[low]<= pivort){  //比枢纽小的在左边不变
            low++;
        }
        srt[high] = srt[low]; //找到左边第一个比枢纽大的和后面的元素对调

        }
        srt[low] = pivort; // 枢纽元素位置
        return low; //返回枢纽元素位置
    }
}

