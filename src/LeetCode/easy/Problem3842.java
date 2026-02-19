package LeetCode.easy;

import java.util.List;

public class Problem3842 {
    //2min

    //Runtime
    //2
    //ms
    //Beats
    //99.98%
    //Analyze Complexity
    //Memory
    //46.70
    //MB
    //Beats
    //96.46%
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        boolean[] arr = new boolean[101];
        for (Integer b: bulbs) arr[b] = !arr[b];
        bulbs.clear();
        for (int i = 0; i < arr.length; i++) if (arr[i]) bulbs.add(i);
        return bulbs;
    }
}
