package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Problem2194 {
    //https://leetcode.com/problems/cells-in-a-range-on-an-excel-sheet/

    static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {
        List<String> cells = cellsInRange("C1:F2");
        for (int i = 0; i < cells.size(); i++) {
            System.out.print(cells.get(i) + ", ");
        }
        //result must be: C1, C2, D1, D2, E1, E2, F1, F2,
    }

    public static List<String> cellsInRange(String s) {
        List<String> result = new ArrayList<>();
        String[] cells = s.split(":");
        String tempCell = cells[0];
        int firstNum = getNumber(tempCell);
        String finalCell = cells[1];
        int num2 = getNumber(finalCell);
        while (!tempCell.equals(finalCell)) {
            int num1 = getNumber(tempCell);
            if (num1 == num2) {
                result.add(getLetter(tempCell) + num1);
                tempCell = getNextLetter(getLetter(tempCell)) + firstNum;
                continue;
            }
            result.add(tempCell);
            tempCell = getLetter(tempCell) + ++num1;
        }
        result.add(finalCell);
        return result;
    }

    static String getLetter(String cell) {
        return cell.charAt(0) + "";
    }

    static int getNumber(String cell) {
        return Integer.parseInt(cell.substring(1) + "");
    }

    static int getPositionOfLetter(String letter) {

        for (int i = 0; i < alphabet.length(); i++) {
            if (letter.equals(alphabet.charAt(i) + "")) {
                return i;
            }
        }
        return -1;
    }

    static String getNextLetter(String letter) {
        int position = getPositionOfLetter(letter);
        return alphabet.charAt(position + 1) + "";
    }
}
