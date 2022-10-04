package LeetCode.medium;

import java.util.HashSet;
import java.util.Set;

public class Problem2336 {
    //https://leetcode.com/problems/smallest-number-in-infinite-set/
    public static void main(String[] args) {
        SmallestInfiniteSet infiniteSet = new SmallestInfiniteSet();
        infiniteSet.addBack(2);
        infiniteSet.popSmallest();
        infiniteSet.popSmallest();
        infiniteSet.popSmallest();
        infiniteSet.addBack(1);
        infiniteSet.popSmallest();
        infiniteSet.popSmallest();
        infiniteSet.popSmallest();
        System.out.println();
    }

    //https://leetcode.com/problems/smallest-number-in-infinite-set/solutions/2660796/java-simple-solution/
    //10mins
    //Runtime
    //34 ms
    //Beats
    //45.80%
    //Memory
    //54.3 MB
    //Beats
    //70.14%
    static class SmallestInfiniteSet {
        Set<Integer> setOfDeleted;
        int smallest;
        public SmallestInfiniteSet() {
            setOfDeleted = new HashSet<>();
            smallest = 1;
        }

        public int popSmallest() {
            if (!setOfDeleted.contains(smallest)) {
                setOfDeleted.add(smallest);
                return smallest++;
            } else {
                while (setOfDeleted.contains(smallest)) {
                    smallest++;
                }
                setOfDeleted.add(smallest);
                return smallest;
            }
        }

        public void addBack(int num) {
            if (smallest > num) {
                smallest = num;
            }
            setOfDeleted.remove(num);
        }
    }

}
