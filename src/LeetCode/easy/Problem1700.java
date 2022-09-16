package LeetCode.easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Problem1700 {
    //https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/
    public static void main(String[] args) {
        System.out.println(countStudents(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1}));
        System.out.println(countStudents(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1}));
    }

    //Runtime: 4 ms, faster than 29.11% of Java online submissions for Number of Students Unable to Eat Lunch.
    //Memory Usage: 42.8 MB, less than 11.01% of Java online submissions for Number of Students Unable to Eat Lunch.
    static int countStudents(int[] students, int[] sandwiches) {
        Stack<Integer> stackSandwiches = new Stack<>();
        for (int i = sandwiches.length - 1; i >= 0; i--) {
            stackSandwiches.push(sandwiches[i]);
        }

        Queue<Integer> queueStudents = new LinkedList<>();
        for (int i = 0; i < students.length; i++) {
            queueStudents.add(students[i]);
        }
        int count = 0;
        while (stackSandwiches.size() > 0) {
            int curr = stackSandwiches.peek();
            if (!queueStudents.contains(curr)) {
                return queueStudents.size();
            }
            if (queueStudents.peek() == curr) {
                stackSandwiches.pop();
                queueStudents.poll();
            } else {
                int temp = queueStudents.poll();
                queueStudents.add(temp);
            }
        }
        return count;
    }

    static int countStudents1(int[] students, int[] sandwiches) {
        int count0students = 0, count1students = 0;
        int count0sandwiches = 0, count1sandwiches = 0;

        for (int i = 0; i < students.length; i++) {
            if (students[i] == 0) count0students++;
            if (sandwiches[i] == 0) count0sandwiches++;
        }

        return Math.abs(count0sandwiches - count0students);
    }
}
