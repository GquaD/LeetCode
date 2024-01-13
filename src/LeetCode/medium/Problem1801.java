package LeetCode.medium;
import java.util.*;

public class Problem1801 {
    //https://leetcode.com/problems/number-of-orders-in-the-backlog/
    public static void main(String[] args) {
        System.out.println(getNumberOfBacklogOrders(new int[][]{{7,1000000000,1},{15,3,0},{5,999999995,0},{5,1,1}}));
    }

    //https://leetcode.com/problems/number-of-orders-in-the-backlog/solutions/4559367/java-o-nlogn/
    //30-40min
    //Runtime
    //54
    //ms
    //Beats
    //25.42%
    //of users with Java
    //Memory
    //84.71
    //MB
    //Beats
    //16.95%
    //of users with Java
    static int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<Order> pqb = new PriorityQueue<>((a, b) -> b.price - a.price);
        PriorityQueue<Order> pqs = new PriorityQueue<>((a, b) -> a.price - b.price);

        for (int[] o: orders) {
            Order curr = new Order(o[0], o[1]);

            if (o[2] == 0) {
                //buy
                while (!pqs.isEmpty()) {
                    Order s = pqs.poll();
                    if (curr.price >= s.price) {
                        int diff = curr.amount - s.amount;
                        if (diff > 0) {
                            curr.amount = diff;
                        } else {
                            s.amount -= curr.amount;
                            pqs.offer(s);
                            curr.amount = 0;
                            break;
                        }
                    } else {
                        pqs.offer(s);
                        break;
                    }
                }
                if (curr.amount > 0) pqb.offer(curr);
            } else {
                //sell
                while (!pqb.isEmpty()) {
                    Order b = pqb.poll();
                    if (b.price >= curr.price) {
                        int diff = curr.amount - b.amount;
                        if (diff > 0) {
                            curr.amount = diff;
                        } else {
                            b.amount -= curr.amount;
                            pqb.offer(b);
                            curr.amount = 0;
                            break;
                        }
                    } else {
                        pqb.offer(b);
                        break;
                    }
                }
                if (curr.amount > 0) pqs.offer(curr);
            }
        }

        long sum = 0L;
        while (!pqs.isEmpty()) {
            sum += pqs.poll().amount;
        }

        while (!pqb.isEmpty()) {
            sum += pqb.poll().amount;
        }

        return (int)(sum % 1_000_000_007L);
    }
}

class Order {
    int price, amount;

    public Order(int p, int a) {
        price = p;
        amount = a;
    }
}
