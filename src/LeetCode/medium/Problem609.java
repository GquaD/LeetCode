package LeetCode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem609 {
    //https://leetcode.com/problems/find-duplicate-file-in-system/

    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-duplicate-file-in-system/discuss/2606169/Java-Solution-using-Map
    //15 mins
    //Runtime: 51 ms, faster than 66.24% of Java online submissions for Find Duplicate File in System.
    //Memory Usage: 71.5 MB, less than 33.71% of Java online submissions for Find Duplicate File in System.
    static List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < paths.length; i++) {
            String[] files = paths[i].split(" ");
            String dir = files[0];
            for (int j = 1; j < files.length; j++) {
                String file = files[j];
                String content = file.substring(file.indexOf('(') + 1, file.indexOf(')'));
                if (map.containsKey(content)) {
                    map.get(content).add(dir + "/" + file.substring(0, file.indexOf('(')));
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(dir + "/" + file.substring(0, file.indexOf('(')));
                    map.put(content, list);
                }
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (String key : map.keySet()) {
            List<String> list = map.get(key);
            if (list.size() > 1) {
                result.add(map.get(key));
            }
        }
        return result;
    }
}
