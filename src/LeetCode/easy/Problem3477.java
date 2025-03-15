package LeetCode.easy;

public class Problem3477 {
    //https://leetcode.com/problems/fruits-into-baskets-ii
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/fruits-into-baskets-ii/solutions/6539322/java-greedy-solution-explained-by-tbekpr-4dcq/
    //2min
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //44.52
    //MB
    //Beats
    //59.21%
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int unplaced = fruits.length;
        for (int i = 0; i < fruits.length; i++) {
            int f = fruits[i];
            for (int j = 0; j < baskets.length; j++) {
                if (f <= baskets[j]) {
                    baskets[j] = 0;
                    unplaced--;
                    break;
                }
            }
        }
        return unplaced;
    }
}
