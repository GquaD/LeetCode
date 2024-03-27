package LeetCode.easy;

import java.util.HashSet;
import java.util.Set;

public class Problem379 {
    //https://leetcode.com/problems/design-phone-directory/
    public static void main(String[] args) {

    }

}
//https://leetcode.com/problems/design-phone-directory/solutions/4932812/java-2-hashsets/
//10-15min
//Runtime
//20
//ms
//Beats
//14.52%
//of users with Java
//Memory
//49.88
//MB
//Beats
//25.27%
//of users with Java
class PhoneDirectory {
    Set<Integer> set1, set2;
    int n;
    public PhoneDirectory(int maxNumbers) {
        n = maxNumbers;
        set1 = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set1.add(i);
        }
        set2 = new HashSet<>();
    }

    public int get() {
        if (set1.isEmpty()) return -1;
        int temp = -1;
        for (int k : set1) {
            temp = k;
            break;
        }
        set1.remove(temp);
        set2.add(temp);
        return temp;
    }

    public boolean check(int number) {
        return set1.contains(number);
    }

    public void release(int number) {
        set2.remove(number);
        set1.add(number);
    }
}
