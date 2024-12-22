package LeetCode.medium;

public class Problem1428 {
    //https://leetcode.com/problems/leftmost-column-with-at-least-a-one/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/leftmost-column-with-at-least-a-one/solutions/6174174/java-100-faster-solution-by-tbekpro-g2if/
    //15-20min
    //Runtime
    //2
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //44.91
    //MB
    //Beats
    //42.17%
    //public int leftMostColumnWithOne(BinaryMatrix mat) {
    //        List<Integer> dim = mat.dimensions();
    //        int rows = dim.get(0), cols = dim.get(1);
    //        int minIdx = 101;
    //        Set<Integer> visited = new HashSet<>();
    //        int count1 = 0;
    //        for (int r = 0; r < rows; r++) {
    //            int left = 0, right = cols - 1;
    //            while (left <= right) {
    //                int mid = (left + right) / 2;
    //                if (visited.contains(mid)) {
    //                    left++;
    //                    continue;
    //                }
    //                visited.add(mid);
    //                if (mat.get(r, mid) == 1) {
    //                    right = mid;
    //                    count1++;
    //                } else {
    //                    left = mid;
    //                }
    //            }
    //            visited.clear();
    //            minIdx = Math.min(minIdx, count1 > 0 ? right : 101);
    //        }
    //        return minIdx == 101 ? -1 : minIdx;
    //    }
}
