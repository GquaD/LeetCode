package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem670 {
    //https://leetcode.com/problems/maximum-swap
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/maximum-swap/solutions/5924724/java-1ms-solution/
    //15min
    //Runtime
    //1
    //ms
    //Beats
    //30.39%
    //Analyze Complexity
    //Memory
    //40.48
    //MB
    //Beats
    //39.97%
    public int maximumSwap(int num) {
        List<Integer> list = new ArrayList<>();
        int t = num;
        while (t > 0) {
            list.add(t % 10);
            t /= 10;
        }
        //reverse
        for (int i = 0; i < list.size() / 2; i++) {
            int idx = list.size() - i - 1, n = list.get(i), o = list.get(idx);
            list.set(i, o);
            list.set(idx, n);
        }
        //max so far
        int max = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            max = Math.max(list.get(i), max);
            list.set(i, max);
        }
        List<Integer> list1 = new ArrayList<>();
        t = num;
        while (t > 0) {
            list1.add(t % 10);
            t /= 10;
        }

        for (int i = 0; i < list1.size() / 2; i++) {
            int idx = list1.size() - i - 1, n = list1.get(i), o = list1.get(idx);
            list1.set(i, o);
            list1.set(idx, n);
        }

        int x = 0, y = 0, idx = -1;
        for (int i = 0; i < list.size(); i++) {
            int a = list1.get(i), b = list.get(i);
            if (a < b) {
                x = a;
                y = b;
                idx = i;
                break;
            }
        }
        if (idx == -1) return num;
        list1.set(idx, y);
        for (int i = list1.size() - 1; i > idx; i--) {
            if (list1.get(i) == y) {
                list1.set(i, x);
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int n : list1) sb.append(n);
        return Integer.parseInt(sb.toString());
    }
}
