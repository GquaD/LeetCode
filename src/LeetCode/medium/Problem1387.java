package LeetCode.medium;

import java.util.*;

public class Problem1387 {
    //https://leetcode.com/problems/sort-integers-by-the-power-value/
    public static void main(String[] args) {
        System.out.println(getKth(12, 15, 2));
        System.out.println(getKth(7, 11, 4));
    }

    //https://leetcode.com/problems/sort-integers-by-the-power-value/solutions/2667460/java-solution-explained/
    //20-25 mins
    //after making map static to save all such pairs for all test cases
    //Runtime
    //117 ms
    //Beats
    //39.42%
    //Memory
    //54 MB
    //Beats
    //57.53%

    static Map<Integer, Integer> powers = new HashMap<>();
    //10-15 mins
    //Runtime
    //135 ms
    //Beats
    //27.57%
    //Memory
    //61.6 MB
    //Beats
    //55.22%
    static int getKth(int lo, int hi, int k) {
        //Map<Integer, Integer> powers = new HashMap<>();
        List<Pair> list = new ArrayList<>();
        for (int i = lo; i <= hi; i++) {
            int x = i;
            int pow = 0;
            while (x > 1) {
                if (powers.containsKey(x)) {
                    pow += powers.get(x);
                    break;
                }
                if (x % 2 == 0) {
                    x /= 2;
                } else {
                    x = 3 * x + 1;
                }
                pow++;
            }
            if (!powers.containsKey(i)) {
                powers.put(i, pow);
            }
            list.add(new Pair(i, pow));
        }
        Collections.sort(list, Comparator.comparing(Pair::getPow).thenComparing(Pair::getNum));
        return list.get(k - 1).getNum();
    }

    static class Pair {
        int num;
        int pow;

        public Pair(int num, int pow) {
            this.num = num;
            this.pow = pow;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public int getPow() {
            return pow;
        }

        public void setPow(int pow) {
            this.pow = pow;
        }
    }
}
