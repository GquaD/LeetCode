package LeetCode.easy;

import java.util.ArrayList;
import java.util.List;

public class Problem4078 {
    //10min
    //Runtime
    //2
    //ms
    //Beats
    //12.61%
    //Memory
    //42.01
    //MB
    //Beats
    //94.40%
    private static List<Integer> fib = generateFib();

    public boolean threeFibonacciSum(int n) {
        int sum = fib.get(0) + fib.get(1) + fib.get(2), idx = 2;
        while (sum <= n) {
            if (sum == n)
                return true;

            sum += -fib.get(idx - 2) + fib.get(idx + 1);
            idx++;
        }

        return false;
    }

    private static List<Integer> generateFib() {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);

        while (list.get(list.size() - 1) < 500_000_000) {
            int size = list.size(), sum = list.get(size - 1) + list.get(size - 2);
            list.add(sum);
        }

        return list;
    }
}
