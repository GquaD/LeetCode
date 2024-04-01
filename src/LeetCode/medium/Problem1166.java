package LeetCode.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem1166 {
    //https://leetcode.com/problems/design-file-system
    public static void main(String[] args) {

    }


}
//https://leetcode.com/problems/design-file-system/solutions/4957168/java-hashmap/
//5-10min
//Runtime
//84
//ms
//Beats
//73.10%
//of users with Java
//Memory
//55.36
//MB
//Beats
//76.18%
//of users with Java
class FileSystem {
    Map<String, Integer> map;
    public FileSystem() {
        map = new HashMap<>();
    }

    public boolean createPath(String path, int value) {
        if (map.containsKey(path)) return false;
        int idx = path.lastIndexOf('/');
        if (idx == -1) return false;
        if (idx == 0) {
            map.put(path, value);
        } else {
            String parent = path.substring(0, idx);
            if (map.containsKey(parent)) {
                map.put(path, value);
            } else {
                return false;
            }
        }
        return true;
    }

    public int get(String path) {
        Integer v = map.get(path);
        return v == null ? -1 : v.intValue();
    }
}
