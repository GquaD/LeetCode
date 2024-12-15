package LeetCode.medium;

import java.util.PriorityQueue;

public class Problem2548 {
    //https://leetcode.com/problems/maximum-price-to-fill-a-bag
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/maximum-price-to-fill-a-bag/solutions/6149331/java-heap-solution-by-tbekpro-6osq/
    //10min
    //Runtime
    //169
    //ms
    //Beats
    //11.11%
    //Analyze Complexity
    //Memory
    //78.66
    //MB
    //Beats
    //77.78%
    public double maxPrice(int[][] items, int cap) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> b.coef - a.coef == 0 ? 0 : b.coef - a.coef > 0 ? 1 : -1);
        for (int[] arr: items) pq.offer(new Tuple(arr[0] * 1.0 / arr[1], arr[0], arr[1]));
        double res = 0.0;
        while (pq.size() > 0) {
            Tuple t = pq.poll();
            if (t.weight <= cap) {
                cap -= t.weight;
                res += t.price;
            } else {
                res += (t.price * 1.0 / t.weight) * cap;
                cap = 0;
            }

            if (cap <= 0)
                break;
        }
        return cap > 0 ? -1 : res;
    }

    class Tuple {
        double coef;
        int price, weight;

        public Tuple(double c, int p, int w) {
            coef = c;
            price = p;
            weight = w;
        }
    }
}
