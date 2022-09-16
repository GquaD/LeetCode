package LeetCode.easy;

public class Problem1925 {
    //https://leetcode.com/problems/count-square-sum-triples/
    public static void main(String[] args) {
        System.out.println(countTriples(3));
        System.out.println(countTriples(5));
        System.out.println(countTriples(10));
        System.out.println(countTriples(20));
    }

    //Runtime: 95 ms, faster than 31.67% of Java online submissions for Count Square Sum Triples.
    //Memory Usage: 40.5 MB, less than 83.57% of Java online submissions for Count Square Sum Triples.
    static int countTriples(int n) {
        if (n < 5) return 0;
        int count = 0;
        for (int i = 3; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                for (int k = 1; k < j; k++) {
                    if (i * i == (j * j + k * k)) {
                        System.out.println("a = " + k + ", b = " + j + ", c = " + i);
                        count++;
                    }
                }
            }
        }
        return count * 2;
    }
}
