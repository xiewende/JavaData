import org.junit.Test;

/**
 * @author wjw
 * @date 2021/4/16 22:39
 */
public class eight_seven_扰乱字符串 {

    @Test
    public void test(){
//        String s1 = "dsjhifdsahuas";
//       String s2 = "fdhsaasusjhid";
        String s1 = "abc";
        String s2 = "cba";
        boolean scramble = isScramble(s1, s2);
        System.out.println(scramble);
    }


    public boolean isScramble(String s1, String s2) {
       return backtrace(s1, s2);
    }

    public boolean backtrace(String s1, String s2){
        if (isSub(s1, s2)){
            return true;
        }

        for(int i = 1; i < s2.length(); i++) {
            if(backtrace(s1.substring(0, i), s2.substring(0, i)) &&  backtrace(s1.substring(i), s2.substring(i))) return true;
        }
        return false;
    }

    public boolean isSub(String s, String t){
        if("".equals(s) && "".equals(t)) return true;
        for(int i=0;i<t.length();i++){
            String x = t.substring(0,i);
            String y = t.substring(i);
             if((x + y).equals(s) || (y + x).equals(s)) return true;
        }
        return false;
    }
}
