package 回溯;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @create 2021-01-26  23:04
 */
public class three_eight_剑指offer_字符串全排列 {

    @Test
    public void test(){
        String str = "abc";
        System.out.println(permutation(str).toString());
        System.out.println(res.toString());
    }

    List<String> res = new ArrayList<>();
    public String[] permutation(String s) {
        if(s.length() == 0 || s==null){
            return null;
        }
        //标记数组
        boolean flag[] = new boolean[s.length()];
        for(int i = 0 ;i<flag.length;i++){
            flag[i] = false;
        }
       /* List<Character> tem = new ArrayList<>();
        dfs(s,tem,flag);*/
        StringBuilder stringBuilder = new StringBuilder();
        dfs1(s,stringBuilder,flag);
        String[] re = res.toArray(new String[res.size()]);
        return re;
    }

    public void dfs(String s , List<Character> tem, boolean flag[]){

        if(tem.size() == s.length()){
            res.add(tem.toString());
            return;
        }

        for(int i = 0 ; i<s.length() ; i++){
            if(flag[i] == false){
                flag[i] = true;
                tem.add(s.charAt(i));
                dfs(s,tem,flag);
                tem.remove(tem.size()-1);
                flag[i] = false;
            }
        }
    }

    public void dfs1(String s , StringBuilder stringBuilder, boolean flag[]){

        if(stringBuilder.length() == s.length()){

            String tem = stringBuilder.toString();
            if(!res.contains(tem)){
                res.add(tem);
            }
            return;
        }
        for(int i = 0 ; i<s.length() ; i++){

            if(flag[i]){
                continue;
            }

            if(flag[i] == false){
                flag[i] = true;
                //tem.add(s.charAt(i));
                stringBuilder.append(s.charAt(i));
                dfs1(s , stringBuilder,flag);
                //tem.remove(tem.size()-1);
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
                flag[i] = false;
            }
        }
    }

}
