package LeetCode.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem690 {
    //https://leetcode.com/problems/employee-importance/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/employee-importance/solutions/3704773/java-dfs-100-faster-using-array-of-employees-as-a-map-2-solutions/
    //10-15 min
    //Runtime
    //3 ms
    //Beats
    //100%
    //Memory
    //45.3 MB
    //Beats
    //18.4%
    static Employee[] arr = new Employee[2001];
    static int getImportance(List<Employee> employees, int id) {
        res = 0;
        Employee e = employees.get(0);
        for (int i = 0; i < employees.size(); i++) {
            Employee emp = employees.get(i);
            arr[emp.id] = emp;
        }
        goDFS(arr[id], arr);
        return res;
    }

    private static void goDFS(Employee e, Employee[] arr) {
        if (e == null) return;
        res += e.importance;

        for (int i = 0; i < e.subordinates.size(); i++) {
            goDFS(arr[e.subordinates.get(i)], arr);
        }
    }

    //10-15 min
    //Runtime
    //4 ms
    //Beats
    //99.4%
    //Memory
    //44.9 MB
    //Beats
    //64.88%
    static int res;
    static int getImportance1(List<Employee> employees, int id) {
        res = 0;
        Employee e = employees.get(0);
        Map<Integer, Employee> map = new HashMap<>();
        for (int i = 0; i < employees.size(); i++) map.put(employees.get(i).id, employees.get(i));
        goDFS(map.get(id), map);
        return res;
    }

    private static void goDFS(Employee e, Map<Integer, Employee> map) {
        if (e == null) return;
        res += e.importance;

        for (int i = 0; i < e.subordinates.size(); i++) {
            goDFS(map.get(e.subordinates.get(i)), map);
        }
    }
}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}
