package LeetCode.medium;

public class Problem2424 {
    //https://leetcode.com/problems/longest-uploaded-prefix/
    public static void main(String[] args) {
        /*LUPrefix luPrefix = new LUPrefix(4);
        luPrefix.upload(3);
        System.out.println(luPrefix.longest());
        luPrefix.upload(1);
        System.out.println(luPrefix.longest());
        luPrefix.upload(2);
        System.out.println(luPrefix.longest());*/

        LUPrefix luPrefix = new LUPrefix(10);
        System.out.println(luPrefix.longest());
        luPrefix.upload(6);
        System.out.println(luPrefix.longest());
        luPrefix.upload(10);
        luPrefix.upload(7);
        luPrefix.upload(4);
        System.out.println(luPrefix.longest());
        luPrefix.upload(2);
        System.out.println(luPrefix.longest());
        luPrefix.upload(8);
        luPrefix.upload(3);
        luPrefix.upload(1);
        System.out.println(luPrefix.longest());
    }


}
//https://leetcode.com/problems/longest-uploaded-prefix/solutions/4328501/java-array-max-value/
//15min
//Runtime
//26 ms
//Beats
//86.92%
//Memory
//106.6 MB
//Beats
//83.8%
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
                res = Math.max(i - 1, res);
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
