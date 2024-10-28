package LeetCode.easy;

import java.util.HashSet;
import java.util.Set;

public class Problem1064 {
    //https://leetcode.com/problems/fixed-point
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/fixed-point/solutions/5978203/java-o-logn-solution/
    //2min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //44.83
    //MB
    //Beats
    //8.88%
    public int fixedPoint(int[] arr) {
        int l = 0, r = arr.length - 1;
        int mem = r;
        Set<Integer> set = new HashSet<>();
        while (l <= r) {
            int mid = (l + r) / 2;
            if (set.contains(mid)) break;
            set.add(mid);
            if (arr[mid] == mid) {
                mem = mid;
                r = mid;
            } else if (arr[mid] > mid) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return arr[mem] == mem ? mem : -1;
    }
}
