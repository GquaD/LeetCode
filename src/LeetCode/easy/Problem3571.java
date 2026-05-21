package LeetCode.easy;

public class Problem3571 {
    //15min

    //Runtime
    //4
    //ms
    //Beats
    //50.00%
    //Memory
    //46.80
    //MB
    //Beats
    //25.00%
    //https://leetcode.com/problems/find-the-shortest-superstring-ii/solutions/8227899/java-solution-by-tbekpro-dn43/
    public String shortestSuperstring(String a, String b) {
        //1 contains each other
        //a ending is b's start
        //b's ending is a's start
        //concat both

        if (a.contains(b)) return a;
        if (b.contains(a)) return b;
        int len = 0, ken = 0;
        for (int i = 1; i < Math.min(a.length(), b.length()); i++) {
            String s = a.substring(Math.max(0, a.length() - i), a.length()), t = b.substring(0, i);
            if (s.equals(t)) len = i;
        }

        for (int i = 1; i < Math.min(a.length(), b.length()); i++) {
            String s = b.substring(Math.max(0,b.length() - i), b.length()), t = a.substring(0, i);
            if (s.equals(t)) ken = i;
        }
        if (len > 0 || ken > 0) {
            return len >= ken ? a.substring(0, a.length() - len) + b : b.substring(0, b.length() - ken) + a;
        }

        return a + b;
    }
}
