package LeetCode.medium;

public class Problem1664 {
    //https://leetcode.com/problems/ways-to-make-a-fair-array/
    public static void main(String[] args) {
        System.out.println(3 == waysToMakeFair(new int[]{1,1,1}));
        System.out.println(1 == waysToMakeFair(new int[]{2,1,6,4}));
        System.out.println(0 == waysToMakeFair(new int[]{1,1,1,1,1,1,1,1}));
        System.out.println(0 == waysToMakeFair(new int[]{1,1,1,1}));
        System.out.println(0 == waysToMakeFair(new int[]{1,2,3}));
        System.out.println(0 == waysToMakeFair(new int[]{1,10,100,1000,10000}));
    }

    //https://leetcode.com/problems/ways-to-make-a-fair-array/solutions/4447121/java-o-n-prefix-and-postfix-sum/
    //1hour
    //Runtime
    //6 ms
    //Beats
    //76.65%
    //Memory
    //58.1 MB
    //Beats
    //5.58%
    static int waysToMakeFair(int[] nums) {
        int sumEven = 0, sumOdd = 0, res = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) sumEven += nums[i];
            else sumOdd += nums[i];
        }

        int remEven = sumEven, remOdd = sumOdd, preEven = 0, preOdd = 0;

        for (int i = 0; i < nums.length; i++) {
            int t1, t2;
            if (i % 2 == 0) {
                t1 = preEven + remOdd;
                t2 = preOdd + remEven - nums[i];
                preEven += nums[i];
                remEven -= nums[i];
            } else {
                t1 = preOdd + remEven;
                t2 = preEven + remOdd - nums[i];
                preOdd += nums[i];
                remOdd -= nums[i];
            }
            if (t1 == t2) res++;
        }
        return res;
    }

    static int waysToMakeFair2(int[] nums) {
        int sumEven = 0, sumOdd = 0, res = 0, sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) sumEven += nums[i];
            else sumOdd += nums[i];
            sum += nums[i];
        }

        int preEven = 0, preOdd = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            int t1, t2;
            if (i % 2 == 0) {
                if (preOdd == 0 || preEven == 0) {
                    t1 = sumEven - nums[i];
                    t2 = sumOdd;
                } else {
                    t1 = sumEven - nums[i];
                    t1 += sumOdd - preOdd;

                    t2 = sum - t1 - nums[i];
                }
                if (t1 == t2) res++;
                preEven += nums[i];
            } else {
                if (preOdd == 0 || preEven == 0) {
                    t1 = sumOdd - nums[i];
                    t2 = sumEven;
                } else {
                    t1 = sumOdd - nums[i];
                    t1 += sumEven - preEven ;

                    t2 = sum - t1 - nums[i];
                }
                if (t1 == t2) res++;
                preOdd += nums[i];
            }
        }

        if (nums.length >= 2) {
            int i = nums.length - 2;
            if ((i) % 2 == 0) {
                if (sumEven - nums[i] + nums[i + 1] == sumOdd - nums[i + 1]) res++;
            } else {
                if (sumOdd - nums[i] + nums[i + 1] == sumEven - nums[i + 1]) res++;
            }
        }

        int i = nums.length - 1;
        if ((i) % 2 == 0) {
            if(sumEven - nums[i] == sumOdd) res++;
        } else {
            if (sumOdd - nums[i] == sumEven) res++;
        }
        return res;
    }

    static int waysToMakeFair1(int[] nums) {
        int sumEven = 0, sumOdd = 0, res = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) sumEven += nums[i];
            else sumOdd += nums[i];
        }

        int preEven = 0, preOdd = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            if (i % 2 == 0) {
                // int t1 = sumEven - nums[i] - preEven;
                // int t2 = sumOdd - preOdd;
                int t1 = preOdd + sumEven - nums[i];
                int t2 = preEven + sumOdd - preOdd;
                if (t1 == t2) res++;
                preEven += nums[i];//2
            } else {
                // int t1 = sumOdd - nums[i] - preOdd;
                int t1 = preEven + sumOdd - nums[i];
                int t2 = preOdd + sumEven - preEven;
                if (t1 == t2) res++;
                preOdd += nums[i];
            }
        }

        if (nums.length >= 2) {
            int i = nums.length - 2;
            if ((i) % 2 == 0) {
                if (sumEven - nums[i] + nums[i + 1] == sumOdd - nums[i + 1]) res++;
            } else {
                if (sumOdd - nums[i] + nums[i + 1] == sumEven - nums[i + 1]) res++;
            }
        }

        int i = nums.length - 1;
        if ((i) % 2 == 0) {
            if(sumEven - nums[i] == sumOdd) res++;
        } else {
            if (sumOdd - nums[i] == sumEven) res++;
        }
        return res;
    }
}
