package 回溯;

/**
 * @create 2020-01-30  16:09
 */
public class three_zero_six_累加数 {
    static int n;
    static String s;

    public static boolean isAdditiveNumber(String num) {
        s = num;
        n = s.length();
        return backtrack(-1, 2);
    }

    // dots取2表示先确定前两个数
    public static boolean backtrack(int prev_pos, int dots) {
        for (int curr_pos = prev_pos + 1; curr_pos < n; curr_pos++) {
            // dots==1 表示前两个数都已经确定
            if (dots == 1) {
                if (s.charAt(prev_pos + 1) == '0' && (curr_pos - prev_pos > 1)) return false;
                if (isValid(prev_pos, curr_pos)) {
                    return true;
                }
            } else if (backtrack(curr_pos, dots - 1))
                return true;
        }
        return false;
    }

    // 判断每次确定的两个分割位置是否形成累加数
    public static boolean isValid(int first, int second) {
        int pre_first = -1;
        while (second < n) {
            String num1 = s.substring(pre_first + 1, first + 1);
            String num2 = s.substring(first + 1, second + 1);
            String next = stringAdd(num1, num2);

            int length = next.length();
            if (second == n - 1 && pre_first != -1) return true;
            if (second + length + 1 <= n && s.substring(second + 1, second + length + 1).equals(next)) {
                pre_first = first;
                first = second;
                second = second + length;
            } else {
                return false;
            }
        }
        return false;
    }

    //两个字符串相加
    public static String stringAdd(String str1, String str2) {
        if (str1.length() < str2.length())
            return stringAdd(str2, str1);

        int size1 = str1.length();
        int size2 = str2.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size1 - size2; i++) {
            sb.append('0');
        }
        str2 = sb + str2;

        StringBuilder result = new StringBuilder(str1);
        int sgn = 0;
        for (int i = size1 - 1; i >= 0; i--) {
            int num = str1.charAt(i) - '0' + str2.charAt(i) - '0' + sgn;
            result.setCharAt(i, (char) (num % 10 + '0'));
            sgn = num / 10;
        }
        return sgn == 1 ? "1" + result : new String(result);
    }

    public static void main(String[] args) {
       /* String num = "112358";
        System.out.println(isAdditiveNumber(num));*/
        System.out.println(isAdditiveNumber("99100199"));
    }

/*    public static boolean isAdditiveNumber(String num) {
        return dfs(num,0,1,2,3);
    }

    public static boolean dfs(String num,int first,int second,int third,int end){



        for(int i=first;i<num.length()-2;i++ ){
            first = i;
            for(int j=first+1 ;j<num.length()-1;j++){
                second = j;
                for(int k=second+1 ; k<num.length();k++){
                    third = k;
                    for(int last = third+1 ; last<num.length() + 1;last++){
                        end = last;
                        int a = Integer.parseInt(num.substring(first, second));
                        int b = Integer.parseInt(num.substring(second, third));
                        int c = Integer.parseInt(num.substring(third, end));
                        if(a+b==c){
                            if(end ==num.length()){
                                return true;
                            }
                           // dfs(num,first,second,third,end);
                        }
                    }
                }
            }
        }
        return false;

    }*/
}
