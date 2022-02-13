package LeetCode.Recursion;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        List<Integer> result = getRow2(24);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + ", ");
        }
    }
    //solution #2 best
    static List<Integer> getRow1(int rowIndex) {
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; i++) {
            pascalList(i, resultList);
        }

        return resultList.get(resultList.size() - 1);
    }
    //solution #3
    static List<Integer> getRow2(int rowIndex) {
        List<Integer> listPrev;
        List<Integer> listCurrent = new ArrayList<>();
        if (rowIndex == 0) {
            return pascalListNoBigList(rowIndex, null);
        } else if (rowIndex == 1) {
            return pascalListNoBigList(rowIndex, null);
        }

        listPrev = pascalListNoBigList(1, null);
        for (int i = 1; i < rowIndex + 1; i++) {
            listCurrent = pascalListNoBigList(i, listPrev);
            listPrev = listCurrent;
        }

        return listCurrent;
    }

    static List<Integer> pascalListNoBigList(int rowIndex, List<Integer> lastRow) {
        List<Integer> row = new ArrayList<>();
        if (rowIndex == 0) {
            row.add(1);
            return row;
        } else if (rowIndex == 1) {
            row.add(1);
            row.add(1);
            return row;
        } else {
            row.add(1);
            for (int i = 1; i < rowIndex; i++) {
                row.add(lastRow.get(i) + lastRow.get(i - 1));
            }
            row.add(1);
            return row;
        }
    }

    static void pascalList(int rowIndex, List<List<Integer>> list) {
        List<Integer> row = new ArrayList<>();
        if (rowIndex == 0) {
            row.add(1);
        } else if (rowIndex == 1) {
            row.add(1);
            row.add(1);
        } else {
            List<Integer> lastRow = list.get(list.size() - 1);
            row.add(1);
            for (int i = 1; i < rowIndex; i++) {
                row.add(lastRow.get(i) + lastRow.get(i - 1));
            }
            row.add(1);
        }
        list.add(row);
    }
    //solution #1 using recursive function
    static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; i++) {
            result.add(i, pascalTriangleCalc(rowIndex, i));
        }
        return result;
    }

    private static Integer pascalTriangleCalc(int rowIndex, int i) {
        //solution is correct but time consuming
        if (rowIndex == 0 && i == 0) return 1;
        if (rowIndex < 0 || i < 0) return 0;

        return pascalTriangleCalc(rowIndex - 1, i - 1) + pascalTriangleCalc(rowIndex - 1, i);
    }
}
