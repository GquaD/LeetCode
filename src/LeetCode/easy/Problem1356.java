package LeetCode.easy;

import java.util.*;

public class Problem1356 {
    //https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortByBits(new int[]{0,1,2,3,4,5,6,7,8})));
        System.out.println(Arrays.toString(sortByBits(new int[]{1024,512,256,128,64,32,16,8,4,2,1})));
    }

    //https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/solutions/2829454/java-o-n-solution-treemap/
    //5-10 min
    //Runtime
    //8 ms
    //Beats
    //78.97%
    //Memory
    //42.5 MB
    //Beats
    //91.70%
    static int[] sortByBits(int[] arr) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        for (int n: arr) {
            int bit = Integer.bitCount(n);
            if (map.containsKey(bit)) {
                map.get(bit).add(n);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(n);
                map.put(bit, list);
            }
        }
        int i = 0;
        for (int key : map.keySet()) {
            List<Integer> list = map.get(key);
            Collections.sort(list);
            for (int n : list) {
                arr[i++] = n;
            }
        }
        return arr;
    }


    static int[] sortByBits1(int[] arr) {
        Pair[] pairs = new Pair[arr.length];
        for (int i = 0; i < arr.length; i++) {
            Pair p = new Pair(arr[i], Integer.bitCount(arr[i]));
        }
        Arrays.sort(pairs);
        return null;
    }

    static class Pair implements Comparator{
        int num;
        int freq;

        public Pair(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public int getFreq() {
            return freq;
        }

        public void setFreq(int freq) {
            this.freq = freq;
        }

        @Override
        public int compare(Object o1, Object o2) {
            return ((Pair)o1).freq - ((Pair)o2).freq;
        }
    }


}
