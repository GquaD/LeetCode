package LeetCode.medium;
import java.util.List;
import java.util.ArrayList;

public class Problem1756 {
    //https://leetcode.com/problems/design-most-recently-used-queue/
    public static void main(String[] args) {

    }


}
//https://leetcode.com/problems/design-most-recently-used-queue/solutions/4706361/java-using-arraylist/
//5min
//Runtime
//15
//ms
//Beats
//92.50%
//of users with Java
//Memory
//45.89
//MB
//Beats
//34.00%
//of users with Java
class MRUQueue {
    private List<Integer> list;
    public MRUQueue(int n) {
        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) list.add(i);
    }

    public int fetch(int k) {
        int t = list.remove(k);
        list.add(t);
        return t;
    }
}
