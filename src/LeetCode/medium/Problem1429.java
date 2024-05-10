package LeetCode.medium;
import java.util.*;

public class Problem1429 {
    //https://leetcode.com/problems/first-unique-number/
    public static void main(String[] args) {

    }


}
//https://leetcode.com/problems/first-unique-number/solutions/5139281/java-using-sets/
//40-50min
//Runtime
//111
//ms
//Beats
//81.65%
//of users with Java
//Memory
//85.81
//MB
//Beats
//46.76%
//of users with Java
class FirstUnique {
    LinkedList<Integer> list;
    Set<Integer> set;
    LinkedHashSet<Integer> setL;

    public FirstUnique(int[] nums) {
        list = new LinkedList<>();
        set = new HashSet<>();
        setL = new LinkedHashSet<>();
        for (int n : nums) {
            add(n);
        }
    }

    public int showFirstUnique() {
        while (list.size() > 0) {
            int cur = list.getFirst();
            if (set.contains(cur)) {
                list.removeFirst();
            } else {
                return cur;
            }
        }
        return -1;
    }

    public void add(int value) {
        if (!setL.contains(value)) {
            list.add(value);
            setL.add(value);
        } else {
            set.add(value);
        }
    }
}
