package LeetCode.medium;

public class Problem831 {
    //https://leetcode.com/problems/masking-personal-information/
    public static void main(String[] args) {
        System.out.println(maskPII("LeetCode@LeetCode.com").equals("l*****e@leetcode.com"));
        System.out.println(maskPII("AB@qq.com").equals("a*****b@qq.com"));
        System.out.println(maskPII("1(234)567-890")/*.equals("***-***-7890")*/);
    }

    //https://leetcode.com/problems/masking-personal-information/solutions/5193491/java-straightforward-solution/
    //10min
    //Runtime
    //1
    //ms
    //Beats
    //87.74%
    //of users with Java
    //Memory
    //41.50
    //MB
    //Beats
    //71.70%
    //of users with Java
    static String maskPII(String s) {
        StringBuilder sb = new StringBuilder();
        if (s.contains("@")) {
            int a = s.indexOf('@');
            s = s.toLowerCase();
            sb.append(s.charAt(0))
                    .append("*****")
                    .append(s.substring(a - 1));
            return sb.toString();
        } else {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) sb.append(c);
            }
            s = sb.reverse().toString();
            sb.setLength(0);

            sb.append(s.substring(0, 4))
                    .append("-")
                    .append("***")
                    .append("-")
                    .append("***");
            if (s.length() > 10) {
                int diff = s.length() - 10;

                sb.append("-");
                for (int i = 0; i < diff; i++) {
                    sb.append("*");
                }
                sb.append("+");
            }
            return sb.reverse().toString();
        }
    }
}
