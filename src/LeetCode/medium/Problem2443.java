package LeetCode.medium;

public class Problem2443 {
    //https://leetcode.com/problems/sum-of-number-and-its-reverse/
    public static void main(String[] args) {
        System.out.println(sumOfNumberAndReverse(100000));
        System.out.println(sumOfNumberAndReverse(443));
    }

    //https://leetcode.com/problems/sum-of-number-and-its-reverse/solutions/3981011/java-straightforward-solution/
    //10 min
    //Runtime
    //537 ms
    //Beats
    //27.62%
    //Memory
    //43.2 MB
    //Beats
    //29.28%
    static boolean sumOfNumberAndReverse(int num) {
        for (int i = 0; i <= num; i++) {
            String a = (num - i) + "", b = i + "";
            int lenMax = Math.max(a.length(), b.length());
            while (a.length() < lenMax) a = "0" + a;
            while (b.length() < lenMax) b = "0" + b;
            int count = 0;
            for (int j = 0; j < lenMax; j++) if (a.charAt(j) == b.charAt(lenMax - 1 - j)) count++;
            if (count == lenMax) return true;
        }
        return false;
    }

    //Runtime
    //733 ms
    //Beats
    //22.65%
    //Memory
    //39.8 MB
    //Beats
    //46.41%
    static boolean sumOfNumberAndReverse1(int num) {
        StringBuilder a = new StringBuilder(), b = new StringBuilder();
        for (int i = 0; i <= num; i++) {
            a.append(i);
            b.append(num - i);
            int lenMax = Math.max(a.length(), b.length());
            if (a.length() < lenMax) {
                a.reverse();
                int len = a.length();
                for (int j = 0; j < lenMax - len; j++) a.append("0");
                a.reverse();
            }
            if (b.length() < lenMax) {
                b.reverse();
                int len = b.length();
                for (int j = 0; j < lenMax - len; j++) b.append("0");
                b.reverse();
            }
            int count = 0;
            for (int j = 0; j < lenMax; j++) if (a.charAt(j) == b.charAt(lenMax - 1 - j)) count++;
            if (count == lenMax) return true;
            a.setLength(0);
            b.setLength(0);
        }
        return false;
    }


}
