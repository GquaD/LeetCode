package LeetCode.easy;

public class Problem3114 {
    //10min

    //Runtime
    //2
    //ms
    //Beats
    //22.22%
    //Memory
    //44.03
    //MB
    //Beats
    //65.93%
    //https://leetcode.com/problems/latest-time-you-can-obtain-after-replacing-characters/solutions/7831453/my-java-crazy-if-else-solution-by-tbekpr-fqtg/
    public String findLatestTime(String s) {
        StringBuilder sb = new StringBuilder();
        char h1 = s.charAt(0), h2 = s.charAt(1), m1 = s.charAt(3), m2 = s.charAt(4);
        if (h2 == '?') {
            if (h1 == '?') {
                sb.append(11);
            } else if (h1 == '0') {
                sb.append(h1);
                sb.append(9);
            } else {
                sb.append(11);
            }
        } else if (h1 == '?') {
            if (h2 <= '1') {
                sb.append(1);
            } else {
                sb.append(0);
            }
            sb.append(h2);
        } else {
            sb.append(h1);
            sb.append(h2);
        }
        sb.append(":");

        if (m2 == '?') {
            if (m1 == '?') {
                sb.append(59);
            } else {
                sb.append(m1);
                sb.append(9);
            }
        } else if (m1 == '?') {
            sb.append(5);
            sb.append(m2);
        } else {
            sb.append(m1);
            sb.append(m2);
        }

        return sb.toString();
    }
}
