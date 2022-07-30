package LeetCode;

import java.util.List;

public class LeetCodeUtils {
    public static void printList(List list) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : list) {
            sb.append(obj + ", ");
        }
        String s = sb.toString();
        System.out.println(s.substring(0, s.length() - 2));
    }
}
