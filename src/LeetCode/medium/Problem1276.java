package LeetCode.medium;

import LeetCode.LeetCodeUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1276 {
    //https://leetcode.com/problems/number-of-burgers-with-no-waste-of-ingredients/
    public static void main(String[] args) {
        LeetCodeUtils.printList(numOfBurgers(16, 8));
        LeetCodeUtils.printList(numOfBurgers(0, 0));
        LeetCodeUtils.printList(numOfBurgers(16, 7));
        LeetCodeUtils.printList(numOfBurgers(17, 4));
        LeetCodeUtils.printList(numOfBurgers(4, 17));
    }

    //https://leetcode.com/problems/number-of-burgers-with-no-waste-of-ingredients/solutions/4234993/java-pure-math-o-1-solution/
    //5-10 min
    //Runtime
    //1 ms
    //Beats
    //100%
    //Memory
    //41.7 MB
    //Beats
    //11.72%
    static List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        //if (tomatoSlices == 0 && cheeseSlices == 0) return Arrays.asList(0,0);
        int x = (tomatoSlices - (2 * cheeseSlices)) / 2, y = cheeseSlices - x;
        if (x * 4 + y * 2 == tomatoSlices && x >= 0 && y >= 0) return Arrays.asList(x, y);
        else return new ArrayList<>();
    }
}
