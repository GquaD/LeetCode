package Turing;

import java.util.Scanner;
import java.util.Stack;

public class SecondTestTask {
    //solution for valid parenthesis

    public static boolean isValid(String s) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            String current = String.valueOf(s.charAt(i));
            if (current.equals("(") || current.equals("[") || current.equals("{")) {
                stack.push(current);
            } else {
                if (current.equals(")") && !stack.peek().equals("(")
                        || current.equals("]") && !stack.peek().equals("[")
                        || current.equals("}") && !stack.peek().equals("{")) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return true;
    }
}

class MainTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (SecondTestTask.isValid(s)) {
            System.out.println("valid");
        } else {
            System.out.println("invalid");
        }
    }
}
