package LeetCode.easy;

import java.util.*;

public class Problem88 {
    //https://leetcode.com/problems/merge-sorted-array/
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        merge(nums1, 3, new int[]{2, 5, 6}, 3);
        System.out.println(Arrays.toString(nums1));
        System.out.println("///////////");

        int[] nums2 = {1, 2, 6, 0, 0, 0};
        merge(nums2, 3, new int[]{2, 5, 6}, 3);
        System.out.println(Arrays.toString(nums2));
        System.out.println("///////////");

        int[] nums3 = {1};
        merge(nums3, 1, new int[0], 0);
        System.out.println(Arrays.toString(nums3));
        System.out.println("///////////");

        int[] nums4 = {0};
        merge(nums4, 0, new int[]{1}, 1);
        System.out.println(Arrays.toString(nums4));
        System.out.println("///////////");

        int[] nums5 = {2, 0};
        merge(nums5, 1, new int[]{1}, 1);
        System.out.println(Arrays.toString(nums5));
        System.out.println("///////////");
    }

    //https://leetcode.com/problems/merge-sorted-array/solutions/2699096/java-4-different-solutions-from-6-to-100-faster/
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //42.4 MB
    //Beats
    //84.10%
    static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < nums1.length; i++) {
                nums1[i] = nums2[i];
            }
        } else if (n != 0){
            int[] copy = Arrays.copyOfRange(nums1, 0, m);
            int c1 = 0, c2 = 0;
            for (int i = 0; i < nums1.length; i++) {
                if (c2 == nums2.length) {
                    c2--;
                    nums2[c2] = Integer.MAX_VALUE;
                }
                if (c1 == copy.length) {
                    c1--;
                    copy[c1] = Integer.MAX_VALUE;
                }
                if (copy[c1] > nums2[c2]) {
                    nums1[i] = nums2[c2++];
                } else {
                    nums1[i] = copy[c1++];
                }
            }
        }
    }

    //Runtime
    //2 ms
    //Beats
    //24.16%
    //Memory
    //42.7 MB
    //Beats
    //66.51%
    static void merge5(int[] nums1, int m, int[] nums2, int n) {
        Queue<Integer> list1 = new LinkedList<>();
        Queue<Integer> list2 = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            list1.add(nums1[i]);
        }
        for (int i = 0; i < n; i++) {
            list2.add(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            Integer one = list1.peek();
            Integer two = list2.peek();
            if (one != null && two != null) {
                if (one <= two) nums1[i] = list1.poll();
                else nums1[i] = list2.poll();
            } else if (one == null) {
                nums1[i] = list2.poll();
            } else if (two == null) {
                nums1[i] = list1.poll();
            }
        }
    }

    //Runtime
    //6 ms
    //Beats
    //6.46%
    //Memory
    //40.1 MB
    //Beats
    //99.94%
    static void merge4(int[] nums1, int m, int[] nums2, int n) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < m; i++) {
            if (map.containsKey(nums1[i])) {
                map.put(nums1[i], map.get(nums1[i]) + 1);
            } else {
                map.put(nums1[i], 1);
            }
        }
        for (int i = m; i < nums1.length; i++) {
            int idx = i - m;
            if (map.containsKey(nums2[idx])) {
                map.put(nums2[idx], map.get(nums2[idx]) + 1);
            } else {
                map.put(nums2[idx], 1);
            }
        }
        int count = 0;
        for (Integer num : map.keySet()) {
            for (int i = 0; i < map.get(num); i++) {
                nums1[count++] = num;
            }
        }
    }

    //wrong
    static void merge3(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> list = new LinkedList<>();
        int count = 0, countTwo = 0;
        if (!(n == 0 && m > 0 || n != 0 && m == 0)) {
            while (count < nums1.length) {
                if (count < m) {
                    if (list.size() == 0) {
                        if (nums1[count] < nums2[countTwo]) {
                        } else {
                            list.add(nums1[count]);
                            nums1[count] = nums2[countTwo++];
                        }
                    } else {
                        if (nums1[count] < nums2[countTwo] && nums1[count] < list.get(0)) {
                        } else if (nums1[count] < nums2[countTwo] && nums1[count] > list.get(0)) {
                            list.add(nums1[count]);
                            nums1[count] = list.get(0);
                            list.remove(0);
                        } else if (nums1[count] > nums2[countTwo] && nums1[count] < list.get(0)) {
                            list.add(nums1[count]);
                            nums1[count] = nums2[countTwo];
                            countTwo++;
                        } else if (nums1[count] > nums2[countTwo] && nums1[count] > list.get(0)) {
                            if (nums2[countTwo] < list.get(0)) {
                                list.add(nums1[count]);
                                nums1[count] = nums2[countTwo];
                                countTwo++;
                            } else {
                                list.add(nums1[count]);
                                nums1[count] = list.get(0);
                                list.remove(0);
                            }
                        }
                    }
                } else {
                    if (countTwo < nums2.length) {
                        if (list.size() > 0) {
                            if (nums2[countTwo] < list.get(0)) {
                                nums1[count] = nums2[countTwo];
                                countTwo++;
                            } else {
                                nums1[count] = list.get(0);
                                list.remove(0);
                            }
                        } else {
                            nums1[count] = nums2[countTwo];
                            countTwo++;
                        }
                    } else if (list.size() > 0) {
                        nums1[count] = list.get(0);
                        list.remove(0);
                    }
                }
                count++;
            }
        } else if (n != 0 && m == 0) {
            for (int i = 0; i < nums1.length; i++) {
                nums1[i] = nums2[i];
            }
        }
    }

    //Runtime
    //2 ms
    //Beats
    //24.16%
    //Memory
    //43 MB
    //Beats
    //39.60%
    static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int c = 0;
        while (m < nums1.length) {
            nums1[m++] = nums2[c++];
        }
        Arrays.sort(nums1);
    }

    static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int count = 0, count2 = 0;
        while (count < m) {
            if (nums1[count] <= nums2[count2]) {
                count++;
            } else {
                int temp = nums1[count];
                nums1[count] = nums2[count2];
                nums2[count2] = temp;
                count++;
                count2++;
                count2 %= n;
            }
        }
        int c = 0;
        while (m < nums1.length) {
            nums1[m++] = nums2[c++];
        }
    }
}
