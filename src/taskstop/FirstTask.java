package taskstop;

import java.util.HashMap;
import java.util.Map;

public class FirstTask {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"test1a","test2","test1b","test1c","test3"}, new String[]{"W", "OK", "R", "OK", "Time"}));
        System.out.println(solution(new String[]{"codility1","codility3","codility2","codility4b","codility4a"}, new String[]{"W", "OK", "OK", "R", "OK"}));
    }

    //1
    static int solution(String[] T, String[] R) {
        // write your code in Java SE 8
        int len = T.length;
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            String current = T[i];
            int num = findNum(current);
            boolean isOK = R[i].equals("OK");
            if (map.containsKey(num)) {
                if (map.get(num)) {//if is OK
                    map.put(num, isOK);
                }
            } else {
                map.put(num, isOK);
            }
        }
        int countOK = 0;
        for (int key : map.keySet()) {
            if (map.get(key)) {
                countOK++;
            }
        }
        return (countOK * 100) / map.keySet().size();
    }

    private static int findNum(String current) {
        StringBuilder sb = new StringBuilder();
        for (char c : current.toCharArray()) {
            if (c >= '0' && c <= '9') {
                sb.append(c);
            }
        }
        return Integer.parseInt(sb.toString());
    }
}
