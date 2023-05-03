package LeetCode.medium;

import java.util.PriorityQueue;

public class Problem1845 {
    //https://leetcode.com/problems/seat-reservation-manager/
    public static void main(String[] args) {

    }


}
//https://leetcode.com/problems/seat-reservation-manager/solutions/3480298/java-96-faster-using-priorityqueue/
//5-10min
//Runtime
//42 ms
//Beats
//96.33%
//Memory
//74.4 MB
//Beats
//72.45%
class SeatManager {

    PriorityQueue<Integer> pq;
    int counter;
    public SeatManager(int n) {
        pq = new PriorityQueue<>();
        counter = 0;
    }

    public int reserve() {
        return !pq.isEmpty() ? pq.poll() : ++counter;
    }

    public void unreserve(int seatNumber) {
        pq.offer(seatNumber);
    }
}
