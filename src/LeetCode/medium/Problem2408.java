package LeetCode.medium;
import java.util.*;

public class Problem2408 {
    //https://leetcode.com/problems/design-sql/
    public static void main(String[] args) {

    }


}
//https://leetcode.com/problems/design-sql/submissions/
//25min
//Runtime
//188
//ms
//Beats
//10.86%
//of users with Java
//Memory
//138.57
//MB
//Beats
//6.33%
//of users with Java
class SQL {
    Map<String, Map<Integer, List<String>>> map;
    public SQL(List<String> names, List<Integer> columns) {
        map = new HashMap<>();
        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            int n = columns.get(i);
            Map<Integer, List<String>> table = new HashMap<>();
            for (int j = 0; j < n; j++) {
                table.put(j, new ArrayList<>());
            }
            map.put(name, table);
        }
    }

    public void insertRow(String name, List<String> row) {
        Map<Integer, List<String>> table = map.get(name);
        for(int i = 0; i < row.size(); i++) {
            table.get(i).add(row.get(i));
        }
    }

    public void deleteRow(String name, int rowId) {
        int idx = rowId - 1;
        Map<Integer, List<String>> table = map.get(name);
        for (int n : table.keySet()) {
            table.get(n).set(idx, "#");
        }
    }

    public String selectCell(String name, int rowId, int columnId) {
        Map<Integer, List<String>> table = map.get(name);
        return table.get(columnId - 1).get(rowId - 1);
    }
}
