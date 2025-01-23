package LeetCode.medium;

import java.util.Arrays;

public class Problem2491 {
    //https://leetcode.com/problems/divide-players-into-teams-of-equal-skill/description/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/divide-players-into-teams-of-equal-skill/solutions/6319074/java-onlogn-solution-by-tbekpro-wyqk/
    //5-10min
    //Runtime
    //17
    //ms
    //Beats
    //43.60%
    //Analyze Complexity
    //Memory
    //58.06
    //MB
    //Beats
    //26.00%
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int len = skill.length, t = skill[0] + skill[len - 1];
        long res = skill[0] * skill[len - 1];
        boolean allEqual = true;
        for (int i = 1; i < len / 2; i++) {
            if (skill[i] + skill[len - i - 1] != t) {
                allEqual = false;
                break;
            }
            res += skill[i] * 1L * skill[len - i - 1];
        }
        if (!allEqual) return -1;
        return res;
    }
}
