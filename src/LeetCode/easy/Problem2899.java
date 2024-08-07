package LeetCode.easy;

import java.util.ArrayList;
import java.util.List;

public class Problem2899 {
    //https://leetcode.com/problems/last-visited-integers/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/last-visited-integers/solutions/5602184/java-100-faster-solution/
    //10min
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //44.98
    //MB
    //Beats
    //5.29%
    public List<Integer> lastVisitedIntegers(int[] nums) {
        List<Integer> seen = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int negOne = 0;
        for (int n: nums) {
            if (n > 0) {
                seen.add(n);
                negOne = 0;
            } else {
                negOne++;
                if (negOne <= seen.size()) {
                    ans.add(seen.get(seen.size() - negOne));
                } else {
                    ans.add(-1);
                }
            }
        }
        return ans;
    }
}
