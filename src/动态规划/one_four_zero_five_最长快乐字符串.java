package 动态规划;

import org.junit.Test;

import java.util.Arrays;

/**
 * @create 2021-02-27  15:28
 */
public class one_four_zero_five_最长快乐字符串 {

    @Test
    public void test(){
        int a = 1;
        int b= 1;
        int c = 7;
        String s = longestDiverseString(a, b, c);
        System.out.println(s);
    }


    public String longestDiverseString(int a, int b, int c) {
        Stu tem[] = new Stu[3];
        tem[0] = new Stu('a',a);
        tem[1] = new Stu('b',b);
        tem[2] = new Stu('c',c);
        StringBuilder sb = new StringBuilder();
        while (true){
            Arrays.sort(tem);
            //先放最多的, 如果上个放的2个字符串和剩余个数最多的字符相同，则放置次多的字符
            if (sb.length() >= 2 &&
                    sb.charAt(sb.length() - 1) == tem[2].name &&
                    sb.charAt(sb.length() - 2) == tem[2].name) {
                if (tem[1].num-- > 0) {
                    sb.append(tem[1].name);
                } else {
                    break;
                }
            } else {
                if (tem[2].num-- > 0) {
                    sb.append(tem[2].name);
                } else {
                    break;
                }
            }

        }
        return sb.toString();
    }
}
class Stu implements Comparable{
    public Integer num;
    public char name;
    public Stu(char name, Integer num) {
            this.name = name;
            this.num = num;
            }
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        // MyChar other = (MyChar)o;
        Stu s = (Stu) o;
        return this.num - s.num;
    }
}
