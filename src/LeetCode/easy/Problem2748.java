package LeetCode.easy;

public class Problem2748 {
    //https://leetcode.com/problems/number-of-beautiful-pairs/
    public static void main(String[] args) {
        System.out.println(countBeautifulPairs(new int[]{2,5,1,4}));
    }

    //https://leetcode.com/problems/number-of-beautiful-pairs/solutions/3887755/java-simple-solution/
    //5-10 min
    //Runtime
    //32 ms
    //Beats
    //68.88%
    //Memory
    //43.8 MB
    //Beats
    //33.55%
    static int countBeautifulPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) for (int j = i + 1; j < nums.length; j++) if (coprime(nums[i], nums[j])) count++;
        return count;
    }

    private static boolean coprime(int a, int b) {
        int one = Integer.toString(a).charAt(0) - '0', two = b % 10;
        for (int i = 2; i < 10; i++) if (one % i == 0 && two % i == 0) return false;
        return true;
    }


}
