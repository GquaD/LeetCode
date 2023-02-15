package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem71 {
    //https://leetcode.com/problems/simplify-path/discussion/
    public static void main(String[] args) {
        System.out.println(simplifyPath("a/b//c///d"));
        System.out.println(simplifyPath("/home/"));
        System.out.println(simplifyPath("/a/./b/../../c/"));
        System.out.println(simplifyPath("/a/.."));
        System.out.println(simplifyPath("/a/../"));
        System.out.println(simplifyPath("/../../../../../a"));
        System.out.println(simplifyPath("/a/./b/./c/./d/"));
        System.out.println(simplifyPath("/a/../.././../../."));
        System.out.println(simplifyPath("/a//b//c//////d"));
    }

    //https://leetcode.com/problems/simplify-path/solutions/3187875/java-99-time-99-memory-solution/
    //15 min
    //Runtime
    //3 ms
    //Beats
    //98.51%
    //Memory
    //41.8 MB
    //Beats
    //99.96%
    static String simplifyPath(String path) {
        String[] split = path.trim().split("/");
        StringBuilder sb = new StringBuilder();
        List<String> pathRes = new ArrayList<>();
        for (String s : split) {
            if (s.isEmpty()) continue;
            if (s.equals("..")) {
                if (pathRes.size() > 0)
                    pathRes.remove(pathRes.size() - 1);
                if (pathRes.size() > 0)
                    pathRes.remove(pathRes.size() - 1);
            } else if (!s.equals(".")) {
                pathRes.add("/");
                pathRes.add(s);
            }
        }
        for (String s : pathRes)
            sb.append(s);
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
