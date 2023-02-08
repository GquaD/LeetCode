package LeetCode.medium;

public class Problem904 {
    //https://leetcode.com/problems/fruit-into-baskets/description/
    public static void main(String[] args) {
        System.out.println(totalFruit(new int[]{1,0,1,4,1,4,1,2,3}));
        System.out.println(totalFruit(new int[]{0,0,1,1}));
        System.out.println(totalFruit(new int[]{1,2,2,3,2,3,2,3,4,3,4,3}));
        System.out.println(totalFruit(new int[]{1,2,3,2,2}));
        System.out.println(totalFruit(new int[]{0,1,2,2}));
        System.out.println(totalFruit(new int[]{1,2,1}));
    }


    //https://leetcode.com/problems/fruit-into-baskets/solutions/3159072/java-99-6-faster-solution/
    //30 min
    //Runtime
    //5 ms
    //Beats
    //99.60%
    //Memory
    //50.7 MB
    //Beats
    //83.3%
    static int totalFruit(int[] fruits) {
        if (fruits.length < 3) return fruits.length;
        int count = 1;
        for (int i = 1; i < fruits.length; i++) {
            if (fruits[i - 1] == fruits[i]) count++;
            else break;
        }
        if (count == fruits.length) return fruits.length;
        int countMax = count;
        int[] arr = new int[]{fruits[count - 1], fruits[count++]};
        for (int i = count; i < fruits.length; i++) {
            int curr = fruits[i];
            if (arr[0] == curr) {
                int temp = arr[0];
                arr[0] = arr[1];
                arr[1] = temp;
                count++;
            } else if (arr[1] == curr) {
                count++;
            } else {
                if (countMax < count) countMax = count;
                count = 1;
                putIntoStackOfTwo(arr, curr);
                for (int j = i - 1; j > 0; j--) {
                    if (fruits[j] == arr[0]) count++;
                    else break;
                }
            }
        }
        return Math.max(count, countMax);
    }

    private static int[] putIntoStackOfTwo(int[] arr, int n) {
        arr[0] = arr[1];
        arr[1] = n;
        return arr;
    }

    static int totalFruit1(int[] fruits) {
        if (fruits.length < 3) return fruits.length;
        int[] arr = new int[]{fruits[0], fruits[1]};
        int count = 2, countMax = count;
        for (int i = 2; i < fruits.length; i++) {
            int curr = fruits[i];
            if (arr[0] == curr || arr[1] == curr) {
                count++;
                if (countMax < count) countMax = count;
            } else {

            }
        }
        return 1;
    }
}
