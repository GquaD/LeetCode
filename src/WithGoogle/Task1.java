package WithGoogle;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task1 {

    public static void main(String[] args) {
        int[] array1 = new int[]{1, 2, 3};
        int[] array2 = new int[]{1, 2, 2, 3, 3, 3, 4, 5, 5};
        int[] array3 = new int[]{5, 10, 15, 10, 17};
        int[] array4 = new int[]{1, 2, 2, 3, 3, 3, 4, 5, 5};
        int[] array5 = new int[]{6, 2, 2, 3, 3, 1, 3, 4, 5, 5};

        int[] result1 = solution(array1, 0);
        System.out.println(Arrays.toString(result1));
        int[] result2 = solution(array2, 1);
        System.out.println(Arrays.toString(result2));
        int[] result3 = solution(array3, 1);
        System.out.println(Arrays.toString(result3));
        int[] result4 = solution(array4, 2);
        System.out.println(Arrays.toString(result4));
        int[] result5 = solution(array5, 2);
        System.out.println(Arrays.toString(result5));


    }

    public static int[] solution(int[] data, int n) {
        List<Integer> resultList = new ArrayList<>();
        Map<Integer, Integer> map = new LinkedHashMap<>();//number, times
        for (int num : data) {
            if (map.containsKey(num)) {
                map.put(num, (map.get(num) + 1));
            } else {
                map.put(num, 1);
            }
        }

        for (int i = 0; i < data.length; i++) {
            int timesForKey = map.get(data[i]);
            if (timesForKey <= n) {
                resultList.add(data[i]);
            }
        }

        /*for (int key: map.keySet()) {
            int timesForKey = map.get(key);
            if (timesForKey <= times) {
                for (int i = 0; i < timesForKey; i++) {
                    list.add(key);
                }
            }
        }*/

        int[] result = new int[resultList.size()];

        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    public static int[] solution1(int[] arr, int times) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new LinkedHashMap<>();//number, times
        int[][] mapArray = new int[arr.length][2];

        for (int num : arr) {
            list.add(num);
            if (map.containsKey(num)) {
                map.put(num, (map.get(num) + 1));
            } else {
                map.put(num, 1);
            }
        }

        list.clear();

        for (int key: map.keySet()) {
            int timesForKey = map.get(key);
            if (timesForKey <= times) {
                list.add(key);
            }
        }

        int[] result = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

}
