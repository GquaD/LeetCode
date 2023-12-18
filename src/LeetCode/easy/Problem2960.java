package LeetCode.easy;

public class Problem2960 {
    //https://leetcode.com/problems/count-tested-devices-after-test-operations/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/count-tested-devices-after-test-operations/solutions/4420929/java-o-n-solution/
    //2 min
    //Runtime
    //1 ms
    //Beats
    //80.15%
    //Memory
    //42.9 MB
    //Beats
    //92.94%
    static int countTestedDevices(int[] bat) {
        int dec = 0, count = 0;
        for (int b : bat) {
            if  (b - dec > 0) {
                dec++;
                count++;
            }
        }
        return count;
    }
}
