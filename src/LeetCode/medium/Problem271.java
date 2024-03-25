package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem271 {
    //https://leetcode.com/problems/encode-and-decode-strings/
    public static void main(String[] args) {

    }


}
//https://leetcode.com/problems/encode-and-decode-strings/solutions/4923689/java-straightforward-solution/
//15min
//Runtime
//8
//ms
//Beats
//53.27%
//of users with Java
//Memory
//44.95
//MB
//Beats
//97.07%
//of users with Java
class Codec {
    char c;
    StringBuilder sb;
    List<String> list;

    public Codec() {
        sb = new StringBuilder();
        c = (char) 256;
        list = new ArrayList<>();
    }

    public String encode(List<String> strs) {
        sb.setLength(0);
        for(String s : strs) {
            if (s.length() == 0) {
                sb.append("EmpSTR").append(c);
            } else {
                sb.append(s).append(c);
            }

        }
        return sb.substring(0, sb.length() - 1);
    }

    public List<String> decode(String s) {
        String[] arr = s.split(c + "");
        list.clear();
        for (String t : arr) {
            if (t.equals("EmpSTR")) list.add("");
            else list.add(t);
        }
        return list;
    }
}
