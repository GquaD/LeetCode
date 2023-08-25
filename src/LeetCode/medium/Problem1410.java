package LeetCode.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem1410 {
    //https://leetcode.com/problems/html-entity-parser/
    public static void main(String[] args) {
        System.out.println(entityParser("&amp; is an HTML entity but &ambassador; is not."));
        System.out.println(entityParser("and I quote: &quot;...&quot;"));
    }

    //https://leetcode.com/problems/html-entity-parser/solutions/3958604/java-straighforward-solution-using-stringbuilders-and-hashmap/
    //10-15min
    //Runtime
    //273 ms
    //Beats
    //15.29%
    //Memory
    //44 MB
    //Beats
    //96.47%
    static Map<String, String> map;

    static String entityParser(String text) {
        if (map == null) createAndFillMap();
        StringBuilder sb = new StringBuilder(), sbBuf = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (sbBuf.length() > 7) {
                sb.append(sbBuf.charAt(0));
                sbBuf.replace(0, 1, "");
            }
            for (String key : map.keySet()) {
                if (sbBuf.toString().contains(key)) {
                    sbBuf.replace(sbBuf.length() - key.length(), sbBuf.length(), map.get(key));
                    sb.append(sbBuf);
                    sbBuf.setLength(0);
                }
            }
            sbBuf.append(text.charAt(i));
        }
        if (sbBuf.length() > 7) {
            sb.append(sbBuf.charAt(0));
            sbBuf.replace(0, 1, "");
        }
        for (String key : map.keySet()) {
            if (sbBuf.toString().contains(key)) {
                sbBuf.replace(sbBuf.length() - key.length(), sbBuf.length(), map.get(key));
                sb.append(sbBuf);
                sbBuf.setLength(0);
            }
        }
        sb.append(sbBuf);

        return sb.toString();
    }

    private static void createAndFillMap() {
        map = new HashMap<>();
        map.put("&quot;", "\"");
        map.put("&apos;", "'");
        map.put("&amp;", "&");
        map.put("&gt;", ">");
        map.put("&lt;", "<");
        map.put("&frasl;", "/");
    }
}
