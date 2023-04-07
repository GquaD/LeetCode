package LeetCode.hard;

import java.util.*;

public class Problem1944 {
    //https://leetcode.com/problems/number-of-visible-people-in-a-queue/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(canSeePersonsCount(new int[]{10,6,8,5,11,9})));
        System.out.println(Arrays.toString(canSeePersonsCount(new int[]{5,1,2,3,10})));
        System.out.println(Arrays.toString(canSeePersonsCount(new int[]{1})));
    }

    //todo
    //nnn
    //Runtime
    //150 ms
    //Beats
    //17.27%
    //Memory
    //61.7 MB
    //Beats
    //51.25%
    static int[] canSeePersonsCount(int[] heights) {
        int n = heights.length, arr[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] <= heights[i]) arr[stack.pop()]++;
            if (!stack.isEmpty()) arr[stack.peek()]++;
            stack.add(i);
        }
        return arr;
    }

    static int[] canSeePersonsCount1(int[] heights) {
        List<Pair> listCur = new ArrayList<>();
        Set<Pair> res = new TreeSet<>(Comparator.comparing(pair -> pair.getIdx()));
        listCur.add(new Pair(0, heights[0], 0));
        for (int i = 1; i < heights.length; i++) {
            int h = heights[i], size = listCur.size();
            for (int j = 0; j < size; j++) {
                Pair p = listCur.get(j);
                p.amount++;
                if (p.val < h) {
                    res.add(p);
                    listCur.remove(j);
                    j--;
                    size--;
                }
            }

            Pair pair = new Pair(i, heights[i], 0);
            listCur.add(pair);
        }
        for (Pair p : listCur) {
            res.add(p);;
        }
        int idx = 0;
        for (Pair p : res) {
            heights[idx++] = p.amount;
        }
        return heights;
    }

    static class Pair {
        int idx, val, amount;

        public Pair() {
        }

        public Pair(int idx, int val, int amount) {
            this.idx = idx;
            this.val = val;
            this.amount = amount;
        }

        public int getIdx() {
            return idx;
        }
    }
}
