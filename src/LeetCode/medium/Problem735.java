package LeetCode.medium;

import java.util.Arrays;
import java.util.Stack;

public class Problem735 {
    //https://leetcode.com/problems/asteroid-collision/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(asteroidCollision(new int[]{1,-1,-2,-2})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{-2,-2,1,-1})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{1, -2, 12, 10, -5, -11, -15})));
    }

    //https://leetcode.com/problems/asteroid-collision/solutions/3793257/java-o-n-stack/
    //25 min
    //Runtime
    //Details
    //13ms
    //Beats 32.72%of users with Java
    //Memory
    //Details
    //44.82mb
    //Beats 14.59%of users with Java
    static int[] asteroidCollision(int[] a) {
        Stack<Integer> stack = new Stack<>();
        stack.push(a[0]);
        for (int i = 1; i < a.length; i++) {
            int curr = a[i];
            if (stack.isEmpty()) {
                stack.push(curr);
                continue;
            }
            while (!stack.isEmpty()) {
                int left = stack.pop();
                if (left > 0 && curr < 0) {
                    int collision = left + curr;
                    if (collision > 0) {
                        stack.push(left);
                        break;
                    } else if (collision < 0) {
                        if (!(!stack.isEmpty() && stack.peek() > 0)) {
                            stack.push(curr);
                            break;
                        }
                    } else break;
                } else {
                    stack.push(left);
                    stack.push(curr);
                    break;
                }
            }
        }
        int c = stack.size() - 1, res[] = new int[stack.size()];
        while (!stack.isEmpty()) res[c--] = stack.pop();
        return res;
    }
}

