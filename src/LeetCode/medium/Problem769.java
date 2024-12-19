package LeetCode.medium;


public class Problem769 {
    //https://leetcode.com/problems/max-chunks-to-make-sorted/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/max-chunks-to-make-sorted/solutions/6163890/java-running-sum-one-pass-solution-by-tb-i0j5/
    //20min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //41.38
    //MB
    //Beats
    //6.72%
    public int maxChunksToSorted(int[] arr) {
        int res = 0, suma = 0, sumb = 0;
        for (int i = 0; i < arr.length; i++) {
            suma += arr[i];
            sumb += i;
            if (suma == sumb)
                res++;
        }
        return res;
    }


//    static int[] arraySorted = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//
//    static int maxChunksToSorted(int[] arr) {
//        int[] arrSorted = Arrays.copyOf(arr, arr.length);
//        Arrays.sort(arrSorted);
//        int countGood = 0, idxS = -1, countBad = 0;
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] == arrSorted[i]) {
//                countGood++;
//            } else {
//                if (idxS == -1) {
//                    idxS = i;
//                } else {
//                    countBad += (i - idxS + 1);
//                    idxS = -1;
//                }
//            }
//        }
//        return 42;
//    }
//
//    static int maxChunksToSorted1(int[] arr) {
//        int[] copy = Arrays.copyOf(arr, arr.length);
//        Arrays.sort(copy);
//        int count = 1;
//        for (int i = 0; i < arr.length; i++) if (arr[i] == copy[i]) count++;
//        return count;
//    }
}
