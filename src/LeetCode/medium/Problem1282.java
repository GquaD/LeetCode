package LeetCode.medium;

import java.util.*;

public class Problem1282 {

    //https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
    public static void main(String[] args) {
        List<List<Integer>> res = groupThePeople(new int[]{3, 3, 3, 3, 3, 1, 3});
        printListOfLists(res);
        System.out.println("////////////////////");
        List<List<Integer>> res1 = groupThePeople(new int[]{2, 1, 3, 3, 3, 2});
        printListOfLists(res1);
    }

    //Runtime
    //6 ms
    //Beats
    //83.58%
    //Memory
    //44.7 MB
    //Beats
    //20.16%
    static List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> mapWithGroups = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < groupSizes.length; i++) {
            if (!mapWithGroups.containsKey(groupSizes[i])) {
                List<Integer> group = new ArrayList<>();
                group.add(i);
                mapWithGroups.put(groupSizes[i], group);
            } else {
                mapWithGroups.get(groupSizes[i]).add(i);
            }
        }

        for (Integer size : mapWithGroups.keySet()) {
            int listSize = mapWithGroups.get(size).size();
            List<Integer> bigList = mapWithGroups.get(size);
            int count = 0;
            int numOfGroupsOfCurrentSize = listSize % size == 0 ? listSize / size : listSize / size + 1;
            for (int i = 0; i < numOfGroupsOfCurrentSize; i++) {
                List<Integer> group = new ArrayList<>();
                for (int j = 0; j < size; j++) {
                    group.add(bigList.get(count++));
                }
                result.add(group);
            }
        }
        return result;
    }

    //Runtime: 8 ms, faster than 66.36% of Java online submissions for Group the People Given the Group Size They Belong To.
    //Memory Usage: 54.4 MB, less than 20.57% of Java online submissions for Group the People Given the Group Size They Belong To.
    static List<List<Integer>> groupThePeople1(int[] groupSizes) {
        Map<Integer, List<Integer>> mapWithGroups = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        //adding all ppl to relevant groups size list
        for (int i = 0; i < groupSizes.length; i++) {
            if (!mapWithGroups.containsKey(groupSizes[i])) {
                List<Integer> group = new ArrayList<>();
                group.add(i);
                mapWithGroups.put(groupSizes[i], group);
            } else {
                mapWithGroups.get(groupSizes[i]).add(i);
            }
        }

        for (Integer size : mapWithGroups.keySet()) {
            int listSize = mapWithGroups.get(size).size();
            List<Integer> bigList = mapWithGroups.get(size);
            int count = 0;
            int numOfGroupsOfCurrentSize = (int) Math.ceil(listSize / size);
            for (int i = 0; i < numOfGroupsOfCurrentSize; i++) {
                List<Integer> group = new ArrayList<>();
                for (int j = 0; j < size; j++) {
                    group.add(bigList.get(count++));
                }
                result.add(group);
            }

        }
        return result;
    }

    static void printListOfLists(List<List<Integer>> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(Arrays.toString(list.get(i).toArray()));
        }
    }
}
