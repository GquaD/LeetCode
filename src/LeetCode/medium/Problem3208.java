package LeetCode.medium;

public class Problem3208 {
    //https://leetcode.com/problems/alternating-groups-ii
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/alternating-groups-ii/solutions/6517862/java-one-run-on-k-solution-explained-by-vdxfr/
    //5min
    //Runtime
    //2
    //ms
    //Beats
    //98.04%
    //Analyze Complexity
    //Memory
    //63.47
    //MB
    //Beats
    //19.27%
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int result = 0, len = 1;
        for (int i = 1; i < colors.length; i++) {
            if (colors[i] != colors[i - 1]) {
                len++;
            } else {
                result += Math.max(0, len - k + 1);
                len = 1;
            }
        }
        for (int i = 0; i < k - 1; i++) {
            if (colors[(colors.length - 1 + i) % colors.length] != colors[i]) {
                len++;
            } else {
                result += Math.max(0, len - k + 1);
                len = 1;
            }
        }
        if (len > 0)
            result += Math.max(0, len - k + 1);
        return result;
    }

    //10min
    //Runtime
    //3
    //ms
    //Beats
    //86.87%
    //Analyze Complexity
    //Memory
    //56.30
    //MB
    //Beats
    //95.81%
    public int numberOfAlternatingGroups1(int[] colors, int k) {
        int[] arr = new int[colors.length + k - 1];
        for (int i = 0; i < colors.length; i++) {
            arr[i] = colors[i];
        }
        for (int i = 0; i < k - 1; i++) {
            arr[colors.length + i] = colors[i];
        }
        int result = 0, len = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                len++;
            } else {
                result += Math.max(0, len - k + 1);
                len = 1;
            }
        }
        if (len > 0) result += Math.max(0, len - k + 1);
        return result;
    }
}
