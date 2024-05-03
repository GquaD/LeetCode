package LeetCode.medium;

public class Problem277 {
    //https://leetcode.com/problems/find-the-celebrity/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-the-celebrity/solutions/5106108/java-from-349ms-to-59ms-solutions/
    //5-6 times faster
    //Runtime
    //59
    //ms
    //Beats
    //27.77%
    //of users with Java
    //Memory
    //45.88
    //MB
    //Beats
    //7.96%
    //of users with Java
    public int findCelebrity(int n) {
        for (int i = 0; i < n; i++) {
            int knows = 0;
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                if (knows(i, j))
                    knows++;
                if (knows > 1)
                    break;
            }
            if (knows == 0) {
                int knownBy = 0;
                for (int j = 0; j < n; j++) {
                    if (i == j)
                        continue;
                    if (knows(j, i))
                        knownBy++;
                }
                if (knownBy == n - 1)
                    return i;
            }
        }
        return -1;
    }

    //10min
    //Runtime
    //349
    //ms
    //Beats
    //16.61%
    //of users with Java
    //Memory
    //45.14
    //MB
    //Beats
    //69.36%
    //of users with Java
    public int findCelebrity1(int n) {

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                if (this.knows(j, i))
                    count++;
            }
            if (count == n - 1) {
                int cc = 0;
                for (int j = 0; j < n; j++) {
                    if (i == j)
                        continue;
                    if (this.knows(i, j))
                        cc++;
                }
                if (cc == 0) return i;
            }

        }
        return -1;
    }

    private boolean knows(int i, int j) {
        return i == j;
    }


}
