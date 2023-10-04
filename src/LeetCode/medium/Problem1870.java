package LeetCode.medium;

public class Problem1870 {
    //https://leetcode.com/problems/minimum-speed-to-arrive-on-time/
    public static void main(String[] args) {
        System.out.println(minSpeedOnTime(new int[]{1,3,2}, 2.1));
        System.out.println(minSpeedOnTime(new int[]{1,3,2}, 2.7));
        System.out.println(minSpeedOnTime(new int[]{1,3,2}, 1.9));
        System.out.println(minSpeedOnTime(new int[]{1,3,2}, 6));
    }


    ///cccc
    //I almost got the solution
    //Runtime
    //159 ms
    //Beats
    //15.12%
    //Memory
    //58.5 MB
    //Beats
    //92.13%

    static int minSpeedOnTime(int[] dist, double hour) {
        int l = 1, r = 1_000_000_000, res = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            double sum = 0;
            for (int i = 0; i < dist.length - 1; i++) sum += Math.ceil((1.0 * dist[i]) / mid);
            sum += (1.0 * dist[dist.length - 1]) / mid;
            if (sum > hour) {
                l = mid + 1;
            } else {
                res = mid;
                r = mid - 1;
            }
        }
        return res;
    }


    //32/66
    static int minSpeedOnTime1(int[] dist, double hour) {
        long sum = 0;
        for (int n : dist) sum += n;
        if (sum <= hour) return 1;
        int l = 1, r = 1_000_000_000, mid, res = -1;
        double temp = r;
        while (l < r) {
            mid = (l + r) / 2;
            double s = 0;
            for (int i = 0; i < dist.length - 1; i++) {
                if (s > hour) {
                    l = mid;
                    break;
                }
                s += Math.ceil((1.0 * dist[i]) / mid);
            }
            s += (1.0 * dist[dist.length - 1]) / mid;

            if (s > hour) {
                if (l == mid) break;
                l = mid;
            } else if (s < hour) {
                if (r == mid) break;
                r = mid;
            } else {
                res = mid;
                break;
            }

            if (hour > s && hour - s < temp) {
                temp = hour - s;
                res = mid;
            }
        }
        return res;
    }
}
