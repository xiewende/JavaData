import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @create 2020-04-12  22:49
 */
public class seven_seven {

    @Test
    public void trest(){
        List<List<Integer>> res = combine(5,3);
        System.out.println(res.toString());
    }
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> re = new ArrayList<>();
        dfs(n,k,1,re);
        return result;
    }

    public void dfs(int n,int k,int index,List<Integer> re){

        if(re.size() == k){
            result.add(new ArrayList<>(re));
            return;
        }

        for(int i=index ; i<=n ;i++){
            re.add(i);
            dfs(n,k,i+1,re);
            re.remove(re.size()-1);
        }

    }

}
