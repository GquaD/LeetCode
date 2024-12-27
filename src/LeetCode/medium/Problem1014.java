package LeetCode.medium;

public class Problem1014 {
    //https://leetcode.com/problems/best-sightseeing-pair/
    public static void main(String[] args) {
        System.out.println(maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6}));
    }


    //https://leetcode.com/problems/best-sightseeing-pair/solutions/6194190/java-interesting-solution-by-tbekpro-pb8k/
    //20min
    //Runtime
    //1145
    //ms
    //Beats
    //5.13%
    //Analyze Complexity
    //Memory
    //53.40
    //MB
    //Beats
    //61.35%
    //public int maxScoreSightseeingPair(int[] v) {
    //        if (v.length == 2) return v[0] + v[1] - 1;
    //        int max = 0, idx = -1, poss = 1999;
    //
    //        for (int i = 0; i < v.length; i++) {
    //            for (int l = Math.max(i - 1000, 0); l < Math.min(v.length, i + 1000); l++) {
    //                if (l == i) continue;
    //                if (l < i) {
    //                    max = Math.max(max, v[l] + v[i] + l - i);
    //                } else {
    //                    max = Math.max(max, v[l] + v[i] + i - l);
    //                }
    //                if (max == poss)
    //                    return poss;
    //            }
    //        }
    //        return max;
    //    }
    static int maxScoreSightseeingPair(int[] v) {
        if (v.length == 2) return v[0] + v[1] - 1;
        int[] arr1 = new int[]{v.length}, arr2 = new int[]{v.length};
        for (int i = 0; i < v.length; i++) {
            arr1[i] = v[i] + i;
            arr2[i] = v[i] - i;
        }
        int max1 = 0, idx1 = -1;
        for (int i = 0; i < arr1.length; i++) {
            if (max1 < arr1[i]) {

            }
        }
        return 42;
    }

    //Wrong Answer
    //39 / 54
    static int maxScoreSightseeingPair1(int[] v) {
        if (v.length == 2) return v[0] + v[1] - 1;
        int max = 0, idx = -1;
        for (int i = 0; i < v.length; i++) {
            if (max < v[i]) {
                max = v[i];
                idx = i;
            }
        }
        int res = 0;
        for (int i = 0; i < v.length; i++) {
            if (i == idx) continue;
            res = idx < i ? Math.max(max + v[i] + idx - i, res) : Math.max(max + v[i] + i - idx, res);
        }
        return res;
    }
}
