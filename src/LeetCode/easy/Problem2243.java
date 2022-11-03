package LeetCode.easy;

public class Problem2243 {
    //https://leetcode.com/problems/calculate-digit-sum-of-a-string/
    public static void main(String[] args) {
        System.out.println(digitSum("11111222223", 3));
        System.out.println(digitSum("00000000", 3));
        System.out.println(digitSum("346678678678485689", 4));
    }


    //https://leetcode.com/problems/calculate-digit-sum-of-a-string/solutions/2772459/java-100-faster-96-memory-solution/
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //40.4 MB
    //Beats
    //96.32%
    static String digitSum(String s, int k) {
        StringBuilder sb = new StringBuilder();
        String intermediate = s;
        int interInt = 0;
        while (intermediate.length() > k) {
            for (int i = 0; i < intermediate.length(); i += k) {
                for (int j = i; j < i + k && j < intermediate.length(); j++) {
                    interInt += intermediate.charAt(j) - '0';
                }
                sb.append(interInt);
                interInt = 0;
            }
            intermediate = sb.toString();
            sb.setLength(0);
        }
        return intermediate;
    }
}
