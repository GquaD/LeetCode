package LeetCode.medium;

import java.util.Arrays;

public class Problem2358 {
    //https://leetcode.com/problems/maximum-number-of-groups-entering-a-competition/
    public static void main(String[] args) {
        System.out.println(maximumGroups(new int[]{10,6,12,7,3,5}));
        System.out.println(maximumGroups(new int[]{8,8}));
        System.out.println(maximumGroups(new int[]{8,8,8,8,8,8,8}));
    }

    //https://leetcode.com/problems/maximum-number-of-groups-entering-a-competition/solutions/3531324/java-2-solutions-100-faster-o-g/
    //5 min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //51 MB
    //Beats
    //48.37%
    static int maximumGroups(int[] grades) {
        int count = 0, sum = 0, group = 0;
        while (sum + count + 1 <= grades.length) {
            sum += ++count;
            group++;
        }
        return group;
    }

    //10 min
    //Runtime
    //27 ms
    //Beats
    //24.19%
    //Memory
    //51 MB
    //Beats
    //60.47%
    static int maximumGroups1(int[] grades) {
        Arrays.sort(grades);
        int count = 0, size = 1, countGroup = 0;
        for (int i = 0; i < grades.length; i++) {
            countGroup++;
            if (countGroup == size) {
                size++;
                countGroup = 0;
                count++;
            }
        }
        return count;
    }
}
