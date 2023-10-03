package LeetCode.medium;

public class Problem1545 {
    //https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/
    public static void main(String[] args) {
        System.out.println(findKthBit(3, 1));
    }

    //
    //20-25 min
    //Runtime
    //15 ms
    //Beats
    //54.62%
    //Memory
    //45.3 MB
    //Beats
    //54.10%
    static String[] arr;

    static char findKthBit(int n, int k) {
        if (arr == null) generateArray();
        return arr[n].charAt(k - 1);
    }

    private static void generateArray() {
        arr = new String[21];
        arr[1] = "0";
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < arr.length; i++) {
            String s = invert(arr[i - 1]);
            s = sb.append(s).reverse().toString();
            sb.setLength(0);
            sb.append(arr[i - 1])
                    .append("1")
                    .append(s);
            arr[i] = sb.toString();
            sb.setLength(0);
        }
    }

    private static String invert(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') sb.append('1');
            else sb.append('0');
        }
        return sb.toString();
    }
}
