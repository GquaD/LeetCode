package LeetCode.medium;

public class Problem1111 {
    //10-15min
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Memory
    //45.16
    //MB
    //Beats
    //91.06%
    public int[] maxDepthAfterSplit(String seq) {
        int open = 0, res[] = new int[seq.length()];

        for (int i = 0; i < res.length; i++) {
            if (seq.charAt(i) == '(') {
                open++;
                res[i] = open % 2 == 1 ? 0 : 1;
            } else {
                res[i] = open % 2 == 1 ? 0 : 1;
                open--;
            }
        }

        return res;
    }
}
