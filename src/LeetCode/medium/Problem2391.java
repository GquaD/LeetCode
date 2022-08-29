package LeetCode.medium;

import jdk.nashorn.internal.ir.IfNode;

public class Problem2391 {
    //https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage/
    public static void main(String[] args) {
        System.out.println(garbageCollection(new String[]{"G", "P", "GP", "GG"}, new int[]{2, 4, 3}));
        System.out.println(garbageCollection(new String[]{"MMM", "PGM", "GP"}, new int[]{3, 10}));
    }

    //Runtime: 339 ms, faster than 33.33% of Java online submissions for Minimum Amount of Time to Collect Garbage.
    //Memory Usage: 240.7 MB, less than 33.33% of Java online submissions for Minimum Amount of Time to Collect Garbage.
    static int garbageCollection(String[] garbage, int[] travel) {
        int timeOverall = 0;
        String[] letters = new String[]{"P", "G", "M"};
        boolean[] contain = new boolean[]{false, false, false};
        int countForTravel = travel.length - 1;
        for (int i = 0; i < letters.length; i++) {
            for (int j = garbage.length - 1; j >= 0; j--) {
                String g = garbage[j];
                if (g.contains(letters[i])) {
                    if (!contain[i]) {
                        contain[i] = true;
                    }
                    for (int k = 0; k < g.length(); k++) {
                        if ((g.charAt(k) + "").equals(letters[i])) {
                            timeOverall++;
                        }
                    }
                }
                if (countForTravel >= 0 && contain[i]) {
                    timeOverall += travel[countForTravel];
                }
                countForTravel--;
            }
            countForTravel = travel.length - 1;
        }
        return timeOverall;
    }
    //first two houses may contain glass, but next three houses may not, so only after second house glass collection is finished
}
