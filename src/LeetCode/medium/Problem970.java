package LeetCode.medium;

import LeetCode.LeetCodeUtils;

import java.util.*;

public class Problem970 {
    //https://leetcode.com/problems/powerful-integers/
    public static void main(String[] args) {
        LeetCodeUtils.printList(powerfulIntegers(2, 3, 10));
    }

    //https://leetcode.com/problems/powerful-integers/solutions/3774633/java-2ms-2-arraylists-1-hashset/
    //15 min
    //Runtime
    //Details
    //2ms
    //Beats 16.08%of users with Java
    //Memory
    //Details
    //40.68mb
    //Beats 34.27%of users with Java
    static List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> listX = new ArrayList<>(), listY = new ArrayList<>();
        if (x != 1) {
            int numX = 0, powX = 0;
            while (numX < bound) {
                numX = (int) Math.pow(x, powX++);
                listX.add(numX);
            }
        } else {
            listX.add(1);
        }
        if (y != 1) {
            int numY = 0, powY = 0;
            while (numY < bound) {
                numY = (int) Math.pow(y, powY++);
                listY.add(numY);
            }
        } else {
            listY.add(1);
        }
        Set<Integer> listSum = new HashSet<>();
        for (int i = 0; i < listX.size(); i++)
            for (int j = 0; j < listY.size(); j++)
                if (listX.get(i) + listY.get(j) <= bound) listSum.add(listX.get(i) + listY.get(j));

        return new ArrayList<>(listSum);
    }
}
