package LeetCode.hard;

import java.util.function.Function;

public class Problem149 {
    //https://leetcode.com/problems/max-points-on-a-line/
    public static void main(String[] args) {
        System.out.println(maxPoints(new int[][]{{54,153},{1,3},{0,-72},{-3,3},{12,-22},{-60,-322},{0,-5},{-5,1},{5,5},{36,78},{3,-4},{5,0},{0,4},{-30,-197},{-5,0},{60,178},{0,0},{30,53},{24,28},{4,5},{2,-2},{-18,-147},{-24,-172},{-36,-222},{-42,-247},{2,3},{-12,-122},{-54,-297},{6,-47},{-5,3},{-48,-272},{-4,-2},{3,-2},{0,2},{48,128},{4,3},{2,4}}));
        System.out.println(maxPoints(new int[][]{{4,5},{4,-1},{4,1}}));
        System.out.println(maxPoints(new int[][]{{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}}));
    }

    //https://leetcode.com/problems/max-points-on-a-line/solutions/3018295/java-98-memory-explained-in-details/
    //1 hour
    //Runtime
    //166 ms
    //Beats
    //11.13%
    //Memory
    //39.7 MB
    //Beats
    //98.36%

    //formula for line is y = k * x + b
    //also we know that any two points lie on a line
    //that means that we can derive a formula for this line
    //thus we can check other points by this formula
    //if the equation will be correct then this third point
    //also lies on this line

    static int maxPoints(int[][] p) {
        if (p.length == 1) return 1;
        int max = 2;
        for (int i = 0; i < p.length - 1; i++) {
            int x1 = p[i][0], y1 = p[i][1];
            for (int j = i + 1; j < p.length; j++) {
                int x2 = p[j][0], y2 = p[j][1];
                //to find k I use formula
                //(y2 - y1) / (x2 - x1)
                int count = 2;
                if (x2 == x1) {
                    for (int l = 0; l < p.length; l++) {
                        if (l == i || l == j) continue;
                        int x3 = p[l][0];
                        if (x3 == x1) count++;
                    }
                } else if (y2 == y1) {
                    for (int l = 0; l < p.length; l++) {
                        if (l == i || l == j) continue;
                        int y3 = p[l][1];
                        if (y3 == y2) count++;
                    }
                } else {
                    double k = (y2 * 1.0 - y1) / (x2 - x1);
                    double b = y1 - k * x1;
                    for (int l = 0; l < p.length; l++) {
                        if (l == i || l == j) continue;
                        int x3 = p[l][0], y3 = p[l][1];
                        double yPotential = k * x3 + b;
                        yPotential = Math.round(yPotential * 100.0) / 100.0;
                        if (y3 == yPotential) count++;
                    }
                }
                if (max < count) max = count;
            }
        }
        return max;
    }
}
