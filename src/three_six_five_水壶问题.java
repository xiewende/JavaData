import org.junit.Test;

/**
 * @author wjw
 * @date 2021/3/26 23:01
 */
public class three_six_five_水壶问题 {

    @Test
    public void test(){
        boolean res = canMeasureWater(0, 0, 1);
        System.out.println(res);
    }

    /**
     * 整个过程为：装满小桶，往大桶倒，直到倒满大桶，此时小桶剩下remain，把大桶清空，小桶把remain倒往大桶，如此重复
     *
     * 情况一：remain为需要的结果z(true)或者出现周期(false),结果在某一个桶中
     * 示例：5 3 4的小桶中：(0+3)%5=3, (3+3)%5=1, (1+3)%5=4 所以为true
     * 示例：6 2 4的小桶中：(0+2)%6=2, (2+2)%6=4, (4+2)%6=0 (0+2)%6=2, 因为2出现过，所以继续累加也只能2460循环，所以为false
     *
     * 情况二：remain+大桶容量=z：
     * 示例：13 11 20：(0+11)%13=11, (11+11)%13=9, (9+11)%13=7 清空大桶之前发现：此时大桶肯定满的13，加上小桶此时的remain为7恰好20
     */
    public boolean canMeasureWater(int x, int y, int z) {
        if(z == 0) return true;
        if(z > (x + y)) return false;
        int min = Math.min(x, y);
        int max = Math.max(x, y);

        boolean[] app = new boolean[max];

        int remain = 0;
        while(!app[remain]){
            app[remain] = true;
            remain = (remain + min) % max;
            if(remain == z || remain + max == z) return true;
        }
        return false;
    }
}
