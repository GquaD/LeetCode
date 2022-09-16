package LeetCode.easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem2042 {
    public static void main(String[] args) {
        System.out.println(areNumbersAscending1("a puppy has 2 eyes 4 legs"));
        System.out.println(areNumbersAscending1("1 box has 3 blue 4 red 6 green and 12 yellow marbles"));
        System.out.println(areNumbersAscending1("hello world 5 x 5"));
        System.out.println(areNumbersAscending1("sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s"));
    }

    public static boolean areNumbersAscending(String s) {
        List<Integer> nums = Arrays.stream(s.split(" "))
                .filter(s1 -> s1.matches("([^\\d]|)\\d{1,3}([^\\d]|$)"))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i - 1) >= nums.get(i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean areNumbersAscending1(String s) {
        String[] strings = s.split(" ");
        int prev = -1;
        for (int i = 0; i < strings.length; i++) {
            if (isNumeric(strings[i])) {
                int current = Integer.parseInt(strings[i]);
                if (prev >= current) {
                    return false;
                }
                prev = current;
            }
        }
        return true;
    }

    public static boolean isNumeric(String s) {
        if (s.contains("0") || s.contains("1") || s.contains("2") ||
                s.contains("3") || s.contains("4") || s.contains("5") ||
                s.contains("6") || s.contains("7") || s.contains("8") ||
                s.contains("9")) {
            return true;
        } else return false;
    }
}
