package LeetCode.medium;

public class Problem869 {
    //https://leetcode.com/problems/reordered-power-of-2/
    public static void main(String[] args) {
        System.out.println(reorderedPowerOf2(1));
        System.out.println(reorderedPowerOf2(10));
        System.out.println(reorderedPowerOf2(812));
    }

    //https://leetcode.com/problems/reordered-power-of-2/solutions/2827694/java-100-faster-1-ms-solution-explained/
    //10-20 min
    //Runtime
    //1 ms
    //Beats
    //99.77%
    //Memory
    //40.7 MB
    //Beats
    //78.50%
    static byte[][] ocurr;

    static boolean reorderedPowerOf2(int n) {
        if (n == 1) return true;
        if (ocurr == null) {
            ocurr = fillOccurencesForEachPowerOf2();
        }

        byte[] freq = countFreqs(n);
        for (byte[] oc : ocurr) {
            if (areSame(oc, freq)) {
                return true;
            }
        }
        return false;
    }

    private static byte[][] fillOccurencesForEachPowerOf2() {
        byte[][] res = new byte[30][10];
        for (int i = 0; i < res.length; i++) {
            int pow = (int) Math.pow(2, i);
            res[i] = countFreqs(pow);
        }
        return res;
    }

    private static byte[] countFreqs(int pow) {
        byte[] freq = new byte[10];
        while (pow > 0) {
            int digit = pow % 10;
            freq[digit]++;
            pow /= 10;
        }
        return freq;
    }

    private static boolean areSame(byte[] oc, byte[] freq) {
        for (int i = 0; i < oc.length; i++) {
            if (oc[i] != freq[i]) return false;
        }
        return true;
    }
}
