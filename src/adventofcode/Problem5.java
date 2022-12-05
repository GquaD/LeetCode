package adventofcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Stack;

public class Problem5 {
    private static final String PATH1 = Utility.FILE_PATH + "input5_1.txt";
    private static final String PATH2 = Utility.FILE_PATH + "input5_2.txt";

    public static void main(String[] args) {
        try {
            one(PATH1); //CNHFPJRJG not correct | CVCWCRTVQ correct
            System.out.println("////////////////");
            two(PATH1);
            System.out.println("////////////////");
            three(PATH2);
            four(PATH2);
//            one(PATH2);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public static void four(String path) throws IOException {
        BufferedReader in = Utility.getReader(path);
        String line = in.readLine();
        String[] blocks = new String[9];
        Stack<Character>[] stacks = new Stack[9];
        for (int i = 0; i < stacks.length; i++) {
            stacks[i] = new Stack<>();
            blocks[i] = "";
        }
        //fillStacks(stacks);
        int count = 0;
        Stack<Character> stackTemp = new Stack<>();
        while (line != null) {
            count++;
            if (count < 9) {
                int charIdx = 1;
                for (int i = 0; i < stacks.length; i++) {
                    char c = line.charAt(charIdx);
                    if (c >= 'A' && c <= 'Z') {
                        blocks[i] += c;
                    }
                    charIdx += 4;
                }
                line = in.readLine();
                continue;
            }
            if (count == 9) {
                fillStacks(blocks, stacks);
                line = in.readLine();
                continue;
            }
            if (count < 11) {
                line = in.readLine();
                continue;
            }
            String[] cmd = line.split(" ");
            int amount = Integer.parseInt(cmd[1]);
            int from = Integer.parseInt(cmd[3]) - 1;
            int to = Integer.parseInt(cmd[5]) - 1;
            for (int i = 0; i < amount; i++) {
                stackTemp.push(stacks[from].pop());
            }
            while (!stackTemp.empty()) {
                stacks[to].push(stackTemp.pop());
            }
            line = in.readLine();
        }
        StringBuilder sb = new StringBuilder();
        for (Stack<Character> stack : stacks) {
            sb.append(stack.peek());
        }
        System.out.println("result of Part2_2: " + sb);
    }

    public static void three(String path) throws IOException {
        BufferedReader in = Utility.getReader(path);
        String line = in.readLine();
        String[] blocks = new String[9];
        Stack<Character>[] stacks = new Stack[9];
        for (int i = 0; i < stacks.length; i++) {
            stacks[i] = new Stack<>();
            blocks[i] = "";
        }
        //fillStacks(stacks);
        int count = 0;
        while (line != null) {
            count++;
            if (count < 9) {
                int charIdx = 1;
                for (int i = 0; i < stacks.length; i++) {
                    char c = line.charAt(charIdx);
                    if (c >= 'A' && c <= 'Z') {
                        blocks[i] += c;
                    }
                    charIdx += 4;
                }
                line = in.readLine();
                continue;
            }
            if (count == 9) {
                fillStacks(blocks, stacks);
                line = in.readLine();
                continue;
            }
            if (count < 11) {
                line = in.readLine();
                continue;
            }
            String[] cmd = line.split(" ");
            int amount = Integer.parseInt(cmd[1]);
            int from = Integer.parseInt(cmd[3]) - 1;
            int to = Integer.parseInt(cmd[5]) - 1;
            for (int i = 0; i < amount; i++) {
                stacks[to].push(stacks[from].pop());
            }
            line = in.readLine();
        }
        StringBuilder sb = new StringBuilder();
        for (Stack<Character> stack : stacks) {
            sb.append(stack.peek());
        }
        System.out.println("result of Part2_1: " + sb);
    }

    private static void fillStacks(String[] blocks, Stack<Character>[] stacks) {
        for (int i = 0; i < blocks.length; i++) {
            String tower = blocks[i];
            for (int j = tower.length() - 1; j >= 0; j--) {
                stacks[i].push(tower.charAt(j));
            }
        }
    }

    public static void two(String path) throws IOException {
        BufferedReader in = Utility.getReader(path);
        String line = in.readLine();
        Stack<Character>[] stacks = new Stack[9];
        for (int i = 0; i < stacks.length; i++) {
            stacks[i] = new Stack<>();
        }
        fillStacks(stacks);
        int count = 1;
        Stack<Character> stackTemp = new Stack<>();
        while (line != null) {
            if (count++ < 11) {
                line = in.readLine();
                continue;
            }
            String[] cmd = line.split(" ");
            int amount = Integer.parseInt(cmd[1]);
            int from = Integer.parseInt(cmd[3]) - 1;
            int to = Integer.parseInt(cmd[5]) - 1;
            for (int i = 0; i < amount; i++) {
                stackTemp.push(stacks[from].pop());
            }
            while (!stackTemp.empty()) {
                stacks[to].push(stackTemp.pop());
            }
            line = in.readLine();
        }
        StringBuilder sb = new StringBuilder();
        for (Stack<Character> stack : stacks) {
            sb.append(stack.peek());
        }
        System.out.println("result of Part 2: " + sb);
    }

    public static void one(String path) throws IOException {
        BufferedReader in = Utility.getReader(path);
        String line = in.readLine();
        Stack<Character>[] stacks = new Stack[9];
        for (int i = 0; i < stacks.length; i++) {
            stacks[i] = new Stack<>();
        }
        fillStacks(stacks);
        int count = 1;
        while (line != null) {
            if (count++ < 11) {
                line = in.readLine();
                continue;
            }
            String[] cmd = line.split(" ");
            int amount = Integer.parseInt(cmd[1]);
            int from = Integer.parseInt(cmd[3]) - 1;
            int to = Integer.parseInt(cmd[5]) - 1;
            for (int i = 0; i < amount; i++) {
                stacks[to].push(stacks[from].pop());
            }
            line = in.readLine();
        }
        StringBuilder sb = new StringBuilder();
        for (Stack<Character> stack : stacks) {
            sb.append(stack.peek());
        }
        System.out.println("result of Part 1: " + sb);
    }

    private static void fillStacks(Stack[] stacks) {
        stacks[0].push('W');
        stacks[0].push('R');
        stacks[0].push('F');

        stacks[1].push('T');
        stacks[1].push('H');
        stacks[1].push('M');
        stacks[1].push('C');
        stacks[1].push('D');
        stacks[1].push('V');
        stacks[1].push('W');
        stacks[1].push('P');

        stacks[2].push('P');
        stacks[2].push('M');
        stacks[2].push('Z');
        stacks[2].push('N');
        stacks[2].push('L');

        stacks[3].push('J');
        stacks[3].push('C');
        stacks[3].push('H');
        stacks[3].push('R');

        stacks[4].push('C');
        stacks[4].push('P');
        stacks[4].push('G');
        stacks[4].push('H');
        stacks[4].push('Q');
        stacks[4].push('T');
        stacks[4].push('B');

        stacks[5].push('G');
        stacks[5].push('C');
        stacks[5].push('W');
        stacks[5].push('L');
        stacks[5].push('F');
        stacks[5].push('Z');

        stacks[6].push('W');
        stacks[6].push('V');
        stacks[6].push('L');
        stacks[6].push('Q');
        stacks[6].push('Z');
        stacks[6].push('J');
        stacks[6].push('G');
        stacks[6].push('C');

        stacks[7].push('P');
        stacks[7].push('N');
        stacks[7].push('R');
        stacks[7].push('F');
        stacks[7].push('W');
        stacks[7].push('T');
        stacks[7].push('V');
        stacks[7].push('C');

        stacks[8].push('J');
        stacks[8].push('W');
        stacks[8].push('H');
        stacks[8].push('G');
        stacks[8].push('R');
        stacks[8].push('S');
        stacks[8].push('V');
    }
}
