package LeetCode.medium;

import java.util.*;

public class Problem2492 {
    //https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/description/
    public static void main(String[] args) {
        System.out.println(minScore(14, new int[][]{{2,9,2308},{2,5,2150},{12,3,4944},{13,5,5462},{2,10,2187},{2,12,8132},{2,13,3666},{4,14,3019},{2,4,6759},{2,14,9869},{1,10,8147},{3,4,7971},{9,13,8026},{5,12,9982},{10,9,6459}}));
    }

    //nnnn
    //Runtime
    //127 ms
    //Beats
    //23.38%
    //Memory
    //135.6 MB
    //Beats
    //7.56%
    static int minScore(int n, int[][] roads) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] arr : roads) {
            int start = arr[0], end = arr[1], distance = arr[2];
            map.computeIfAbsent(start, connection -> new HashMap<>()).put(end, distance);
            map.computeIfAbsent(end, connection -> new HashMap<>()).put(start, distance);
        }
        int minScore = 200_001;
        Set<Integer> visited = new HashSet<>();
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(1);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            Map<Integer, Integer> connect = map.get(curr);
            for (int key : connect.keySet()) {
                int score = connect.get(key);
                if (visited.add(key)) queue.offer(key);
                minScore = Math.min(score, minScore);
            }
        }
        return minScore;
    }

    static int minScore;
    static int overallNum;
    static int minScore2(int n, int[][] roads) {
        Map<Integer, List<Connection>> mapStart = new HashMap<>();
        Map<Integer, List<Connection>> mapEnd = new HashMap<>();
        //build maps with connections
        for (int[] arr : roads) {
            int start = arr[0], end = arr[1], distance = arr[2];
            if (mapStart.containsKey(start)) {
                mapStart.get(start).add(new Connection(start, end, distance));
            } else {
                List<Connection> list = new ArrayList<>();
                list.add(new Connection(start, end, distance));
                mapStart.put(start, list);
            }
            if (mapEnd.containsKey(end)) {
                mapEnd.get(end).add(new Connection(start, end, distance));
            } else {
                List<Connection> list = new ArrayList<>();
                list.add(new Connection(start, end, distance));
                mapEnd.put(end, list);
            }
        }
        minScore = 200_001;
        overallNum = n;
        goDFS(1, mapStart, mapEnd, new HashSet<>());
        return minScore;
    }

    private static void goDFS(int number, Map<Integer, List<Connection>> mapStart, Map<Integer, List<Connection>> mapEnd, Set<Connection> visited) {
        if (visited.size() == overallNum) return;
        Set<Connection> cityConnections = new HashSet<>();
        cityConnections.addAll(mapStart.getOrDefault(number, new ArrayList<>()));
        cityConnections.addAll(mapEnd.getOrDefault(number, new ArrayList<>()));

        for (Connection curr : cityConnections) {
            if (!visited.add(curr)) continue;
            if (minScore > curr.distance) minScore = curr.distance;
            goDFS(curr.start, mapStart, mapEnd, visited);
            goDFS(curr.end, mapStart, mapEnd, visited);
        }
    }

    //TLE
    static int minScore1(int n, int[][] roads) {
        Map<Integer, List<Connection>> mapStart = new HashMap<>();
        Map<Integer, List<Connection>> mapEnd = new HashMap<>();
        //build maps with connections
        for (int[] arr : roads) {
            int start = arr[0], end = arr[1], distance = arr[2];
            if (mapStart.containsKey(start)) {
                mapStart.get(start).add(new Connection(start, end, distance));
            } else {
                List<Connection> list = new ArrayList<>();
                list.add(new Connection(start, end, distance));
                mapStart.put(start, list);
            }
            if (mapEnd.containsKey(end)) {
                mapEnd.get(end).add(new Connection(start, end, distance));
            } else {
                List<Connection> list = new ArrayList<>();
                list.add(new Connection(start, end, distance));
                mapEnd.put(end, list);
            }
        }
        int minScore = 10_001;
        LinkedHashSet<Connection> queue = new LinkedHashSet<>();
        queue.addAll(mapStart.get(1));
        Map<Connection, Integer> mapVisited = new HashMap<>();
        Set<Connection> visited = new HashSet<>();
        int count = 0, threshold = n / 2;
        while (!queue.isEmpty()) {
            count++;
            Connection curr = queue.stream().findFirst().get();
            /*if (mapVisited.containsKey(curr)) {
                mapVisited.put(curr, mapVisited.get(curr) + 1);
            } else {
                mapVisited.put(curr, 1);
            }
            if (mapVisited.get(curr) > threshold) continue;*/
            if (!visited.add(curr)) {
                queue.remove(curr);
                continue;
            }
            queue.addAll(mapStart.getOrDefault(curr.start, new ArrayList<>()));
            queue.addAll(mapEnd.getOrDefault(curr.end, new ArrayList<>()));

            if (minScore > curr.distance) minScore = curr.distance;
            queue.remove(curr);
        }
        System.out.println("count = " + count);
        return minScore;
    }

    static class Connection {
        int start, end, distance;

        public Connection(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Connection that = (Connection) o;
            return start == that.start && end == that.end && distance == that.distance;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end, distance);
        }
    }
}
