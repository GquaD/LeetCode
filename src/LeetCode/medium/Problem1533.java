package LeetCode.medium;

public class Problem1533 {
    //https://leetcode.com/problems/find-the-index-of-the-large-integer

    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-the-index-of-the-large-integer/solutions/5855720/java-o-logn-solution/
    //15min
    //Runtime
    //3
    //ms
    //Beats
    //98.25%
    //Analyze Complexity
    //Memory
    //89.64
    //MB
    //Beats
    //65.79%
    /*public int getIndex(ArrayReader reader) {
        int len = reader.length();
        int l = 0, r = len / 2, x = r + 1, y = len - 1;
        if (len % 2 == 0) {
            r = (len / 2) - 1;
            x = r + 1;
        } else {
            x = r;
        }
        int idx = -1;
        while (true) {
            int res = reader.compareSub(l, r, x, y);
            if (res > 0) {
                if ((l + r + 1) % 2 == 0) {
                    int mid = (l + r) / 2;
                    y = r;
                    r = mid;
                    x = mid + 1;
                } else {
                    int mid = (l + r) / 2;
                    y = r;
                    r = mid;
                    x = mid;
                }
            } else if (res < 0) {
                if ((x + y + 1) % 2 == 0) {
                    int mid = (x + y) / 2;
                    l = x;
                    r = mid;
                    x = mid + 1;
                } else {
                    int mid = (x + y) / 2;
                    l = x;
                    r = mid;
                    x = mid;
                }

            } else {
                idx = r;
                break;
            }
        }
        return idx;
    }*/
}
