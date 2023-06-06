package LeetCode.medium;

public class Problem1899 {
    //https://leetcode.com/problems/merge-triplets-to-form-target-triplet/
    public static void main(String[] args) {
        System.out.println(mergeTriplets(new int[][]{{2, 5, 3}, {1, 8, 4}, {1, 7, 5}}, new int[]{2, 7, 5}));
        System.out.println(mergeTriplets(new int[][]{{3,4,5}, {4,5,6}}, new int[]{3,2,5}));
    }

    //https://leetcode.com/problems/merge-triplets-to-form-target-triplet/solutions/3606059/java-greedy-1ms-o-n-solution/
    //10 min
    //Runtime
    //1 ms
    //Beats
    //99.48%
    //Memory
    //125.6 MB
    //Beats
    //5.44%
    static boolean mergeTriplets(int[][] triplets, int[] target) {
        int a = target[0], b = target[1], c = target[2];
        boolean[] check = new boolean[3];
        for (int i = 0; i < triplets.length; i++) {
            int x = triplets[i][0], y = triplets[i][1], z = triplets[i][2];
            if (x == a && y <= b && z <= c)
                check[0] = true;
            if (y == b && x <= a && z <= c)
                check[1] = true;
            if (z == c && x <= a && y <= b)
                check[2] = true;
            if (check[0] && check[1] && check[2])
                return true;
        }
        return false;
    }

    static boolean mergeTriplets1(int[][] triplets, int[] target) {
        boolean[] check = new boolean[3];
        for (int i = 0; i < triplets.length; i++) {
            if (triplets[i][0] == target[0] && triplets[i][1] <= target[1] && triplets[i][2] <= target[2])
                check[0] = true;
            if (triplets[i][1] == target[1] && triplets[i][0] <= target[0] && triplets[i][2] <= target[2])
                check[1] = true;
            if (triplets[i][2] == target[2] && triplets[i][0] <= target[0] && triplets[i][1] <= target[1])
                check[2] = true;
        }
        return check[0] && check[1] && check[2];
    }
}
