package LeetCode.medium;
import java.util.*;

public class Problem1762 {
    //https://leetcode.com/problems/buildings-with-an-ocean-view
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/buildings-with-an-ocean-view/solutions/4747485/java-o-n-solution/
    //5min
    //Runtime
    //6
    //ms
    //Beats
    //55.79%
    //of users with Java
    //Memory
    //61.40
    //MB
    //Beats
    //24.26%
    //of users with Java
    static int[] findBuildings(int[] h) {
        List<Integer> list = new ArrayList<>();
        int prevMax = 0;
        for (int i = h.length - 1; i >= 0; i--) {
            if (h[i] > prevMax) {
                list.add(i);
                prevMax = h[i];
            }
        }
        Collections.sort(list);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
