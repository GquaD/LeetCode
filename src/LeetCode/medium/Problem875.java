package LeetCode.medium;

public class Problem875 {
    //https://leetcode.com/problems/koko-eating-bananas/description/
    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{831235932,437082868,576572631,529869153,55330371,511060323,581115062,931692072,600856556,519045509,504164418,431105822,580257183}, 964065706));
        System.out.println(minEatingSpeed(new int[]{805306368,805306368,805306368}, 1000000000));
        System.out.println(minEatingSpeed(new int[]{30,11,23,4,20}, 6));
        System.out.println(minEatingSpeed(new int[]{3,6,7,11}, 8));
    }

    //https://leetcode.com/problems/koko-eating-bananas/solutions/3270857/java-o-n-nlogn-solution/
    //40 min
    //Runtime
    //17 ms
    //Beats
    //83.60%
    //Memory
    //43.2 MB
    //Beats
    //69.24%
    static int minEatingSpeed(int[] piles, int h) {
        int min = 1, max = 0;
        for (int n : piles) if (max < n) max = n;

        if (h == piles.length) return max;
        while (min <= max) {
            int tempH = 0, mid = (min + max) / 2;
            for (int n : piles) {
                tempH += n / mid;
                if (n % mid > 0) tempH++;
            }
            if (tempH == h) {
                max = mid - 1;
            } else if (tempH > h || tempH < 0) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return min;
    }
}

        /*if (h >= max) {
            Arrays.sort(piles);
            int tempH = h, count = 1;
            for (int i = 0; i < piles.length; i++) {
                int n = piles[i];
                if (tempH - n >= 0) {
                    tempH -= n;
                } else {
                    i--;
                    count++;
                    tempH = h;
                }
            }
            return count;
        }*/
