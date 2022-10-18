package LeetCode.easy;

public class Problem476 {
    //https://leetcode.com/problems/number-complement/

    public static void main(String[] args) {
        System.out.println(findComplement(5));
        System.out.println(findComplement(1));
        System.out.println(findComplement(11));
    }


    //20 minutes
    //Runtime
    //2 ms
    //Beats
    //19.15%
    //Memory
    //41.1 MB
    //Beats
    //33.4%
    static int findComplement(int num) {
        String s = Integer.toBinaryString(num);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                sb.append('1');
            } else sb.append('0');
        }
        return Integer.parseUnsignedInt(sb.toString(), 2);
    }
}
