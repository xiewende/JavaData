package utils;

/**
 * @author wjw
 * @date 2021/3/15 0:10
 */
public class ArrayUtil {

    public static void showArray(int[][] array2D){
        System.out.println("[");
        for (int i = 0; i < array2D.length; i++) {
            for (int j = 0; j < array2D[0].length; j++) {
                System.out.print(array2D[i][j] + ",");
            }
            System.out.println();
        }
        System.out.println("]");
    }

    public static void showArray(double[][] array2D){
        System.out.println("[");
        for (int i = 0; i < array2D.length; i++) {
            for (int j = 0; j < array2D[0].length; j++) {
                System.out.print(array2D[i][j] + ",");
            }
            System.out.println();
        }
        System.out.println("]");
    }
}
