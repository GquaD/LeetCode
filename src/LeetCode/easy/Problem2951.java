package LeetCode.easy;
import java.util.*;

public class Problem2951 {
    //https://leetcode.com/problems/find-the-peaks/
    public static void main(String[] args) {

    }


    //1min
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //of users with Java
    //Memory
    //44.00
    //MB
    //Beats
    //55.04%
    //of users with Java
    static List<Integer> findPeaks(int[] m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < m.length - 1; i++) {
            if (m[i - 1] < m[i] && m[i] > m[i + 1]) {
                list.add(i);
            }
        }
        return list;
    }
}
