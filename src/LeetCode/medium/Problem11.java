package LeetCode.medium;

import java.util.*;
import java.util.stream.Collectors;

public class Problem11 {
    //https://leetcode.com/problems/container-with-most-water/
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(maxArea(new int[]{1, 1}));
        System.out.println(maxArea(new int[]{2, 3, 10, 5, 7, 8, 9})); //36
        System.out.println(maxArea(new int[]{1,0,0,0,0,0,0,2,2})); //8
        System.out.println(maxArea(new int[]{1,2,3,4,5,25,24,3,4})); //
    }

    //https://leetcode.com/problems/container-with-most-water/solutions/2660581/java-solution-in-just-5-ms-with-image-and-explanation/
    //3 hours
    //Runtime
    //2 ms
    //Beats
    //99.24%
    //Memory
    //52.5 MB
    //Beats
    //63.13%
    static int maxArea(int[] height) {

        int a = 0, b = height.length - 1;
        int maxArea = Integer.MIN_VALUE;
        while (a < b) {
            int tempArea = Math.min(height[a], height[b]) * (b - a);
            if (tempArea > maxArea) {
                maxArea = tempArea;
            }

            if (height[a] == height[b]) {
                int hA = height[a], tempA = a;
                while (height[tempA] <= hA && tempA < b) {
                    tempA++;
                }
                int hB = height[b], tempB = b;
                while (height[tempB] <= hB && tempB > a) {
                    tempB--;
                }
                if (tempA - a >= b - tempB) {
                    b = tempB;
                } else {
                    a = tempA;
                }
            } else if (height[a] > height[b]) {
                int hB = height[b];
                while (height[b] <= hB && b > a) {
                    b--;
                }
            } else {
                int hA = height[a];
                while (height[a] <= hA && a < b) {
                    a++;
                }
            }
        }
        return maxArea;

        /*int left = 0, right = height.length - 1, maxArea = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            if (maxArea < area) {
                maxArea = area;
            }

        }*/
    }

    //time limit exceeded 54 out of 60
    static int maxArea4(int[] height) {
        int a = 0, b = height.length - 1;
        int maxArea = 0;
        while (a <= b) {
            for (int i = 0; i < height.length - b; i++) {
                int distance = Math.abs(b - a);
                int minHeight = Math.min(height[a + i], height[b + i]);
                int area = minHeight * distance;
                if (maxArea < area) {
                    maxArea = area;
                }
            }
            b--;
        }
        return maxArea;
    }

    //incorrect
    static int maxArea3(int[] height) {
        List<Pair> list = new ArrayList<>(height.length);
        for (int i = 0; i < height.length; i++) {
            list.add(new Pair(i, height[i]));
        }
        list = list.stream().sorted(Comparator.comparing(Pair::getValue, Comparator.reverseOrder()).thenComparing(Pair::getIndex, Comparator.reverseOrder())).collect(Collectors.toList());
        int maxValue = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            int distance = Math.abs(list.get(i).index - list.get(i + 1).index);
            int minHeight = Math.min(list.get(i).value, list.get(i + 1).value);
            int area = minHeight * distance;
            if (maxValue < area) {
                maxValue = area;
            }
        }
        return maxValue;
    }

    static class Pair {
        int index;
        int value;

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public int getValue() {
            return value;
        }
    }

    //time limit exceeded
    static int maxArea2(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int tempArea = Math.min(height[i], height[j]) * Math.abs(j - i);
                if (tempArea > maxArea) {
                    maxArea = tempArea;
                }
            }
        }
        return maxArea;
    }

    static int maxArea1(int[] height) {
        int a = 0, b = height.length - 1;
        int maxArea = Integer.MIN_VALUE;
        while (a < b) {
            int tempArea = Math.min(height[a], height[b]) * (b - a);
            if (tempArea > maxArea) {
                maxArea = tempArea;
            }

            a++;

            tempArea = Math.min(height[a], height[b]) * (b - a);
            if (tempArea > maxArea) {
                maxArea = tempArea;
            }

            b--;
        }
        return maxArea;
    }
}
