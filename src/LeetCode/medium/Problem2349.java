package LeetCode.medium;

import java.util.*;

public class Problem2349 {
    //https://leetcode.com/problems/design-a-number-container-system
    public static void main(String[] args) {

    }


}

//https://leetcode.com/problems/design-a-number-container-system/solutions/3299074/java-tc-86-sc-99-two-maps-solution/
//30 min
//Runtime
//86 ms
//Beats
//83.69%
//Memory
//119 MB
//Beats
//99.29%

class NumberContainers {

    Map<Integer, Integer> mapIdxNum;
    Map<Integer, Set<Integer>> mapNumListIdx;

    public NumberContainers() {
        mapIdxNum = new HashMap<>();
        mapNumListIdx = new HashMap<>();
    }

    public void change(int index, int number) {
        mapIdxNum.put(index, number);
        if (mapNumListIdx.containsKey(number)) {
            mapNumListIdx.get(number).add(index);
        } else {
            Set<Integer> set = new TreeSet<>();
            set.add(index);
            mapNumListIdx.put(number, set);
        }
    }

    public int find(int number) {
        if (mapNumListIdx.containsKey(number)) {
            Set<Integer> indices = mapNumListIdx.get(number);
            for (int idx : indices)
                if (mapIdxNum.get(idx) == number) return idx;
        }
        return -1;
    }
}


//TLE on 37/45
//class NumberContainers {
//    Map<Integer, Integer> map;
//    public NumberContainers() {
//       map = new TreeMap<>();
//    }
//
//    public void change(int index, int number) {
//        map.put(index, number);
//    }
//
//    public int find(int number) {
//        for (int key : map.keySet()) if (map.get(key) == number) return key;
//        return -1;
//    }
//}

//class NumberContainers {
//    List<Integer> list;
//    public NumberContainers() {
//        list = new ArrayList<>();
//        list.add(0);
//    }
//
//    public void change(int index, int number) {
//        if (index >= list.size()) {
//            while (index >= list.size()) list.add(0);
//            list.add(number);
//        } else {
//            list.set(index, number);
//        }
//    }
//
//    public int find(int number) {
//        return list.indexOf(number);
//    }
//}
