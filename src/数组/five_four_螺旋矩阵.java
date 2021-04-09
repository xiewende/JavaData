package 数组;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @create 2021-03-15  22:41
 */
public class five_four_螺旋矩阵 {

    @Test
    public void test(){
        int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> list = spiralOrder(matrix);
        System.out.println(list.toString());
    }

    public List<Integer> spiralOrder(int[][] matrix) {

        int dx[] = {0,1,0,-1};
        int dy[] = {1,0,-1,0};
        int rowLen = matrix.length;
        int colLen =  matrix[0].length;
        boolean visit[][] = new boolean[rowLen][colLen];
        int turn = 0;
        List<Integer> ans = new ArrayList<>();
        int len =  rowLen*colLen;
        int x = 0;
        int y = -1;
        for(int i=0;i<len;i++){
            if(!cheak(matrix,x+dx[turn],y+dy[turn]) || visit[x+dx[turn]][y+dy[turn]] ){
                turn = (turn+1) % dx.length;
            }
            ans.add(matrix[x+dx[turn]][y+dy[turn]]);
            visit[x+dx[turn]][y+dy[turn]] = true;
            x += dx[turn];
            y += dy[turn];
        }
        return ans;
    }

    public boolean cheak(int[][] matrix,int x,int y){
        return x < matrix.length && x >=0 && y < matrix[0].length && y >=0;
    }
}
