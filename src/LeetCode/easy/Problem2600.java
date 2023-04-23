package LeetCode.easy;

public class Problem2600 {
    //https://leetcode.com/problems/k-items-with-the-maximum-sum/
    public static void main(String[] args) {
        System.out.println(kItemsWithMaximumSum(3,2,3,6));
        System.out.println(kItemsWithMaximumSum(3,2,0,4));
        System.out.println(kItemsWithMaximumSum(3,2,0,2));
    }

    //https://leetcode.com/problems/k-items-with-the-maximum-sum/solutions/3445770/java-3-lines-100-faster-solution/
    //Runtime
    //1 ms
    //Beats
    //99.89%
    //Memory
    //40.2 MB
    //Beats
    //71.9%
    static int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (numOnes >= k) return k;
        else if (numZeros >= k - numOnes) return k - (k - numOnes);
        else return k - (k - numOnes) - Math.min(numNegOnes, k -numOnes - numZeros);
    }
}
