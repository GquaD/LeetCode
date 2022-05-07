package Turing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestTask {
    //solution for baseball test task

    static List<Integer> listWithResults = new ArrayList<>();

    public static int calPoints(String[] ops) {
        for (String s : ops) {
            calcNext(s);
        }

        int result = listWithResults.stream()
                .reduce(0, Integer::sum);

        return result;
    }

    static void calcNext(String actionLetter) {
        int size = listWithResults.size();
        switch (actionLetter.toUpperCase()) {
            case "+": {
                int result = listWithResults.get(size - 1) + listWithResults.get(size - 2);
                listWithResults.add(result);
                break;
            }
            case "D": {
                int result = listWithResults.get(size - 1) * 2;
                listWithResults.add(result);
                break;
            }

            case "C": {
                listWithResults.remove(size - 1);
                break;
            }

            default: {
                listWithResults.add(Integer.parseInt(actionLetter));
            }
        }
    }


}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ops = sc.nextLine().split(" ");
        System.out.println(TestTask.calPoints(ops));
    }
}
