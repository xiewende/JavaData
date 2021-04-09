package str;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @create 2020-04-11  23:33
 */
public class four_nine_异步相同 {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map=new HashMap<>();
        for(String s:strs){
            char[] ch=s.toCharArray();
            Arrays.sort(ch);
            String key=String.valueOf(ch);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }
}
