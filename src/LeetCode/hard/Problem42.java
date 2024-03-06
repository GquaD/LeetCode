package LeetCode.hard;

public class Problem42 {
    //https://leetcode.com/problems/trapping-rain-water/
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,3,1,0,1,3,2,1,2,1}));
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(trap(new int[]{4,2,0,3,2,5}));
    }

    //nnn
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //of users with Java
    //Memory
    //46.53
    //MB
    //Beats
    //19.99%
    //of users with Java
    static int trap(int[] h) {
        int left = 0, right = h.length - 1;
        int leftMax = h[0], rightMax = h[h.length - 1];
        int res = 0;
        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                if (leftMax < h[left]) {
                    leftMax = h[left];
                } else {
                    res += leftMax - h[left];
                }
            } else {
                right--;
                if (rightMax < h[right]) {
                    rightMax = h[right];
                } else {
                    res += rightMax - h[right];
                }
            }
        }
        return res;
    }
}
