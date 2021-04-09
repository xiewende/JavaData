/**
 * @author wjw
 * @date 2020/2/17 21:22
 */
package 回溯;


import java.util.ArrayList;
import java.util.List;

/**
 * Set去重，不要用什么ArrayList.contains
 */
public class one_zero_seven_nine_活字印刷术 {


    int num;
    List<String> list = new ArrayList<>();

    public int numTilePossibilities(String tiles) {
        if (tiles.length() == 0) {
            return 0;
        }
        StringBuilder sbTile = new StringBuilder(tiles);
        backTrace(sbTile, new StringBuilder());
        return num;
    }

    public void backTrace(StringBuilder tiles, StringBuilder sb) {
        if (sb.length() > 0) {
            String str = sb.toString();
            if (!list.contains(str)) {
                list.add(str);
                num++;
            }
        }

        if (tiles.length() == 0) {
            return;
        }

        for (int i = 0; i < tiles.length(); i++) {
            char ch = tiles.charAt(i);
            sb.append(ch);
            StringBuilder sb1 = new StringBuilder(tiles);
            backTrace(tiles.delete(i, i + 1), sb);
            tiles = sb1;
            sb.delete(sb.length() - 1, sb.length());
        }
    }
}
