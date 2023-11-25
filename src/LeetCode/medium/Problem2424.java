package LeetCode.medium;

public class Problem2424 {
    //https://leetcode.com/problems/longest-uploaded-prefix/
    public static void main(String[] args) {
        LUPrefix luPrefix = new LUPrefix(4);
        luPrefix.upload(3);
        System.out.println(luPrefix.longest());
        luPrefix.upload(1);
        System.out.println(luPrefix.longest());
        luPrefix.upload(2);
        System.out.println(luPrefix.longest());
    }


}

//Wrong Answer
//18 / 24 testcases passed
class LUPrefix {

    int res;
    int max;
    int[] arr;

    public LUPrefix(int n) {
        res = 0;
        max = 0;
        arr = new int[n + 1];
    }

    public void upload(int video) {
        arr[video]++;
        max = Math.max(video, max);
        if (video == res + 1) {
            res++;
        }
        boolean exists = true;
        for (int i = res; i <= max; i++) {
            if (arr[i] == 0) {
                exists = false;
                break;
            }
        }
        if (exists) res = max;
    }

    public int longest() {
        return res;
    }
}
