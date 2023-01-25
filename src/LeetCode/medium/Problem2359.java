package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem2359 {
    //https://leetcode.com/problems/find-closest-node-to-given-two-nodes/description/
    public static void main(String[] args) {
        System.out.println(closestMeetingNode(new int[]{5,3,1,0,2,4,5}, 3, 2));
        System.out.println(closestMeetingNode(new int[]{2,0,0}, 2, 0));
        System.out.println(closestMeetingNode(new int[]{2,2,3,-1}, 0, 1));
        System.out.println(closestMeetingNode(new int[]{1,2, -1}, 0, 2));
        System.out.println(closestMeetingNode(new int[]{4,4,8,-1,9,8,4,4,1,1}, 5, 6));
    }


    //1 hour
    //nnnn
    //Runtime
    //11 ms
    //Beats
    //95.21%
    //Memory
    //106.1 MB
    //Beats
    //29.94%

    static int closestMeetingNode(int[] edges, int node1, int node2) {
        int result = -1, minDistance = Integer.MAX_VALUE;
        int[] arr1 = new int[edges.length], arr2 = new int[edges.length];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = -1;
            arr2[i] = -1;
        }
        for (int i = node1, distance = 0; i != -1 && arr1[i] == -1; i = edges[i]) {
            arr1[i] = distance++;
        }

        for (int i = node2, distance = 0; i != -1 && arr2[i] == -1; i = edges[i]) {
            arr2[i] = distance++;
            if (arr1[i] >= 0 && Math.max(arr1[i], arr2[i]) <= minDistance) {
                result = Math.max(arr1[i], arr2[i]) == minDistance ? Math.min(i, result) : i;
                minDistance = Math.max(arr1[i], arr2[i]);
            }
        }
        return result;
    }


    static int closestMeetingNode1(int[] edges, int node1, int node2) {
        /*List<Integer>[] arr = new List[edges.length];
        int idx = 0;
        while (idx < edges.length) {
            int curIdx = idx;
            arr[idx] = new ArrayList<>();

            while (curIdx < edges.length) {
                arr[idx].add(curIdx);
                curIdx = edges[curIdx];
            }
            idx++;
        }*/
        List<Integer> list1 = new ArrayList<>();
        int curIdx = node1;
        while (curIdx != -1 && curIdx < edges.length && !list1.contains(curIdx)) {
            list1.add(curIdx);
            curIdx = edges[curIdx];
        }

        List<Integer> list2 = new ArrayList<>();
        curIdx = node2;
        while (curIdx != -1 && curIdx < edges.length && !list2.contains(curIdx)) {
            list2.add(curIdx);
            curIdx = edges[curIdx];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if (list1.get(i).equals(list2.get(j))) {
                    min = list1.get(i);
                }
            }
        }
        return min;
    }
}
