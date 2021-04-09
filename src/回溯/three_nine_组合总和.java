package 回溯;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @create 2021-01-14  22:44
 */
public class three_nine_组合总和 {

    @Test
    public void test(){

        int candidates[] = {2,3,6,7};
        int target = 7;
        combinationSum(candidates,target);

        System.out.println(res.size());
        System.out.println(res.toString());

    }

    //结果集合
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<Integer> tem = new ArrayList<>();
        dfs(candidates,target,tem,0,0) ;

        return res;

    }

    public void dfs(int[] candidates, int target,List<Integer> tem,int sum,int index){

        if(sum == target){ //符合条件。加入结果集
            res.add(new ArrayList<>(tem));
            return;
        }
        if(sum>target){
            return;
        }

        for(int i =index ; i<candidates.length ; i++){

            tem.add(candidates[i]);
            sum = sum+candidates[i];

            dfs(candidates,target,tem,sum,i);

            tem.remove(tem.size() - 1);
            sum = sum-candidates[i];
        }


    }

}
