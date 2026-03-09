package LeetCode.easy;

import java.util.*;

public class Problem2094 {
    //15min

    //Runtime
    //24
    //ms
    //Beats
    //53.30%
    //Memory
    //46.80
    //MB
    //Beats
    //62.38%
    public int[] findEvenNumbers(int[] digits) {
        int[] arr = new int[10];
        for (int digit : digits)
            arr[digit]++;
        List<Integer> list = new ArrayList<>();
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                for (int j = 0; j < Math.min(3, arr[i]); j++) list.add(i);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            int one = list.get(i);
            if (one == 0)
                continue;
            for (int j = 0; j < list.size(); j++) {
                if (j == i)
                    continue;
                int two = list.get(j);
                for (int k = 0; k < list.size(); k++) {
                    if (k == j || k == i)
                        continue;
                    int three = list.get(k);
                    if (three % 2 == 0) {
                        result.add(one * 100 + two * 10 + three);
                    }
                }
            }
        }

        int[] res = new int[result.size()];
        int i = 0;
        for (int n: result) {
            res[i++] = n;
        }
        Arrays.sort(res);
        return res;
    }
}
