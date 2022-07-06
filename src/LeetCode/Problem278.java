package LeetCode;

public class Problem278 {
    //https://leetcode.com/problems/first-bad-version/
    public static void main(String[] args) {
        versionStatic = 4;
        System.out.println(firstBadVersion2(6));
        versionStatic = 13;
        System.out.println(firstBadVersion2(20));
        versionStatic = 1702766719;
        long before = System.currentTimeMillis();
        int s = firstBadVersion2(2126753390);
        long after = System.currentTimeMillis();
        System.out.println(s + ", time: " + (after - before) + " ms");

    }
    static int versionStatic;
    static int firstBadVersion(int n) {
        if (n <= 10000) {
            for (int i = 1; i <= n; i++) {
                if (isBadVersion(i)) {
                    return i;
                }
            }
            return -1;
        } else {
            int indexBadFirst = 0, indexGoodLast = 0;
            int pointer = n / 2;
            while (indexBadFirst - indexGoodLast != 1) {
                if (!isBadVersion(pointer)) {
                    indexGoodLast = pointer;
                    pointer += pointer / 2;
                } else {
                    indexBadFirst = pointer;
                    pointer -= 1;
                    if (!isBadVersion(indexBadFirst - 1)) {
                        return indexBadFirst;
                    }
                }
            }
            return indexBadFirst;
        }
    }
    //Runtime: 22 ms, faster than 42.38% of Java online submissions for First Bad Version.
    //Memory Usage: 41.2 MB, less than 21.11% of Java online submissions for First Bad Version.
    static int firstBadVersion2(int n) {
        int start = 1, end = n;
        while (start < end) {
            int middle = start + (end-start) / 2;
            if (!isBadVersion(middle)) start = middle + 1;
            else end = middle;
        }
        return start;
    }

    static boolean isBadVersion(int version) {
        return version >= versionStatic;
    }
}
