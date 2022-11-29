package LeetCode.easy;

public class Problem1694 {
    //https://leetcode.com/problems/reformat-phone-number/
    public static void main(String[] args) {
        System.out.println(reformatNumber("1-23-45 6"));
        System.out.println(reformatNumber("123 4-567"));
        System.out.println(reformatNumber("123 4-5678"));
        System.out.println(reformatNumber("0123 4-5678-9"));
    }

    //https://leetcode.com/problems/reformat-phone-number/solutions/2859024/java-2-ms-solution/
    //Runtime
    //2 ms
    //Beats
    //90.68%
    //Memory
    //42.5 MB
    //Beats
    //49.52%
    static String reformatNumber(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c <= '9' && c >= '0') sb.append(c);
        }
        String nums = sb.toString();
        sb.setLength(0);
        int groups = nums.length() / 3 - 1;
        int pos = groups * 3;
        if (nums.length() - pos == 5) {
            groups++;
            pos = groups * 3;
        }
        if (groups > 0) {
            for (int i = 0; i < groups; i++) {
                int idx = i * 3;
                sb.append(nums, idx, idx + 3).append('-');
            }
        }
        int last = nums.length() - pos;
        if (last != 4) {
            sb.append(nums, pos, nums.length());
        } else {
            sb.append(nums, pos, pos + 2)
                    .append('-')
                    .append(nums, pos + 2, nums.length());
        }
        return sb.toString();
    }
}
