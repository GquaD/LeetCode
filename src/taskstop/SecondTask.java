package taskstop;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SecondTask {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{7,3,7,3,1,3,4,1}));
        System.out.println(solution(new int[]{2,1,1,3,2,1,1,3}));
        System.out.println(solution(new int[]{7,5,2,7,2,7,4,7}));
    }

    //2
    static int solution(int[] A) {
        // write your code in Java SE 8
        Set<Integer> set = new HashSet<>();
        for (int n : A) {
            set.add(n);
        }
        if (set.size() == A.length) {
            return A.length;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            int indexCounter = i;
            List<Integer> list = new ArrayList<>();
            while (indexCounter < A.length) {
                list.add(A[indexCounter]);
                if (list.size() >= set.size() && list.containsAll(set)) {
                    if (min > list.size()) {
                        min = list.size();
                    }
                    break;
                }
                indexCounter++;
            }
            if (min == set.size()) return set.size();
        }
        return min;
    }
}
