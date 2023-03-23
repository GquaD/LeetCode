package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem1319 {
    //https://leetcode.com/problems/number-of-operations-to-make-network-connected/description/
    public static void main(String[] args) {
        //13
        System.out.println(makeConnected(100, new int[][]{{17, 51}, {33, 83}, {53, 62}, {25, 34}, {35, 90}, {29, 41}, {14, 53}, {40, 84}, {41, 64}, {13, 68}, {44, 85}, {57, 58}, {50, 74}, {20, 69}, {15, 62}, {25, 88}, {4, 56}, {37, 39}, {30, 62}, {69, 79}, {33, 85}, {24, 83}, {35, 77}, {2, 73}, {6, 28}, {46, 98}, {11, 82}, {29, 72}, {67, 71}, {12, 49}, {42, 56}, {56, 65}, {40, 70}, {24, 64}, {29, 51}, {20, 27}, {45, 88}, {58, 92}, {60, 99}, {33, 46}, {19, 69}, {33, 89}, {54, 82}, {16, 50}, {35, 73}, {19, 45}, {19, 72}, {1, 79}, {27, 80}, {22, 41}, {52, 61}, {50, 85}, {27, 45}, {4, 84}, {11, 96}, {0, 99}, {29, 94}, {9, 19}, {66, 99}, {20, 39}, {16, 85}, {12, 27}, {16, 67}, {61, 80}, {67, 83}, {16, 17}, {24, 27}, {16, 25}, {41, 79}, {51, 95}, {46, 47}, {27, 51}, {31, 44}, {0, 69}, {61, 63}, {33, 95}, {17, 88}, {70, 87}, {40, 42}, {21, 42}, {67, 77}, {33, 65}, {3, 25}, {39, 83}, {34, 40}, {15, 79}, {30, 90}, {58, 95}, {45, 56}, {37, 48}, {24, 91}, {31, 93}, {83, 90}, {17, 86}, {61, 65}, {15, 48}, {34, 56}, {12, 26}, {39, 98}, {1, 48}, {21, 76}, {72, 96}, {30, 69}, {46, 80}, {6, 29}, {29, 81}, {22, 77}, {85, 90}, {79, 83}, {6, 26}, {33, 57}, {3, 65}, {63, 84}, {77, 94}, {26, 90}, {64, 77}, {0, 3}, {27, 97}, {66, 89}, {18, 77}, {27, 43}}));

    }

    //nnnn
    //Runtime
    //15 ms
    //Beats
    //49.84%
    //Memory
    //58.5 MB
    //Beats
    //77.71%
    static int makeConnected(int n, int[][] connections) {
        if (n - 1 > connections.length) return -1;
        List<List<Integer>> listAdj = new ArrayList<>();
        for (int i = 0; i < n; i++) listAdj.add(new ArrayList<>());
        for (int[] conn : connections) {
            listAdj.get(conn[0]).add(conn[1]);
            listAdj.get(conn[1]).add(conn[0]);
        }
        boolean[] visited = new boolean[n];
        int groups = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                groups++;
                goDFS(listAdj, i, visited);
            }
        }
        return groups - 1;
    }

    private static void goDFS(List<List<Integer>> listAdj, int computer, boolean[] visited) {
        if (visited[computer]) return;
        visited[computer] = true;
        for (int pc : listAdj.get(computer)) goDFS(listAdj, pc, visited);
    }

    //I need to find the number of separate groups and connect them
    //i.e. it means if the number of groups is K, then I need to make K - 1 connections
    //fails on 25/36
    static int makeConnected1(int n, int[][] connections) {
        if (n - 1 > connections.length) return -1;
        int[] arr = new int[n];
        for (int[] conn : connections) {
            int a = conn[0], b = conn[1];
            arr[a]++;
            arr[b]++;
        }
        int count = 0;
        for (int incoming : arr) if (incoming == 0) count++;
        return count;
    }
}
