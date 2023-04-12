package LeetCode.medium;

import java.util.HashSet;
import java.util.Set;

public class Problem752 {
    //https://leetcode.com/problems/open-the-lock/
    public static void main(String[] args) {
        System.out.println(openLock(new String[]{"0201","0101","0102","1212","2002"}, "0202"));
        System.out.println(openLock(new String[]{"8888"}, "0009"));
    }

    static int openLock(String[] deadends, String target) {
        StringBuilder sb = new StringBuilder();
        sb.append("0000");
        return 42;
    }

    static int openLock1(String[] deadends, String target) {
        Set<String> setBan = new HashSet<>();
        for (String s : deadends) setBan.add(s);
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < 10; i++) {
            if (i != 0) count++;
            for (int j = 0; j < 10; j++) {
                if (j != 0) count++;
                for (int k = 0; k < 10; k++) {
                    if (k != 0) count++;
                    for (int l = 0; l < 10; l++) {
                        if (l != 0) count++;
                        sb.append(i).append(j).append(k).append(l);
                        if (!setBan.contains(sb.toString()) && target.equals(sb.toString())) return count;
                        sb.setLength(0);
                    }
                }
            }
        }
        return -1;
    }
}
