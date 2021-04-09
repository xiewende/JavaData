import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @create 2020-04-12  22:20
 */
public class one_seven {


    @Test
    public void test(){
        String dihstis = "2689734";
        letterCombinations(dihstis);
        System.out.println(result.toString());
    }


    public String[] diss = new String[]{
            ",",",","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
    };
    public List<String> result = new ArrayList<>(); //记录全部结果
    public List<String> letterCombinations(String digits) {

         dfs(digits,0,"");
         return result;

    }

    public void dfs(String digits,int index, String str){   //digits  23  234

        //跳出递归
        if(index == digits.length()){  //拿到了一个结果
            result.add(str);  //保存结果
            return;
        }

        //拿到2   3
        char c = digits.charAt(index);
        //拿到数字对应的字母序列
        String string = diss[c-'0'];

        //可选路径
        for(int i=0 ;i<string.length() ; i++){

            String zhongjhian = str + String.valueOf(string.charAt(i));
            //进行递归
            dfs(digits,index+1,zhongjhian);


        }


    }



}
