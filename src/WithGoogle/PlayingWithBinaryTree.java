package WithGoogle;

public class PlayingWithBinaryTree {

    MyNode root;

    public PlayingWithBinaryTree() {
        root = null;
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

    void printPostOrder(MyNode node) {
        if (node == null) return;
        printPostOrder(node.leftNode);

        printPostOrder(node.rightNode);

        System.out.println(node.value + " ");

    }

    void printPostOrder() {
        printPostOrder(root);
    }

}

