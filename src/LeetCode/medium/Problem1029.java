package LeetCode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem1029 {
    //https://leetcode.com/problems/two-city-scheduling/
    public static void main(String[] args) {
        System.out.println(twoCitySchedCost(new int[][]{{259, 770}, {448, 54}, {926, 667}, {184, 139}, {840, 118}, {577, 469}}));
    }

    //https://leetcode.com/problems/two-city-scheduling/solutions/3590426/java-o-nlogn-solution/
    //read the explanation half nnnn
    //Runtime
    //2 ms
    //Beats
    //61.38%
    //Memory
    //41.2 MB
    //Beats
    //30.26%
    static int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (o1, o2) -> (o1[1] - o1[0]) - (o2[1] - o2[0]));
        int n = costs.length / 2, count = 0, sum = 0;
        for (int[] arr : costs) sum += count++ < n ? arr[1] : arr[0];
        return sum;
    }

    //Runtime
    //2 ms
    //Beats
    //61.38%
    //Memory
    //40.6 MB
    //Beats
    //79.64%
    static int twoCitySchedCost1(int[][] costs) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[1] - o1[0]) - (o2[1] - o2[0]));
        for (int[] arr : costs) pq.offer(arr);
        int n = costs.length / 2, count = 0, sum = 0;
        while (!pq.isEmpty()) sum += count++ < n ? pq.poll()[1] : pq.poll()[0];
        return sum;
    }
}
