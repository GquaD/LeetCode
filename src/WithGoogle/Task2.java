package WithGoogle;

import java.util.Arrays;
import java.util.Enumeration;

//DONE!
public class Task2 {
    public static void main(String[] args) {
        int[] array1 = new int[]{1, 4, 7};
        int[] array2 = new int[]{19, 14, 28};
        int[] array3 = new int[]{7, 3, 5, 1};

        //one test
        //1 build tree
        MyNode root = buildBinaryTree(31, 5);
        System.out.println("\nroot = " + root.value);
        //2 retrieve roots for given numbers
        int myNum = 7;
        int num = getParentOfNum(root, myNum);
        System.out.println("parent of " + myNum + " is " + num);
        //3 place them into array and run
        int[] result = new int[array2.length];
        for (int i = 0; i < array2.length; i++) {
            result[i] = getParentOfNum(root, array2[i]);
        }
        System.out.println(Arrays.toString(result) + " and must be [21, 15, 29]");

        //running tests extra tests
        int[] result1 = solution(3, array1);
        System.out.println(Arrays.toString(result1) + " and must be [3, 6, -1]");
        int[] result2 = solution(5, array2);
        System.out.println(Arrays.toString(result2) + " and must be [21, 15, 29]");
        int[] result3 = solution(3, array3);
        System.out.println(Arrays.toString(result3) + " and must be [-1, 7, 6, 3]");


        System.out.println();

        System.out.println();
        //binary tree printing elements
        buildBinaryTree1(31, 5);
    }

    static int[] solution(int h, int[] q) {
        int rootNum = pow(2, h) - 1;
        MyNode root = buildBinaryTree(rootNum, h);

        int[] result = new int[q.length];
        for (int i = 0; i < q.length; i++) {
            result[i] = getParentOfNum(root, q[i]);
        }

        return result;
    }

    static int pow(int num, int power) {
        for (int i = 1; i < power; i++) {
            num *= 2;
        }
        return num;
    }

    //builder for postorder binary tree
    private static MyNode buildBinaryTree(int rootNum, int pow) {
        MyNode node = new MyNode(rootNum);
        if (rootNum <= 1 || pow <= 1) {
            return node;
        }
        node.leftNode = buildBinaryTree(rootNum - pow(2, pow - 1), pow - 1);

        node.rightNode = buildBinaryTree(rootNum - 1, pow - 1);

        return node;
    }

    //search for parent of given number in the postorder tree
    private static int getParentOfNum(MyNode rootOfTheTree, int myNum) {
        if (rootOfTheTree.value == myNum) return -1;
        MyNode root = rootOfTheTree;
        MyNode left = rootOfTheTree.leftNode;
        MyNode right = rootOfTheTree.rightNode;
        int result = -1;
        if (left != null && right != null) {
            if (left.value == myNum || right.value == myNum) {
                return root.value;
            } else {
                result = getParentOfNum(left, myNum);
                if (result != -1) return result;
                result = getParentOfNum(right, myNum);
            }
        }
        return result;
    }

    private static class MyNode {
        int value;
        MyNode leftNode, rightNode;

        public MyNode(int num)
        {
            value = num;
            leftNode = rightNode = null;
        }
    }


    //code below is not needed
    public static int[] solution1(int h, int[] data) {
        int[] result = new int[data.length];

        //built binary tree
        int rootNum = (pow(2, h) - 1);
        MyNode root = buildBinaryTree(rootNum, h);


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

    private static MyNode buildBinaryTree1(int rootNum, int pow) {
        MyNode node = new MyNode(rootNum);
        if (rootNum <= 1 || pow <= 1) {
            return node;
        }
        node.leftNode = buildBinaryTree1(rootNum - pow(2, pow - 1), pow - 1);
        System.out.print("[ left = " + node.leftNode.value + " ");
        node.rightNode = buildBinaryTree1(rootNum - 1, pow - 1);
        System.out.print("right = " + node.rightNode.value + " ");
        System.out.print("value = " + node.value + " ] ");
        return node;
    }

    static int findTop(int num) {
        return num % 2 == 0 ? num + 1 : num + 2;
    }
}
