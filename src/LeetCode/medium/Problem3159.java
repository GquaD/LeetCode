package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem3159 {
    //https://leetcode.com/problems/find-occurrences-of-an-element-in-an-array/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-occurrences-of-an-element-in-an-array/solutions/5211335/java-100-faster-o-n-solution/
    //3min
    //Runtime
    //5
    //ms
    //Beats
    //100.00%
    //of users with Java
    //Memory
    //61.64
    //MB
    //Beats
    //100.00%
    //of users with Java
    static int[] occurrencesOfElement(int[] nums, int[] q, int x) {
        List<Integer> listx = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x)
                listx.add(i);
        }
        for (int i = 0; i < q.length; i++) {
            int occ = q[i];
            if (occ > listx.size()) {
                q[i] = -1;
            } else {
                q[i] = listx.get(occ - 1);
            }
        }
        return q;
    }
}
