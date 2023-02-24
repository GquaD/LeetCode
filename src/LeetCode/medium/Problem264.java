package LeetCode.medium;

import java.util.*;

public class Problem264 {
    //https://leetcode.com/problems/ugly-number-ii/
    public static void main(String[] args) {
        /*setUgly = new TreeSet<>();
        setNotUgly = new TreeSet<>();
        for (int i = 1; i <= 100; i++) {
            System.out.println(i + " is ugly = " + isUgly(i));
        }*/
        System.out.println(nthUglyNumber(10));
        System.out.println(nthUglyNumber(1));
        System.out.println(nthUglyNumber(1690));
        System.out.println(nthUglyNumber(500));
    }

    //https://leetcode.com/problems/ugly-number-ii/solutions/3224147/java-2ms-99-faster-cached-solution/
    //40 - 50 min
    //Runtime
    //2 ms
    //Beats
    //98.64%
    //Memory
    //42.2 MB
    //Beats
    //23.77%
    static int[] ugly;

    static int nthUglyNumber(int n) {
        if (ugly == null) ugly = generateUglyNumbers();
        return ugly[n - 1];
    }

    private static int[] generateUglyNumbers() {
        int[] arr2 = new int[33], arr3 = new int[21], arr5 = new int[15];
        fillArrayWith(2, arr2);
        fillArrayWith(3, arr3);
        fillArrayWith(5, arr5);
        Set<Integer> set = new HashSet<>();
        long temp = 1;
        for (int i = 0; i < arr2.length; i++) {
            temp *= arr2[i];
            if (temp < Integer.MAX_VALUE) {
                set.add((int)temp);
            } else break;
            long temp3 = temp;
            for (int j = 0; j < arr3.length; j++) {
                temp3 *= arr3[j];
                if (temp3 < Integer.MAX_VALUE) {
                    set.add((int)temp3);
                } else break;
                long temp5 = temp3;
                for (int k = 0; k < arr5.length; k++) {
                    temp5 *= arr5[k];
                    if (temp5 < Integer.MAX_VALUE) {
                        set.add((int)temp5);
                    } else break;;
                }
            }
        }
        int[] res = new int[set.size()];
        int count = 0;
        for (int n : set) res[count++] = n;
        Arrays.sort(res);
        return res;
    }

    private static void fillArrayWith(int n, int[] arr2) {
        arr2[0] = 1;
        for (int i = 1; i < arr2.length; i++) arr2[i] = n;
    }

/*    static TreeSet<Integer> setNotUgly;
    static TreeSet<Integer> setUgly;
    static int nthUglyNumber(int n) {
        if (setUgly == null) setUgly = new TreeSet<>();
        if (setNotUgly == null) setNotUgly = new TreeSet<>();
        if (setUgly.size() >= n) {
            int count = 1;
            for (int num : setUgly) if (count++ == n) return num;
        }
        int start = setUgly.size() > 0 ? setUgly.last() : 1;
        while (setUgly.size() < n) isUgly(start++);
        return setUgly.last();
    }

    static boolean isUgly(int n) {
        int mem = n;
        while (n > 1) {
            if (n % 5 == 0) {
                n /= 5;
                if (setNotUgly.contains(n)) return false;
                if (setUgly.contains(n)) break;
            } else if (n % 3 == 0) {
                n /= 3;
                if (setNotUgly.contains(n)) return false;
                if (setUgly.contains(n)) break;
            } else if (n % 2 == 0){
                n /= 2;
                if (setNotUgly.contains(n)) return false;
                if (setUgly.contains(n)) break;
            } else {
                if (n != 1) setNotUgly.add(mem);
                return false;
            }
        }
        setUgly.add(mem);
        return true;
    }*/
}
