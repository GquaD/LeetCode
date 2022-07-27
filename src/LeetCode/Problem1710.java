package LeetCode;

import java.util.*;

public class Problem1710 {
    //https://leetcode.com/problems/maximum-units-on-a-truck/
    public static void main(String[] args) {
        System.out.println(maximumUnits(new int[][]{
                {2, 1},
                {4, 4},
                {3, 1},
                {4, 1},
                {2, 4},
                {3, 4},
                {1, 3},
                {4, 3},
                {5, 3},
                {5, 3}
        }, 13));
        System.out.println(maximumUnits(new int[][]{
                {1, 3},
                {2, 2},
                {3, 1}
        }, 4));
        System.out.println(maximumUnits(new int[][]{
                {5, 10},
                {2, 5},
                {4, 7},
                {3, 9}
        }, 10));
    }

    //Runtime: 19 ms, faster than 19.08% of Java online submissions for Maximum Units on a Truck.
    //Memory Usage: 52.5 MB, less than 5.53% of Java online submissions for Maximum Units on a Truck.
    static int maximumUnits(int[][] boxTypes, int truckSize) {
        List<PairMy> list = new ArrayList<>();
        for (int i = 0; i < boxTypes.length; i++) {
            PairMy pair = new PairMy(boxTypes[i][0], boxTypes[i][1]);
            list.add(pair);
        }
        Collections.sort(list, Comparator.comparingInt(o -> o.units));
        int count = 0;
        int sizeSoFar = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (sizeSoFar == truckSize) {
                break;
            }
            PairMy temp = list.get(i);
            if (temp.boxes + sizeSoFar < truckSize) {
                count += temp.units * temp.boxes;
                sizeSoFar += temp.boxes;
            } else {
                int left = truckSize - sizeSoFar;
                count += temp.units * left;
                break;
            }
        }
        return count;
    }

    //Runtime: 27 ms, faster than 11.78% of Java online submissions for Maximum Units on a Truck.
    //Memory Usage: 53.7 MB, less than 5.02% of Java online submissions for Maximum Units on a Truck.
    static int maximumUnits1(int[][] boxTypes, int truckSize) {
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        // units - key, boxes - value
        for (int i = 0; i < boxTypes.length; i++) {
            if (!map.containsKey(boxTypes[i][1])) {
                map.put(boxTypes[i][1], boxTypes[i][0]);
            } else {
                map.put(boxTypes[i][1], map.get(boxTypes[i][1]) + boxTypes[i][0]);
            }
        }
        int count = 0;
        int sizeSoFar = 0;
        for (Integer units : map.keySet()) {
            int boxes = map.get(units);
            if (boxes + sizeSoFar < truckSize) {
                count += units * boxes;
                sizeSoFar += boxes;
            } else {
                int left = truckSize - sizeSoFar;
                count += units * left;
                break;
            }
            if (sizeSoFar == truckSize) {
                break;
            }
        }
        return count;
    }

    static class PairMy {
        int boxes;
        int units;

        public PairMy(int boxes, int units) {
            this.boxes = boxes;
            this.units = units;
        }
    }
}
