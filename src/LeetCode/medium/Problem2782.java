package LeetCode.medium;

public class Problem2782 {
    //https://leetcode.com/problems/number-of-unique-categories
    public static void main(String[] args) {
        CategoryHandler c = new CategoryHandler(new int[]{1,1,2,2,3,3});
        System.out.println(numberOfCategories(6, c));
    }

    //https://leetcode.com/problems/number-of-unique-categories/solutions/4671075/java-o-n-2-solution/
    //15 min
    //Runtime
    //46
    //ms
    //Beats
    //35.42%
    //of users with Java
    //Memory
    //44.84
    //MB
    //Beats
    //45.83%
    //of users with Java
    static int numberOfCategories(int n, CategoryHandler c) {
        int count = 0;
        boolean visited[] = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            count++;
            visited[i] = true;
            for (int j = i + 1; j < n; j++) {
                if (j == i) continue;
                if (!visited[j] && c.haveSameCategory(i, j)) {
                    visited[j] = true;
                }
            }
        }
        return count;
    }
}

class CategoryHandler {
    private int[] c;
    public CategoryHandler(int[] categories) {
        c = categories;
    }

    public boolean haveSameCategory(int a, int b) {
        return c[a] == c[b] && c[a] >= 0 && c[a] < c.length;
    }
}
