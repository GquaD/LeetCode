package LeetCode.hard;

import java.util.*;

public class Problem1345 {
    //https://leetcode.com/problems/jump-game-iv/
    public static void main(String[] args) {
        System.out.println(minJumps(new int[]{-76, 3, 66, -32, 64, 2, -19, -8, -5, -93, 80, -5, -76, -78, 64, 2, 16}));
        System.out.println(minJumps(new int[]{7, 7, 2, 1, 7, 7, 7, 3, 4, 1}));
        System.out.println(minJumps(new int[]{11, 22, 7, 7, 7, 7, 7, 7, 7, 22, 13}));
        System.out.println(minJumps(new int[]{6, 1, 9}));
        System.out.println(minJumps(new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404}));
    }

    //nnnn
    //Runtime
    //68 ms
    //Beats
    //76.42%
    //Memory
    //54.5 MB
    //Beats
    //82.23%
    static int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 1) return 0;
        if (arr[0] == arr[arr.length - 1]) return 1;
        Map<Integer, List<Integer>> map = new HashMap<>();
        int jumps = 0;
        for (int i = 0; i < n; i++) map.computeIfAbsent(arr[i], list -> new ArrayList<>()).add(i);
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        while (!q.isEmpty()) {
            jumps++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int idx = q.poll(), left = idx - 1, right = idx + 1;
                if (left >= 0 && map.containsKey(arr[left])) {
                    q.offer(left);
                }

                if (right < n && map.containsKey(arr[right])) {
                    if (right == n - 1) return jumps;
                    q.offer(right);
                }

                if (map.containsKey(arr[idx])) {
                    for (int in : map.get(arr[idx])) {
                        if (in != idx) {
                            if (in == n - 1) return jumps;
                            q.offer(in);
                        }
                    }
                }
                map.remove(arr[idx]);
            }
        }
        return jumps;
    }

    static class Point {
        int num, idx;

        public Point(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }

    static int minJumps1(int[] arr) {
        if (arr.length == 1) return 0;
        if (arr[0] == arr[arr.length - 1]) return 1;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.get(arr[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(arr[i], list);
            }
        }
        if (map.size() == arr.length) return arr.length - 1;
        boolean[] visited = new boolean[arr.length];
        int[] count = new int[]{arr.length + 1};
        goRecursively(0, arr, map, count, 0, visited);
        return count[0];
    }

    private static void goRecursively(int idx, int[] arr, Map<Integer, List<Integer>> map, int[] count, int jumps, boolean[] visited) {
        if (idx == arr.length - 1) {
            if (count[0] > jumps) count[0] = jumps;
            return;
        }

        int num = arr[idx];
        visited[idx] = true;
        if (num == arr[arr.length - 1]) {
            goRecursively(arr.length - 1, arr, map, count, jumps + 1, visited);
            visited[idx] = false;
            return;
        }
        List<Integer> listIndices = map.get(num);
        if (listIndices.size() < 2) {
            if (idx - 1 >= 0 && !visited[idx - 1]) goRecursively(idx - 1, arr, map, count, jumps + 1, visited);
            if (idx + 1 <= arr.length - 1 && !visited[idx + 1])
                goRecursively(idx + 1, arr, map, count, jumps + 1, visited);
        } else {
            jumps++;
            for (int i : listIndices) {
                //if (i == idx) continue;
                if (i - 1 >= 0 && !visited[i - 1]) {
                    visited[i] = true;
                    goRecursively(i - 1, arr, map, count, jumps + 1, visited);
                }
                if (i + 1 <= arr.length - 1 && !visited[i + 1]) {
                    visited[i] = true;
                    goRecursively(i + 1, arr, map, count, jumps + 1, visited);
                }
            }
        }

    }


}
