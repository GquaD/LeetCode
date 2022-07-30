package LeetCode.medium;

public class Problem2079 {
    //https://leetcode.com/problems/watering-plants/
    public static void main(String[] args) {
        System.out.println(wateringPlants(new int[]{2, 2, 3, 3}, 5));
        System.out.println(wateringPlants(new int[]{1, 1, 1, 4, 2, 3}, 4));
    }
    //Runtime: 1 ms, faster than 72.01% of Java online submissions for Watering Plants.
    //Memory Usage: 43 MB, less than 48.18% of Java online submissions for Watering Plants.
    static int wateringPlants(int[] plants, int capacity) {
        int countAll = 0, capacityCurrent = 0;
        int index = 0;
        while (index < plants.length) {
            if (capacityCurrent >= plants[index]) {
                capacityCurrent -= plants[index++];
                countAll++;
            } else {
                capacityCurrent = capacity;
                countAll += index * 2;
            }
        }
        return countAll;
    }
}
