package taskstop;

public class ThirdTask {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2,1,3}, 2));
        System.out.println(solution(new int[]{0,4,3,-1}, 2));
        System.out.println(solution(new int[]{2,1,4}, 3));
        System.out.println(solution(new int[]{1,4,4,5}, 3));
    }


    //3
    static int solution(int[] A, int S) {
        int countFragments = 0;
        for (int i = 0; i < A.length; i++) {
            int counter = i;
            while (counter < A.length) {
                if (meanCorrect(i, counter, A, S)) {
                    countFragments++;
                }
                counter++;
            }
        }
        return Math.min(countFragments, 1_000_000_000);
    }

    private static boolean meanCorrect(int start, int end, int[] arr, int s) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += arr[i];
        }
        double result = (sum * 1.0) / (end - start + 1);
        return result == s;
    }
}
