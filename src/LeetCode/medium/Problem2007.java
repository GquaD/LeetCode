package LeetCode.medium;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.*;

public class Problem2007 {
    //https://leetcode.com/problems/find-original-array-from-doubled-array/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOriginalArray(new int[]{4,4,16,20,8,8,2,10})));
        System.out.println(Arrays.toString(findOriginalArray(new int[]{1, 2, 3, 2, 4, 6, 2, 4, 6, 4, 8, 12})));
        System.out.println(Arrays.toString(findOriginalArray(new int[]{0, 6, 3, 0})));
        System.out.println(Arrays.toString(findOriginalArray(new int[]{1, 3, 4, 2, 6, 8})));
        System.out.println(Arrays.toString(findOriginalArray(new int[]{6, 3, 0, 1})));
        System.out.println(Arrays.toString(findOriginalArray(new int[]{1})));
    }

    //https://leetcode.com/problems/find-original-array-from-doubled-array/solutions/4302983/java-hashmap-set/
    //1hour
    //Runtime
    //127 ms
    //Beats
    //21.77%
    //Memory
    //57.1 MB
    //Beats
    //86.79%
    static final int[] EMPTY_ARRAY = new int[]{};

    static int[] findOriginalArray(int[] arr) {
        if (arr.length % 2 == 1) return EMPTY_ARRAY;
        int count = 0, half = arr.length / 2;
        int[] res = new int[half];
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        Arrays.sort(arr);
        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
            set.add(n);
        }
        for (int i = 0; i < arr.length; i++) {
            int n = arr[i], nDoubled = n * 2;
            if (set.contains(n) && map.containsKey(nDoubled)) {
                int freq = map.get(nDoubled);

                if (n == 0) {
                    if (freq == 1) {
                        return EMPTY_ARRAY;
                    } else if (freq == 2) {
                        map.remove(nDoubled);
                        set.remove(nDoubled);
                    } else if (freq > 2) {
                        map.put(nDoubled, freq - 2);
                    }
                    res[count++] = n;
                } else {
                    if (freq > 1) {
                        map.put(nDoubled, freq - 1);
                    } else {
                        map.remove(nDoubled);
                        set.remove(nDoubled);
                    }
                    int freqN = map.get(n);
                    if (freqN > 1) {
                        map.put(n, freqN - 1);
                    } else {
                        map.remove(n);
                        set.remove(n);
                    }
                    res[count++] = n;
                }
            }
        }
        return count == half ? res : EMPTY_ARRAY;
    }

    static int[] findOriginalArray3(int[] arr) {
        if (arr.length % 2 == 1) return EMPTY_ARRAY;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            map.computeIfAbsent(arr[i], ArrayList::new).add(i);
        }
        int count = 0, half = arr.length / 2;
        int[] res = new int[half];
        Set<Integer> setRemoved = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int n = arr[i], nDoubled = n * 2;
            if (!setRemoved.contains(i) && map.containsKey(nDoubled)) {
                List<Integer> list = map.get(nDoubled);

                if (n == 0) {
                    if (list.size() == 1) {
                        return EMPTY_ARRAY;
                    } else if (list.size() == 2) {
                        map.remove(nDoubled);
                        setRemoved.addAll(list);
                    } else if (list.size() > 2) {
                        setRemoved.add(list.get(list.size() - 1));
                        setRemoved.add(list.get(list.size() - 2));
                        list.remove(list.size() - 1);
                        list.remove(list.size() - 1);
                    }
                } else {
                    setRemoved.add(list.get(list.size() - 1));
                    if (list.size() > 1) {
                        list.remove(list.size() - 1);
                    } else {
                        map.remove(nDoubled);
                    }
                }
                res[count++] = n;
            }
        }
        return count == half ? res : EMPTY_ARRAY;
    }

    //Wrong Answer
    //152 / 179 testcases passed
    static int[] findOriginalArray2(int[] arr) {
        if (arr.length % 2 == 1) return EMPTY_ARRAY;
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(arr);
        for (int n : arr) map.put(n, map.getOrDefault(n, 0) + 1);
        int count = 0, half = arr.length / 2;
        int[] res = new int[half];
        Set<Integer> setRemoved = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int n = arr[i], nDoubled = n * 2;
            if (!setRemoved.contains(n) && map.containsKey(nDoubled)) {
                int freq = map.get(nDoubled);

                if (n == 0) {
                    if (freq == 1) {
                        return EMPTY_ARRAY;
                    } else if (freq == 2) {
                        map.remove(nDoubled);
                        setRemoved.add(nDoubled);
                    } else if (freq > 2) {
                        map.put(nDoubled, freq - 2);
                    }
                } else {
                    if (freq > 1) {
                        map.put(nDoubled, freq - 1);
                    } else {
                        map.remove(nDoubled);
                        setRemoved.add(nDoubled);
                    }
                }
                res[count++] = n;
            }
        }
        return count == half ? res : EMPTY_ARRAY;
    }

    static int[] findOriginalArray1(int[] arr) {
        if (arr.length % 2 == 1) return EMPTY_ARRAY;
        Arrays.sort(arr);
        int start = 0, half = arr.length / 2, idx = 0;
        int[] res = new int[arr.length / 2];
        if (arr[0] == 0) {
            if (arr[1] != 0) return EMPTY_ARRAY;
            start = 2;
            half++;
            res[idx++] = 0;
        }

        for (int i = start; i < half; i++) {
            if (arr[i] * 2 == arr[half + i - start]) res[idx++] = arr[i];
            else return EMPTY_ARRAY;
        }
        return res;
    }
}
