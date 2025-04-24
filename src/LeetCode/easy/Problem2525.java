package LeetCode.easy;

public class Problem2525 {
    //https://leetcode.com/problems/categorize-box-according-to-criteria
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/categorize-box-according-to-criteria/solutions/6683174/java-simple-dimple-solution-by-tbekpro-tqyo/
    //5min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //40.82
    //MB
    //Beats
    //59.67%
    public String categorizeBox(int l, int w, int h, int m) {
        boolean bulky = isBulky(l, w, h), heavy = isHeavy(m);
        if (bulky) {
            if (heavy) return "Both";
            return "Bulky";
        } else if (heavy) {
            return "Heavy";
        }
        return "Neither";
    }

    private boolean isBulky(int l, int w, int h) {
        int ten = 10_000;
        if (l >= ten || w >= ten || h >= ten) return true;
        return 1L * l * w * h >= 1_000_000_000;
    }

    private boolean isHeavy(int m) {
        return m >= 100;
    }
}
