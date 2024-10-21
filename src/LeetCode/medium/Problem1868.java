package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem1868 {
    //https://leetcode.com/problems/product-of-two-run-length-encoded-arrays
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/product-of-two-run-length-encoded-arrays/solutions/5946859/java-o-n-solution/
    //10-15min
    //Runtime
    //30
    //ms
    //Beats
    //65.73%
    //Analyze Complexity
    //Memory
    //105.41
    //MB
    //Beats
    //10.00%
    public List<List<Integer>> findRLEArray(int[][] e1, int[][] e2) {
        List<List<Integer>> res = new ArrayList<>();
        int idx = 0, val = 0, freq = 0;
        int idx2 = 0, val2 = 0, freq2 = 0;
        while (idx < e1.length || idx2 < e2.length) {
            if (freq == 0) {
                int[] arr = e1[idx++];
                val = arr[0];
                freq = arr[1];
            }
            if (freq2 == 0) {
                int[] arr = e2[idx2++];
                val2 = arr[0];
                freq2 = arr[1];
            }
            if (freq <= freq2) {
                int v = val * val2, f = freq;
                List<Integer> list1 = res.size() > 0 ? res.get(res.size() - 1) : null;
                if (list1 != null && list1.get(0) == v) {
                    list1.set(1, f + list1.get(1));
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(v);
                    list.add(f);
                    res.add(list);
                }
                freq2 -= f;
                freq = 0;
            } else {
                int v = val * val2, f = freq2;
                List<Integer> list1 = res.size() > 0 ? res.get(res.size() - 1) : null;
                if (list1 != null && list1.get(0) == v) {
                    list1.set(1, f + list1.get(1));
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(v);
                    list.add(f);
                    res.add(list);
                }
                freq -= freq2;
                freq2 = 0;
            }
        }
        if (freq <= freq2) {
            int v = val * val2, f = freq;
            List<Integer> list1 = res.size() > 0 ? res.get(res.size() - 1) : null;
            if (list1 != null && list1.get(0) == v) {
                list1.set(1, f + list1.get(1));
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(v);
                list.add(f);
                res.add(list);
            }
            freq2 -= f;
            freq = 0;
        } else {
            int v = val * val2, f = freq2;
            List<Integer> list1 = res.size() > 0 ? res.get(res.size() - 1) : null;
            if (list1 != null && list1.get(0) == v) {
                list1.set(1, f + list1.get(1));
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(v);
                list.add(f);
                res.add(list);
            }
            freq -= freq2;
            freq2 = 0;
        }

        return res;
    }
}
