package LeetCode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem1376 {
    //https://leetcode.com/problems/time-needed-to-inform-all-employees/description/
    public static void main(String[] args) {
        System.out.println(numOfMinutes(6, 2, new int[]{2,2,-1,2,2,2}, new int[]{0,0,1,0,0,0}));
    }

    //nnnn
    //Runtime
    //134 ms
    //Beats
    //23.40%
    //Memory
    //61.2 MB
    //Beats
    //51.29%
    static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            int managerId = manager[i];
            if (!map.containsKey(managerId)) map.put(managerId, new ArrayList<>());
            map.get(managerId).add(i);
        }
        return dfs(map, informTime, headID);
    }

    private static int dfs(Map<Integer, List<Integer>> map, int[] informTime, int cur) {
        int max = 0;
        if (!map.containsKey(cur)) return max;
        List<Integer> list = map.get(cur);
        for (int i = 0; i < list.size(); i++) max = Math.max(max, dfs(map, informTime, list.get(i)));
        return max + informTime[cur];
    }

    //Memory Limit Exceeded
    //32 / 39
    static int numOfMinutes1(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, Employee> map = new HashMap<>();
        for (int i = 0; i < manager.length; i++) map.put(i, new Employee(i, manager[i], informTime[i]));
        Map<Integer, List<Employee>> mapSub = new HashMap<>();
        for (int i = 0; i < manager.length; i++)
            if (manager[i] >= 0) mapSub.computeIfAbsent(manager[i], ArrayList::new).add(map.get(i));
        for (int managerId : mapSub.keySet()) map.get(managerId).setSubordinates(mapSub.get(managerId));
        int arr[] = new int[]{0};
        dfsPrev(map.get(headID), 0, arr);
        return arr[0];
    }

    private static void dfsPrev(Employee e, int time, int[] arr) {
        if (e.getSubordinates().size() == 0) {
            arr[0] = Math.max(arr[0], time);
            return;
        }
        time += e.getInformTime();
        for (int i = 0; i < e.getSubordinates().size(); i++) {
            dfsPrev(e.getSubordinates().get(i), time, arr);
        }
    }

    static class Employee {
        int id, manager, informTime;
        List<Employee> subordinates;

        public Employee(int id, int manager, int informTime) {
            this.id = id;
            this.manager = manager;
            this.informTime = informTime;
            subordinates = new ArrayList<>();
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getManager() {
            return manager;
        }

        public void setManager(int manager) {
            this.manager = manager;
        }

        public int getInformTime() {
            return informTime;
        }

        public void setInformTime(int informTime) {
            this.informTime = informTime;
        }

        public List<Employee> getSubordinates() {
            return subordinates;
        }

        public void setSubordinates(List<Employee> subordinates) {
            this.subordinates = subordinates;
        }
    }
}
