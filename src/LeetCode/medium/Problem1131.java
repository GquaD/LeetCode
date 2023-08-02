package LeetCode.medium;

public class Problem1131 {
    //https://leetcode.com/problems/maximum-of-absolute-value-expression/
    public static void main(String[] args) {
//        System.out.println(maxAbsValExpr(new int[]{1,2,3,4}, new int[]{-1,4,5,6}));
//        System.out.println(maxAbsValExpr(new int[]{1,-2,-5,0,10}, new int[]{0,-2,-1,-7,-4}));
        System.out.println(maxAbsValExpr(new int[]{2,2,6,1,-7,-1,-7}, new int[]{6,1,-2,-10,-7,-6,-10}));
    }

    //https://leetcode.com/problems/maximum-of-absolute-value-expression/solutions/3854039/java-math-solution/
    //nnnn
    //30 min
    //Runtime
    //5 ms
    //Beats
    //92.41%
    //Memory
    //53.8 MB
    //Beats
    //9.49%
    static int maxAbsValExpr(int[] arr1, int[] arr2) {
        if (arr1.length == 2) return Math.abs(arr1[0] - arr1[1]) + Math.abs(arr2[0] - arr2[1]) + 1;
        int one = 0, two = 0, three = 0, four = 0;
        int i1 = 0, i2 = 0, i3 = 0, i4 = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (one < arr1[i] + arr2[i] + i) {
                one = arr1[i] + arr2[i] + i;
                i1 = i;
            }
            if (two < arr1[i] - arr2[i] + i) {
                two = arr1[i] - arr2[i] + i;
                i2 = i;
            }
            if (three < -arr1[i] + arr2[i] + i) {
                three = -arr1[i] + arr2[i] + i;
                i3 = i;
            }
            if (four < -arr1[i] - arr2[i] + i) {
                four = -arr1[i] - arr2[i] + i;
                i4 = i;
            }
        }
        int one1 = Integer.MAX_VALUE, two1 = Integer.MAX_VALUE, three1 = Integer.MAX_VALUE, four1 = Integer.MAX_VALUE;
        for (int i = 0; i < arr1.length; i++) {
            if (one1 > arr1[i] + arr2[i] + i && i1 != i) one1 = arr1[i] + arr2[i] + i;
            if (two1 > arr1[i] - arr2[i] + i && i2 != i) two1 = arr1[i] - arr2[i] + i;
            if (three1 > -arr1[i] + arr2[i] + i && i3 != i) three1 = -arr1[i] + arr2[i] + i;
            if (four1 > -arr1[i] - arr2[i] + i && i4 != i) four1 = -arr1[i] - arr2[i] + i;
        }
        return Math.max(Math.max(one - one1, two - two1), Math.max(three - three1, four - four1));
    }

    //Wrong Answer
    //6 / 21 testcases passed
    static int maxAbsValExpr2(int[] arr1, int[] arr2) {
        int i1 = 0, j1 = 0, max1 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE;
        for (int i = 0; i < arr1.length; i++) {
            if (max1 < arr1[i]) {
                max1 = arr1[i];
                i1 = i;
            }
            if (min1 > arr1[i]) {
                min1 = arr1[i];
                j1 = i;
            }
        }
        int i2 = 0, j2 = 0, max2 = Integer.MIN_VALUE, min2 = Integer.MAX_VALUE;
        for (int i = 0; i < arr2.length; i++) {
            if (max2 < arr2[i]) {
                max2 = arr2[i];
                i2 = i;
            }
            if (min2 > arr2[i]) {
                min2 = arr2[i];
                j2 = i;
            }
        }
        int res1 = Math.abs(max1 - min1) + Math.abs(arr2[i1] - arr2[j1]) + Math.abs(i1 - j1);
        int res2 = Math.abs(max2 - min2) + Math.abs(arr1[i2] - arr1[j2]) + Math.abs(i2 - j2);
        return Math.max(res1, res2);
    }
}
