package LeetCode.medium;

public class Problem468 {
    //https://leetcode.com/problems/validate-ip-address
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/validate-ip-address/solutions/6273371/java-1ms-solution-by-tbekpro-7i90/
    //30min
    //Runtime
    //1
    //ms
    //Beats
    //93.73%
    //Analyze Complexity
    //Memory
    //41.53
    //MB
    //Beats
    //77.24%
    private String ipv4 = "IPv4", ipv6 = "IPv6", neither = "Neither";
    public String validIPAddress(String s) {
        if (s.contains(".") && s.contains(":")) return neither;

        boolean isv4 = s.contains(".");
        if (isv4) {
            if (s.length() < 7 || s.startsWith("\\.") || s.charAt(s.length() - 1) == '.') return neither;
            String[] split = s.split("\\.");
            if (split.length != 4) return neither;

            for (String t : split) {
                if (t.length() > 3 || t.length() == 0) return neither;
                if (t.length() > 1 && t.charAt(0) == '0') return neither;

                for (int i = 0; i < t.length(); i++) {
                    if (t.charAt(i) < '0' || t.charAt(i) > '9') return neither;
                }

                if (Integer.parseInt(t) > 255) return neither;
            }
            return ipv4;
        } else {
            if (s.length() < 15 || s.startsWith(":") || s.charAt(s.length() - 1) == ':') return neither;
            String[] split = s.split(":");
            if (split.length != 8) return neither;

            for (String t : split) {
                if (t.length() > 4 || t.length() == 0) return neither;
                t = t.toLowerCase();
                for (int i = 0; i < t.length(); i++) {
                    char c = t.charAt(i);
                    if (!(c >= '0' && c <= '9' || c >= 'a' && c <= 'f')) return neither;
                }
            }
            return ipv6;
        }
    }
}
