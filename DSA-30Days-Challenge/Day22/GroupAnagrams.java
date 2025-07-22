import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        for (int i = 0; i < strs.length; i++) {

            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            if (!map.containsKey(sorted)) {
                List<String> newList = new ArrayList<String>();
                newList.add(strs[i]);
                map.put(sorted, newList);
            } else {
                map.get(sorted).add(strs[i]);
            }

        }

        List<List<String>> result = new ArrayList<List<String>>();

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        
        List<List<String>> result = groupAnagrams(strs);

        for (int i = 0; i < result.size(); i++) {
            List<String> group = result.get(i);
            System.out.println(group);
        }
    }
}
