package LeetCode.medium;

public class Problem702 {
    //https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/solutions/4757271/java-o-nlogn-solution/
    //15min
    //Runtime
    //2
    //ms
    //Beats
    //56.46%
    //of users with Java
    //Memory
    //46.12
    //MB
    //Beats
    //6.95%
    //of users with Java
/*    static int search(ArrayReader reader, int target) {
        int out = Integer.MAX_VALUE;
        int l = 0, r = 9999;
        if (reader.get(r) == target) return r;
        Set<Integer> visited = new HashSet<>();
        while (l <= r) {
            int mid = (l + r) / 2;

            if (visited.contains(mid)) break;
            visited.add(mid);

            int val = reader.get(mid);
            if (val == out) {
                r = mid;
                continue;
            }

            if (target == val) return mid;

            if (target < val) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return -1;
    }*/
}
