package LeetCode.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem3484 {
    //https://leetcode.com/problems/design-spreadsheet/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/design-spreadsheet/solutions/6555367/java-solution-explained-by-tbekpro-x1de/
    //10min
    //Runtime
    //127
    //ms
    //Beats
    //40.84%
    //Analyze Complexity
    //Memory
    //56.07
    //MB
    //Beats
    //67.86%
    class Spreadsheet {
        Map<Integer, Integer>[] sheet;
        public Spreadsheet(int rows) {
            sheet = new Map[26];
            for (int i = 0; i < 26; i++) {
                sheet[i] = new HashMap<>();
            }
        }

        public void setCell(String cell, int value) {
            Map<Integer, Integer> col = sheet[cell.charAt(0) - 'A'];
            int row = Integer.parseInt(cell.substring(1));
            col.put(row, value);
        }

        public void resetCell(String cell) {
            setCell(cell, 0);
        }

        public int getValue(String formula) {
            String[] split = formula.split("\\+");
            int a = 0, b = 0;
            String x = split[0], y = split[1];
            if (x.charAt(1) >= '0' && x.charAt(1) <= '9') {
                a = Integer.parseInt(x.substring(1));
            } else {
                Map<Integer, Integer> col = sheet[x.charAt(1) - 'A'];
                int row = Integer.parseInt(x.substring(2));
                if (col.containsKey(row)) a = col.get(row);
            }
            if (y.charAt(0) >= '0' && y.charAt(0) <= '9') {
                b = Integer.parseInt(y.substring(0));
            } else {
                Map<Integer, Integer> col = sheet[y.charAt(0) - 'A'];
                int row = Integer.parseInt(y.substring(1));
                if (col.containsKey(row)) b = col.get(row);
            }
            return a + b;
        }
    }
}
