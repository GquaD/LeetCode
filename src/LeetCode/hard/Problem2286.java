package LeetCode.hard;

public class Problem2286 {
    //https://leetcode.com/problems/booking-concert-tickets-in-groups/
    public static void main(String[] args) {

    }


}
//https://leetcode.com/problems/booking-concert-tickets-in-groups/solutions/3929064/java-o-n-memory-solution/
//15 - 20 min
//Runtime
//2244 ms
//Beats
//6.25%
//Memory
//79.1 MB
//Beats
//35.42%

class BookMyShow {

    int seatsInARow, arr[];
    long overallSeatsLeft;
    public BookMyShow(int n, int m) {
        arr = new int[n];
        seatsInARow = m;
        overallSeatsLeft = (long) m * n;
    }

    public int[] gather(int k, int maxRow) {
        if (k > seatsInARow) return new int[]{};
        for (int r = 0; r <= maxRow; r++) {
            if (seatsInARow - arr[r] >= k) {
                int[] res = new int[]{r, arr[r]};
                arr[r] += k;
                overallSeatsLeft -= k;
                return res;
            }
        }
        return new int[]{};
    }

    public boolean scatter(int k, int maxRow) {
        if (overallSeatsLeft >= k) {
            int sum = 0;
            for (int r = 0; r <= maxRow; r++) {
                sum += seatsInARow - arr[r];
                if (sum >= k) break;
            }
            if (sum >= k) {
                overallSeatsLeft -= k;
                for (int r = 0; r <= maxRow; r++) {
                    if (k == 0) break;
                    int left = seatsInARow - arr[r];
                    if (k >= left) {
                        k -= left;
                        arr[r] = seatsInARow;
                    } else {
                        arr[r] += k;
                        k = 0;
                    }
                }
                return true;
            } else {
                return false;
            }

        } else return false;
    }
}

class Row {
    int seatsBusy;
}
