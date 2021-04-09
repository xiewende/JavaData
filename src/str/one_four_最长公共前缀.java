package str;

/**
 * @create 2021-03-01  15:31
 */
public class one_four_最长公共前缀 {

    public void test(){
        String sres[] = {"flower","flow","flight"};
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)return "";
        //公共前缀比所有字符串都短，随便选一个先
        String s=strs[0];
        for (String string : strs) {
            while(!string.startsWith(s)){
                if(s.length()==0)return "";
                //公共前缀不匹配就让它变短！
                s=s.substring(0,s.length()-1);
            }
        }
        return s;
    }
}
