package LeetCode.easy;

public class Problem868 {
    //https://leetcode.com/problems/binary-gap/
    public static void main(String[] args) {
        System.out.println(binaryGap(22));
        System.out.println(binaryGap(8));
        System.out.println(binaryGap(1));
        System.out.println(binaryGap(100000));
    }

    //https://leetcode.com/problems/binary-gap/solutions/2913701/java-1-ms-solution/
    //15 min
    //Runtime
    //1 ms
    //Beats
    //88.32%
    //Memory
    //39.2 MB
    //Beats
    //88.59%
    static int binaryGap(int n) {
        String bin = Integer.toBinaryString(n);
        int idx = 0, max = -1;
        for (int i = 0; i < bin.length(); i++) {
            char c = bin.charAt(i);
            if (c == '1') {
                int cur = i - idx;
                if (max < cur) {
                    max = cur;
                }
                idx = i;
            }
        }
        return max;
    }
}
