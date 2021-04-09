package 回溯;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @create 2021-03-15  20:30
 */
public class seven_nine_seven_所有可能的路径 {

    @Test
    public void test(){
       // int graph[][] = {{1,2},{3},{3},{}};
        int g[][] = {{4,3,1},{3,2,4},{3},{4},{}};
        List<List<Integer>> lists = allPathsSourceTarget(g);
        System.out.println(lists.toString());
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> tem = new ArrayList<>();
        tem.add(0);
        dfs(graph,0,graph.length,tem);
        return ans;
    }

    public List<List<Integer>> ans = new ArrayList<>();
    public void dfs(int [][] graph,int next ,int end ,List<Integer> tem){

        //封装结果
        if(next == end-1){
            ans.add(new ArrayList<>(tem));
            return;
        }

        //next 时候可以选择得路线
        int graph_next[] = graph[next];

        for(int i=0;i<graph_next.length;i++){
            //加入路径
            tem.add(graph_next[i]);
            dfs(graph,graph_next[i],end,tem);
            tem.remove(tem.size()-1);
        }

    }
}
