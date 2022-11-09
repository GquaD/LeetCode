package LeetCode.easy;

import java.util.Arrays;

public class Problem2138 {
    //https://leetcode.com/problems/divide-a-string-into-groups-of-size-k/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(divideString("abcdeefghi", 3, 'x')));
        System.out.println(Arrays.toString(divideString("abcdefghi", 3, 'x')));
    }

    //
    //20-25 mins
    //Runtime
    //2 ms
    //Beats
    //88.61%
    //Memory
    //43.3 MB
    //Beats
    //43.51%
    static String[] divideString(String s, int k, char fill) {
        String[] r = new String[(int) Math.ceil((s.length() * 1.0) / k)];
        int idx;
        if (s.length() % k != 0) {
            idx = s.length() - (s.length() % k);
        } else {
            idx = s.length();
        }
        for (int i = 0; i < idx; i+=k) {
            r[i / k] = s.substring(i, i + k);
        }
        if (s.length() % k != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.substring(idx));
            for (int i = sb.length(); i < k; i++) {
                sb.append(fill);
            }
            r[r.length - 1] = sb.toString();
        }
        return r;
    }
}
