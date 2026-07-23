package LeetCode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem3000 {
    //5min

    //Runtime
    //5
    //ms
    //Beats
    //2.85%
    //Memory
    //46.77
    //MB
    //Beats
    //11.21%
    //https://leetcode.com/problems/maximum-area-of-longest-diagonal-rectangle/solutions/8414124/java-onlogn-solution-with-custom-compara-5jx2/
    public int areaOfMaxDiagonal(int[][] dimensions) {
        List<Rec> list = new ArrayList<>();

        for (int[] rec: dimensions) {
            list.add(new Rec(rec[0], rec[1]));
        }

        Collections.sort(list, (a, b) -> {
            if (a.getDiag() > b.getDiag()) {
                return 1;
            }
            if (a.getDiag() < b.getDiag()) {
                return -1;
            }
            if (a.getArea() > b.getArea()) {
                return 1;
            }

            if (a.getArea() < b.getArea()) {
                return -1;
            }

            return 0;
        });

        return list.get(list.size() - 1).getArea();
    }
}

class Rec {
    double diag;
    int area;

    public Rec(int len, int wid) {
        diag = Math.sqrt(len * len + wid * wid);
        area = len * wid;
    }

    public int getArea() {
        return area;
    }

    public double getDiag() {
        return diag;
    }
}
