import java.util.stream.IntStream;

/**
 * @create 2021-01-20  22:22
 */
public class thread {

    // 类的成员变量
    static int data = 0;

    public static void main(String[] args) {

        IntStream.range(0, 2).forEach((i) -> {
            new Thread(() -> {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                IntStream.range(0, 100).forEach(y -> {
                    data++;
                });
            }).start();
        });

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(data);
    }

}


