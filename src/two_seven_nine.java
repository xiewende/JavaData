import java.util.LinkedList;
import java.util.Queue;

/**
 * @create 2019-09-25  19:50  完全平方数
 */
public class two_seven_nine {

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }

    public static int numSquares(int n) {
        Queue<mynum> q = new LinkedList<>();
        q.offer(new mynum(n, 0));
        boolean visited[] = new boolean[n + 1];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        visited[n] = true;

        while (!q.isEmpty()) {
            mynum my = q.peek();
            q.poll();
            int num = my.getN();
            int step = my.getStep();
            for (int i = 1; ; i++) {
                int a = num - i * i;
                if (a < 0) {
                    break;
                }
                if (a == 0) {
                    return step + 1;
                }
                if (!visited[a]) {
                    q.offer(new mynum(a, step + 1));
                    visited[a] = true;
                }
            }
        }
        return 0;
    }
}

class mynum {
    int n;
    int step;

    mynum(int n, int step) {
        this.n = n;
        this.step = step;
    }

    public int getStep() {
        return step;
    }

    public int getN() {
        return n;
    }
}

