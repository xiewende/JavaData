import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @create 2020-04-29  20:46
 */
public class five_one {

    @Test
    public void test(){


        List<List<String>> re = solveNQueens(4);
        for(List<String> list : re){
            System.out.println();
        }
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] chars = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chars[i][j] = '.';
            }
        }

        //结果
        List<List<String>> re = new ArrayList<>();
        backtrack(chars,0,re);


        return re;

    }

    public void backtrack(char[][] chars,int row,List<List<String>> re){

        if(row == chars.length){
            //添加到结果集  chars
            re.add(chsToList(chars));
            return;
        }

        //一列一列的放
        for(int col = 0 ;col<chars.length ;col++){

            //判断是否可以放  剪枝
            if(isTrue(chars,row,col)){
                //可以放
                chars[row][col] = 'Q';
                //dfs
                backtrack(chars,row+1,re);

                //状态重置
                chars[row][col] = '.';

            }

        }

    }

    //判断下一行是否可以放
    public boolean isTrue(char[][] chars , int x , int y){

        for(int i =0 ;i<=x ; i++){
            for(int j=0 ; j<chars[0].length ;j++){
                if(chars[i][j]=='Q' && (j==y || Math.abs(x-i) == Math.abs(y-j))){
                  return false;
                }
            }
        }

        return true;

    }


    public List<String> chsToList(char[][] chs){
        List<String> list=new ArrayList<>();
        for(int i=0;i<chs.length;i++){
            list.add(new String(chs[i]));
        }
        return list;
    }
}
