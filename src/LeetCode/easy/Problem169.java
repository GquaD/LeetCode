package LeetCode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Behzod on 13, March, 2021
 */
public class Problem169 {

    public static void main(String[] args) {
        int[] first = {3, 2, 3};
        int[] second = {2, 2, 1, 1, 1, 2, 2};
        int[] third = {3, 1, 2, 6, 5, 4, 1, 6, 7, 8, 6, 10, 8};
        int[] fourth = {2, 2, 1, 3, 1, 1, 4, 1, 1, 5, 1, 1, 6};
        int[] fifth = {32, 32, 58, 32, 32, 32, 32, 32, 50, 77, 77, 32, 32, 32, 51, 32, 61, 32, 32, 88, 44, 32, 7, 32, 32, 92, 28, 1, 32, 32, 44, 97, 99, 32, 1, 40, 32, 20, 32, 68, 85, 32, 32, 32, 32, 98, 13, 32, 32, 7, 74, 32, 32, 52, 32, 86, 28, 45, 73, 19, 32, 32, 27, 32, 83, 32, 68, 94, 32, 32, 32, 32, 27, 24, 32, 32, 96, 32, 99, 60, 46, 32, 22, 71, 25, 32, 32, 32, 32, 53, 54, 26, 32, 32, 32, 32, 13, 32, 23, 6};
        int[] sixth = {47, 47, 72, 47, 72, 47, 79, 47, 12, 92, 13, 47, 47, 83, 33, 15, 18, 47, 47, 47, 47, 64, 47, 65, 47, 47, 47, 47, 70, 47, 47, 55, 47, 15, 60, 47, 47, 47, 47, 47, 46, 30, 58, 59, 47, 47, 47, 47, 47, 90, 64, 37, 20, 47, 100, 84, 47, 47, 47, 47, 47, 89, 47, 36, 47, 60, 47, 18, 47, 34, 47, 47, 47, 47, 47, 22, 47, 54, 30, 11, 47, 47, 86, 47, 55, 40, 49, 34, 19, 67, 16, 47, 36, 47, 41, 19, 80, 47, 47, 27};
        int[] seven = {2, 2, 1, 3, 1, 1, 4, 1, 1, 5, 1, 1, 6};
        int[] eight = {12,52,12,70,12,61,12,12,50,72,82,12,11,25,28,43,40,12,12,53,12,12,98,12,12,92,81,2,12,15,40,12,12,9,12,31,12,12,12,12,77,12,12,50,12,12,12,93,41,92,12,12,12,12,12,12,12,12,12,37,48,14,12,70,82,12,80,12,12,12,12,56,30,12,8,12,50,12,20,12,21,97,12,42,12,10,12,38,73,15,9,11,79,12,12,28,51,12,15,12};

        System.out.println("first: " + majorityElementNewAlgorithm(first));
        System.out.println("second: " + majorityElementNewAlgorithm(second));
        System.out.println("third: " + majorityElementNewAlgorithm(third));
        System.out.println("fourth: " + majorityElementNewAlgorithm(fourth));
        System.out.println("fifth: " + majorityElementNewAlgorithm(fifth));
        System.out.println("sixth: " + majorityElementNewAlgorithm(sixth));
        System.out.println("seventh: " + majorityElementNewAlgorithm(seven));
        System.out.println("eight: " + majorityElementNewAlgorithm(eight));
    }

    public static int majorityElementWithMap(int[] nums) {
        int halfOfLength = nums.length / 2;
        // number ,  frequency
        Map<Integer, Integer> counter = new HashMap<>();
        int max = 0;
        int resultMax = 0;
        for (int num : nums) {
            counter.put(num, counter.get(num) == null ? 1 : (counter.get(num) + 1));
            if (counter.get(num) > max && counter.get(num) > halfOfLength) {
                max = counter.get(num);
                resultMax = num;
            }
        }

        return resultMax;
    }



    public static int majorityElement1(int[] nums) {
        int halfOfLength = nums.length / 2;
        if (nums.length < 11) {
            Arrays.sort(nums);
            return nums[halfOfLength];
        } else {
            int[] array = new int[5];
            for (int i = 0; i < array.length; i++) {
                int rand = new Random().nextInt(nums.length);
                array[i] = nums[rand];
            }
            return majorityElementWithMap(array);
        }
    }

    public static int majorityElement2(int[] nums) {
        if (nums.length <= 30) {
            Arrays.sort(nums);
            return nums[nums.length / 2];
        } else {
            int[] array1 = new int[5];
            int[] array2 = new int[5];
            int[] array3 = new int[5];
            int oneThirdOfLength = nums.length / 3;

            for (int i = 0; i < array1.length; i++) {
                //from 0 to 1/3 of the length
                int rand = new Random().nextInt(oneThirdOfLength);
                array1[i] = nums[rand];
            }
            Arrays.sort(array1);
            for (int i = 0; i < array2.length; i++) {
                // from 1/3 to 2/3 of the length
                int rand = new Random().nextInt(oneThirdOfLength) + oneThirdOfLength;
                array2[i] = nums[rand];
            }
            Arrays.sort(array2);
            for (int i = 0; i < array3.length; i++) {
                //from 2/3 to 1 of the length
                int rand = new Random().nextInt(oneThirdOfLength) + (2 * oneThirdOfLength);
                array3[i] = nums[rand];
            }
            Arrays.sort(array3);
            int[] finalArray = new int[3];
            finalArray[0] = array1[array1.length / 2];
            finalArray[1] = array2[array2.length / 2];
            finalArray[2] = array3[array3.length / 2];

            Arrays.sort(finalArray);
            return finalArray[finalArray.length / 2];
        }
    }

    public static int majorityElementNewAlgorithm(int[] nums) {
        int count = 1;
        int majority = nums[0];

        for(int i = 1; i < nums.length; i++) {
            if (count == 0) {
                majority = nums[i];
            }
            if(nums[i] == majority) {
                count++;
            }
            else {
                count--;
            }
        }
        return majority;
    }
}
