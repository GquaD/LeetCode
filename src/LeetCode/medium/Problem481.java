package LeetCode.medium;

public class Problem481 {
    //https://leetcode.com/problems/magical-string/description/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/magical-string/solutions/5920295/java-solution/
    //Runtime
    //91
    //ms
    //Beats
    //8.56%
    //Analyze Complexity
    //Memory
    //44.74
    //MB
    //Beats
    //17.90%
    /*
    * class Solution {
    private String s = "";

    public int magicalString(int n) {
        if (s.isEmpty()) generateString();
        int count = 0;
        for (int i = 0; i < n; i++) if (s.charAt(i) == '1') count++;
        return count;
    }

    private void generateString() {
        StringBuilder sb = new StringBuilder();
        sb.append(122);
        int idx = 2;
        char cur = '2', last = '2';
        while (sb.length() < 100_000) {
            cur = sb.charAt(idx++);
            last = sb.charAt(sb.length() - 1);
            if (cur == '2') {
                if (last == '2') {
                    sb.append(11);
                } else {
                    sb.append(22);
                }
            } else {
                if (last == '2') {
                    sb.append(1);
                } else {
                    sb.append(2);
                }
            }
        }
        s = sb.toString();
    }
}*/

    //
    //20min
    //Runtime
    //102
    //ms
    //Beats
    //8.56%
    //Analyze Complexity
    //Memory
    //44.48
    //MB
    //Beats
    //27.24%
    private String s = "";
    int[] arr = new int[100_000];

    public int magicalString(int n) {
        if (s.isEmpty()) {
            generateString();
            fillArray();
        }
        return arr[n - 1];
    }

    private void fillArray() {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (s.charAt(i) == '1') count++;
            arr[i] = count;
        }
    }

    private void generateString() {
        StringBuilder sb = new StringBuilder();
        sb.append(122);
        int idx = 2;
        char cur = '2', last = '2';
        while (sb.length() < 100_000) {
            cur = sb.charAt(idx++);
            last = sb.charAt(sb.length() - 1);
            if (cur == '2') {
                if (last == '2') {
                    sb.append(11);
                } else {
                    sb.append(22);
                }
            } else {
                if (last == '2') {
                    sb.append(1);
                } else {
                    sb.append(2);
                }
            }
        }
        s = sb.toString();
    }
}
