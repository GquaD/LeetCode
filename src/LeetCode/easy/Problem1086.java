package LeetCode.easy;

public class Problem1086 {
    //https://leetcode.com/problems/high-five
    public static void main(String[] args) {

    }

    //5min
    //Runtime
    //4
    //ms
    //Beats
    //93.91%
    //of users with Java
    //Memory
    //44.82
    //MB
    //Beats
    //35.13%
    //of users with Java
/*    int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = new TreeMap<>();
        for (int[] arr: items) {
            int id = arr[0], score = arr[1];
            PriorityQueue<Integer> pq = map.get(id);
            if (pq == null) {
                pq = new PriorityQueue<>((a, b) -> b - a);
                map.put(id, pq);
            }
            pq.offer(score);
        }
        int[][] res = new int[map.size()][2];
        int count = 0;
        for (int id: map.keySet()) {
            res[count][0] = id;

            int sum5 = 0, cc = 0;
            PriorityQueue<Integer> pq = map.get(id);

            while (cc < 5) {
                sum5 += pq.poll();
                cc++;
            }

            res[count++][1] = sum5 / 5;
        }
        return res;
    }*/
}
