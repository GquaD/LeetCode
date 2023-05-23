package LeetCode.medium;

import javafx.util.Pair;

import java.util.*;

public class Problem2502 {
    //https://leetcode.com/problems/design-memory-allocator/
    public static void main(String[] args) {
        Allocator allocator = new Allocator(10);
        System.out.println(allocator.allocate(1,1));
        System.out.println(allocator.allocate(1,2));
        System.out.println(allocator.allocate(1,3));
        System.out.println(allocator.free(2));
        System.out.println(allocator.allocate(3,4));
        System.out.println(allocator.allocate(1,1));
        System.out.println(allocator.allocate(1,1));
        System.out.println(allocator.free(1));
        System.out.println(allocator.allocate(10,2));
        System.out.println(allocator.free(7));
    }
}
//40-50min
//Runtime
//38 ms
//Beats
//39.55%
//Memory
//44.9 MB
//Beats
//6.21%
class Allocator {

    Map<Integer, List<int[]>> map;
    int[] arr;
    public Allocator(int size) {
        arr = new int[size];
        map = new HashMap<>();
    }

    public int allocate(int size, int mID) {
        int countSize = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) countSize++;
            else countSize = 0;
            if (countSize == size) {
                int start = i - size + 1;
                for (int j = start; j <= i; j++) arr[j] = mID;
                if (!map.containsKey(mID)) map.put(mID, new ArrayList<>());
                map.get(mID).add(new int[]{start, size});
                return start;
            }
        }
        return -1;
    }

    public int free(int mID) {
        if (!map.containsKey(mID)) return 0;
        List<int[]> list = map.get(mID);
        int count = 0;
        for (int[] pair : list) {
            int start = pair[0], size = pair[1];
            for (int i = start; i < start + size; i++) {
                arr[i] = 0;
            }
            count += size;
        }
        map.get(mID).clear();
        return count;
    }
}

//have a map with ID as a key and pair as a value
//inside of pair I'll have idx start and size
