package LeetCode.medium;

import java.util.*;

public class Problem554 {
    //https://leetcode.com/problems/brick-wall/
    public static void main(String[] args) {
        List<List<Integer>> wall = new ArrayList<>();
        wall.add(Arrays.asList(1,2,2,1));
        wall.add(Arrays.asList(3,1,2));
        wall.add(Arrays.asList(1,3,2));
        wall.add(Arrays.asList(2,4));
        wall.add(Arrays.asList(3,1,2));
        wall.add(Arrays.asList(1,3,1,1));
        System.out.println(leastBricks(wall));

        List<List<Integer>> wall1 = new ArrayList<>();
        wall1.add(Arrays.asList(6));
        wall1.add(Arrays.asList(6));
        wall1.add(Arrays.asList(2,4));
        wall1.add(Arrays.asList(6));
        wall1.add(Arrays.asList(1,2,2,1));
        wall1.add(Arrays.asList(6));
        wall1.add(Arrays.asList(2,1,2,1));
        wall1.add(Arrays.asList(1,5));
        wall1.add(Arrays.asList(4,1,1));
        wall1.add(Arrays.asList(1,4,1));
        wall1.add(Arrays.asList(4,2));
        wall1.add(Arrays.asList(3,3));
        wall1.add(Arrays.asList(2,2,2));
        wall1.add(Arrays.asList(5,1));
        wall1.add(Arrays.asList(5,1));
        wall1.add(Arrays.asList(6));
        wall1.add(Arrays.asList(4,2));
        wall1.add(Arrays.asList(1,5));
        wall1.add(Arrays.asList(2,3,1));
        wall1.add(Arrays.asList(4,2));
        wall1.add(Arrays.asList(1,1,4));
        wall1.add(Arrays.asList(1,3,1,1));
        wall1.add(Arrays.asList(2,3,1));
        wall1.add(Arrays.asList(3,3));
        wall1.add(Arrays.asList(3,1,1,1));
        wall1.add(Arrays.asList(3,2,1));
        wall1.add(Arrays.asList(6));
        wall1.add(Arrays.asList(3,2,1));
        wall1.add(Arrays.asList(1,5));
        wall1.add(Arrays.asList(1,4,1));
        System.out.println(leastBricks(wall1));
    }

    //https://leetcode.com/problems/brick-wall/solutions/4195982/java-o-n-m-solution/
    //20 min
    //Runtime
    //11 ms
    //Beats
    //92.3%
    //Memory
    //45.5 MB
    //Beats
    //87.75%
    static int leastBricks(List<List<Integer>> wall) {
        int count = 0;
        for (List<Integer> row : wall) if (row.size() == 1) count++;
        if (count == wall.size()) return wall.size();

        long sumRow = 0;
        int maxFreq = 1;
        Map<Long, Integer> mapFreq = new HashMap<>();
        for (List<Integer> row : wall){
            for (int n : row) {
                sumRow += n;
                Integer freq = mapFreq.get(sumRow);
                if (freq == null) {
                    mapFreq.put(sumRow, 1);
                } else {
                    mapFreq.put(sumRow, freq + 1);
                    maxFreq = Math.max(maxFreq, freq + 1);
                }
                //mapFreq.put(sumRow, mapFreq.getOrDefault(sumRow, 0) + 1);
            }
            mapFreq.remove(sumRow);
            sumRow = 0;
        }
        return wall.size() - maxFreq;
    }
}
