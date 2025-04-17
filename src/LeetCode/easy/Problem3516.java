package LeetCode.easy;

public class Problem3516 {
    //https://leetcode.com/problems/find-closest-person/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-closest-person/solutions/6659969/java-o1-solution-by-tbekpro-gfgv/
    //1min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //41.32
    //MB
    //Beats
    //18.32%
    public int findClosest(int x, int y, int z) {
        int one = Math.abs(z - x), two = Math.abs(z - y);
        return one == two ? 0 : one < two ? 1 : 2;
    }
}
