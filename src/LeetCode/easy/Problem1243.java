package LeetCode.easy;

import java.util.ArrayList;
import java.util.List;

public class Problem1243 {
    //https://leetcode.com/problems/array-transformation
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/array-transformation/solutions/6389152/java-100-faster-solution-by-tbekpro-1dnn/
    //15min
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //41.58
    //MB
    //Beats
    //87.04%
    public List<Integer> transformArray(int[] arr) {
        int[] temp = new int[arr.length];
        changed(arr, temp);
        while (true) {
            for (int i = 1; i < arr.length - 1; i++) {
                int a = arr[i - 1], b = arr[i], c = arr[i + 1];
                if (b < a && b < c) {
                    temp[i]++;
                } else if (b > a && b > c){
                    temp[i]--;
                }
            }
            if (!changed(temp, arr)) break;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) list.add(arr[i]);
        return list;
    }

    private boolean changed(int[] arr, int[] temp) {
        boolean changed = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != temp[i]) {
                changed = true;
            }
            temp[i] = arr[i];
        }
        return changed;
    }
}
