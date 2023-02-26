package LeetCode.medium;

public class Problem275 {
    //https://leetcode.com/problems/h-index-ii/
    public static void main(String[] args) {
        System.out.println(hIndex(new int[]{0,0,0,0}) + " vs 0");
        System.out.println(hIndex(new int[]{11,15}) + " vs 2");
        System.out.println(hIndex(new int[]{5,6,1,3,4,9,9}) + " vs 4");
        System.out.println(hIndex(new int[]{3,0,6,1,5}) + " vs 3");
        System.out.println(hIndex(new int[]{1,2,3,4,5,6,7,8}) + " vs 4");
    }

    //nnnn
    //O(logN)
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //49.9 MB
    //Beats
    //18.86%
    static int hIndex(int[] c) {
        int left = 0, right = c.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2, diff = c.length - mid;
            if (c[mid] == diff) return diff;
            else if (c[mid] < diff) left = mid + 1;
            else right = mid - 1;
        }
        return c.length - left;
    }

    //not O(logN)
    //O(N)
    //1 min since I just solved problem274
    //Runtime
    //1 ms
    //Beats
    //24.73%
    //Memory
    //49.6 MB
    //Beats
    //34.70%
    static int hIndex1(int[] c) {
        int h = c.length;
        for (int i = 0; i < c.length; i++) {
            if (h > c[i]) h--;
            else break;
        }
        return h;
    }
}
