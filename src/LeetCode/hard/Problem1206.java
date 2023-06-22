package LeetCode.hard;

import java.util.*;

public class Problem1206 {
    //https://leetcode.com/problems/design-skiplist/
    public static void main(String[] args) {

    }


}

//https://leetcode.com/problems/design-skiplist/solutions/3670680/java-2-solutions-arraylist-binarysearch-o-n-hashmap-o-1/
//15 min for 2 solutions
//Runtime
//11 ms
//Beats
//95.19%
//Memory
//49.4 MB
//Beats
//82.69%
class Skiplist {

    Map<Integer, Integer> map;
    public Skiplist() {
        map = new HashMap<>();
    }

    public boolean search(int target) {
        return map.containsKey(target);
    }

    public void add(int num) {
        map.put(num, map.getOrDefault(num, 0) + 1);
    }

    public boolean erase(int num) {
        Integer count = map.get(num);
        if (count == null) return false;
        if (count == 1) map.remove(num);
        else map.put(num, count - 1);
        return true;
    }
}


//Runtime
//19 ms
//Beats
//63.46%
//Memory
//49.4 MB
//Beats
//84.62%
class Skiplist1 {

    List<Integer> list;
    public Skiplist1() {
        list = new ArrayList<>();
    }

    public boolean search(int target) {
        if (list.size() == 0) return false;
        int idx = Collections.binarySearch(list, target);
        return idx >= 0;
    }

    public void add(int num) {
        if (list.size() == 0) {
            list.add(num);
        } else {
            int idx = Collections.binarySearch(list, num);
            if (idx < 0) idx = -idx - 1;
            list.add(idx, num);
        }
    }

    public boolean erase(int num) {
        int idx = Collections.binarySearch(list, num);
        if (idx < 0) return false;
        list.remove(idx);
        return true;
    }
}
