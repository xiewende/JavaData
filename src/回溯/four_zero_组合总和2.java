package 回溯;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @create 2021-02-09  17:48
 */
public class four_zero_组合总和2 {

    @Test
    public void test(){

        int candidates[] = {10,1,2,7,6,1,5}; // [1, 7],[1, 2, 5],[2, 6],  [1, 1, 6]

        int target = 8;
        combinationSum2(candidates,target);

        System.out.println(res.size());
        System.out.println(res.toString());

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //排序
        Arrays.sort(candidates);
        //标记数组
        boolean visit[] = new boolean[candidates.length];
        for(int i=0;i<candidates.length;i++){
            visit[i] = false;
        }
        List<Integer> tem = new ArrayList<>();
        //dfs(candidates,target,tem,0,0,visit) ;
        dfs2(candidates,target,tem,0,0,visit) ;
        return res;
    }

    //结果集合
    List<List<Integer>> res = new ArrayList<>();
    public void dfs(int[] candidates, int target,List<Integer> tem,int sum,int index,boolean[] visit){
        if(sum == target){ //符合条件。加入结果集
            if(!res.contains(tem)){
                res.add(new ArrayList<>(tem));
            }
            return;
        }
        if(sum>target){
            return;
        }
        for(int i=index;i<candidates.length;i++){
            if(visit[i]){
                continue;
            }
            //加入结果集
            tem.add(candidates[i]);
            sum = sum+candidates[i];
            visit[i] = true;
            dfs(candidates,target,tem,sum,i,visit);
            //还原
            tem.remove(tem.size() - 1);
            sum = sum-candidates[i];
            visit[i] = false;
        }
    }

    public void dfs2(int[] candidates, int target,List<Integer> tem,int sum,int index,boolean[] visit){
        if(sum == target){ //符合条件。加入结果集
            res.add(new ArrayList<>(tem));
            return;
        }
        for(int i=index;i<candidates.length;i++){
            if(sum+candidates[i]>target){
                break;
            }
            //单个比较
            if(target<candidates[i]){
                continue;
            }

            //这个去重方法好  首先需要排序
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            //加入结果集
            tem.add(candidates[i]);
            sum = sum+candidates[i];
            dfs2(candidates,target,tem,sum,i+1,visit);
            //还原
            tem.remove(tem.size() - 1);
            sum = sum-candidates[i];
        }
    }
}
