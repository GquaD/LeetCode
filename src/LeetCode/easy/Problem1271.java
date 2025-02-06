package LeetCode.easy;

public class Problem1271 {
    //https://leetcode.com/problems/hexspeak
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/hexspeak/solutions/6384966/my-hex-solution-by-tbekpro-6vgg/
    //Runtime
    //2
    //ms
    //Beats
    //73.53%
    //Analyze Complexity
    //Memory
    //41.92
    //MB
    //Beats
    //88.24%
    public String toHexspeak(String num) {
        String hex = toHex(Long.parseLong(num));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < hex.length(); i++) {
            char c = hex.charAt(i);
            if (c >= 'A' && c <= 'F') {
                sb.append(c);
            } else if (c == '0') {
                sb.append('O');
            } else if (c == '1') {
                sb.append('I');
            } else {
                return "ERROR";
            }
        }
        return sb.toString();
    }

    private String toHex(long n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(toSymbol((int)(n % 16L)));
            n /= 16L;
        }
        return sb.reverse().toString();
    }

    private char toSymbol(int n) {
        if (n >= 0 && n <= 9) return (char) ('0' + n);
        else return (char)('A' + n - 10);
    }
}
