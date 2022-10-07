package LeetCode.medium;

import java.util.*;

public class Problem841 {
    //https://leetcode.com/problems/keys-and-rooms/
    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> zero = new ArrayList<>();
        zero.add(1);
        zero.add(3);
        rooms.add(zero);

        List<Integer> one = new ArrayList<>();
        one.add(3);
        one.add(0);
        one.add(1);
        rooms.add(one);

        List<Integer> two = new ArrayList<>();
        two.add(2);
        rooms.add(two);

        List<Integer> three = new ArrayList<>();
        rooms.add(three);
        System.out.println(canVisitAllRooms(rooms));
    }

    //https://leetcode.com/problems/keys-and-rooms/solutions/2671189/java-recursive-solution-97-faster/
    //took 1 hour, since I wanted to try solution other than recursion
    //but I thought about recursion in the beginning
    //Runtime
    //1 ms
    //Beats
    //97.15%
    //Memory
    //44.4 MB
    //Beats
    //66.63%
    static boolean[] visited;
    static List<List<Integer>> allRooms;

    static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        allRooms = rooms;
        visited = new boolean[rooms.size()];
        goInRecursively(0, rooms.get(0));
        return allVisited();
    }
    private static void goInRecursively(int room, List<Integer> keys) {
        if (visited[room]) return;

        visited[room] = true;
        for (int i = 0; i < keys.size(); i++) {
            int key = keys.get(i);
            goInRecursively(key, allRooms.get(key));
        }

    }

    private static boolean allVisited() {
        for (int i = 0; i < visited.length / 2; i++) {
            if (!visited[i] || !visited[visited.length - 1 - i])
                return false;
        }
        return true;
    }

    static boolean canVisitAllRooms1(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        Map<Integer, List<Integer>> map = new LinkedHashMap<>();
        int count = 0;
        for (List<Integer> list : rooms) {
            map.put(count++, list);
        }
        Set<Integer> visitedNew = new HashSet<>(visited);
        boolean added = true;
        while (added) {
            for (int n : visited) {
                added = false;
                List<Integer> room = map.get(n);
                if (room != null) {
                    added = true;
                    visitedNew.addAll(room);
                }
            }
            visited.addAll(visitedNew);
        }

        return visited.containsAll(map.keySet());
    }

    //can be solved by recursion as well
    static boolean canVisitAllRooms2(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        for (int i = 0; i < rooms.size(); i++) {
            List<Integer> keys = rooms.get(i);
            for (int j = 0; j < keys.size(); j++) {
                visited[keys.get(j)] = true;
            }
        }
        return allVisited();
    }
}
