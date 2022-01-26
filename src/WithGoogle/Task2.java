package WithGoogle;

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        int[] array1 = new int[]{1, 4, 7};
        int[] array2 = new int[]{19, 14, 28};
        int[] array3 = new int[]{7, 3, 5, 1};

        int[] result1 = solution(3, array1);
        System.out.println(Arrays.toString(result1) + " and must be [3, 6, -1]");
        int[] result2 = solution(5, array2);
        System.out.println(Arrays.toString(result2) + " and must be [21, 15, 29]");
        int[] result3 = solution(3, array3);
        System.out.println(Arrays.toString(result3) + " and must be [-1, 7, 6, 3]");
    }

    public static int[] solution(int h, int[] data) {
        int[] result = new int[data.length];

        //built binary tree
        int rootNum = (pow(2, h) - 1);
        MyNode root = buildBinaryTree(rootNum);


        for (int i = 0; i < data.length; i++) {
            int current = data[i];
            if (current != rootNum) {
                result[i] = findTop(current);
            } else {
                result[i] = -1;
            }
        }
        return result;
    }

    private static MyNode buildBinaryTree(int rootNum) {
        MyNode node = new MyNode(rootNum);
        if (rootNum == 1) {
            return node;
        }
        node.leftNode = buildBinaryTree(rootNum / 2);
        node.rightNode = buildBinaryTree(rootNum - 1);
        return node;
    }

    static int findTop(int num) {
        return num % 2 == 0 ? num + 1 : num + 2;
    }

    static int pow(int num, int power) {
        for (int i = 1; i < power; i++) {
            num *= 2;
        }
        return num;
    }

    static class MyNode {
        int value;
        MyNode leftNode, rightNode;

        public MyNode(int num)
        {
            value = num;
            leftNode = rightNode = null;
        }
    }
}
