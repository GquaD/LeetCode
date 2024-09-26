package LeetCode.easy;

public class Problem3206 {
    //https://leetcode.com/problems/alternating-groups-i
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/alternating-groups-i/solutions/5835710/java-o-n-solution/
    //5min
    //Runtime
    //1
    //ms
    //Beats
    //95.08%
    //Analyze Complexity
    //Memory
    //42.75
    //MB
    //Beats
    //86.73%
    public int numberOfAlternatingGroups(int[] arr) {
        int count = 0, len = arr.length;
        for (int i = 0; i < len - 2; i++) {
            if (arr[i] != arr[i + 1] && arr[i + 1] != arr[i + 2])
                count++;
        }
        if (arr[len - 2] != arr[len - 1] && arr[len - 1] != arr[0]) count++;
        if (arr[len - 1] != arr[0] && arr[0] != arr[1]) count++;
        return count;
    }
}
