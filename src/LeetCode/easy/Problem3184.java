package LeetCode.easy;

public class Problem3184 {
    //https://leetcode.com/problems/count-pairs-that-form-a-complete-day-i/
    public static void main(String[] args) {

    }

    //1min (same as 3185)
    //Runtime
    //1
    //ms
    //Beats
    //98.02%
    //Analyze Complexity
    //Memory
    //41.99
    //MB
    //Beats
    //95.20%
    int countCompleteDayPairs(int[] hours) {
        int[] arr = new int[24];
        for (int i = 0; i < hours.length; i++) {
            hours[i] = hours[i] % 24;
            arr[hours[i]]++;
        }
        int res = 0;
        for (int i = 0; i < 24; i++) {
            int f = arr[i];
            if (i == 0 || i == 12) {
                res += (f * (f - 1L)) / 2L;
            } else {
                if (arr[24 - i] > 0) {
                    int f2 = arr[24 - i];
                    res += f * f2;
                    arr[i] = 0;
                }
            }
        }
        return res;
    }
}
