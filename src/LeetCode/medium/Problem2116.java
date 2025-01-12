package LeetCode.medium;

public class Problem2116 {
    //https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid
    public static void main(String[] args) {

    }

    //nnn
    //Runtime
    //19
    //ms
    //Beats
    //23.24%
    //Analyze Complexity
    //Memory
    //45.74
    //MB
    //Beats
    //50.21%
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n % 2 != 0) return false;
        if (s.charAt(0) == ')' && locked.charAt(0) == '1') return false;
        if (s.charAt(n - 1) == '(' && locked.charAt(n - 1) == '1') return false;
        //go from left to right and count changing and locked closing
        // number of first should be >= the last

        //then go from right to left and count changing and locked opening
        // number of first should be >= the last

        int change = 0, lock = 0;
        for (int i = 0; i < n; i++) {
            boolean isOpening = s.charAt(i) == '(', isLocked = locked.charAt(i) == '1';
            if (isLocked) {
                lock += isOpening ? 1 : -1;
            } else {
                change++;
            }
            if (change + lock < 0) break;
        }
        boolean isValidForward = Math.abs(lock) <= change;
        if (!isValidForward) return false;

        change = 0;
        lock = 0;
        for (int i = n - 1; i >= 0; i--) {
            boolean isClosing = s.charAt(i) == ')', isLocked = locked.charAt(i) == '1';
            if (isLocked) {
                lock += isClosing ? 1 : -1;
            } else {
                change++;
            }
            if (change + lock < 0) break;
        }

        boolean isValidBackward = Math.abs(lock) <= change;

        return isValidBackward;
    }

    //30min
    //
//    public boolean canBeValid(String s, String locked) {
//        int n = s.length();
//        if (n % 2 != 0) return false;
//        //go from left to right and count changing and locked closing
//        // number of first should be >= the last
//
//        //then go from right to left and count changing and locked opening
//        // number of first should be >= the last
//
//        int change = 0, closingLocked = 0;
//        for (int i = 0; i < n; i++) {
//            boolean isClosing = s.charAt(i) == ')', isChanging = locked.charAt(i) == '0';
//            if (isChanging) change++;
//            else if (isClosing) {
//                if (change >= closingLocked) {
//                    closingLocked++;
//                } else {
//                    return false;
//                }
//            }
//        }
//
//        change = 0;
//        int openLocked = 0;
//        for (int i = n - 1; i >= 0; i--) {
//            boolean isOpening = s.charAt(i) == ')', isChanging = locked.charAt(i) == '0';
//            if (isChanging) change++;
//            else if (isOpening) {
//                if (change >= openLocked) {
//                    openLocked++;
//                } else {
//                    return false;
//                }
//            }
//        }
//
//        return true;
        // Stack<Integer> change = new Stack<>();
        // Stack<Integer> openLocked = new Stack<>(), closeLocked = new Stack<>();
        // for (int i = 0; i < n; i++) {
        //     boolean isClosing = s.charAt(i) == ')', isChanging = locked.charAt(i) == '0';
        //     if (isClosing) {
        //         if (isChanging) {
        //             change.push(i);
        //         } else {
        //             if (change.size() > 0) {
        //                 change.pop();
        //             } else
        //                 return false;
        //         }
        //     } else {
        //         if (isChanging) {
        //             change.push(i);
        //         } else {
        //             openLocked.push(i);
        //         }
        //     }
        // }

        // while (change.size() > 0 && openLocked.size() > 0) {
        //     int open = openLocked.peek(), ch = change.peek();
        //     if (open < ch) {
        //         openLocked.pop();
        //         change.pop();
        //     } else {
        //         break;
        //     }
        // }

        // return openLocked.size() == 0;

        // int close = 0, open = 0, closeLock = 0, openLock = 0;
        // for (int = 0; i < n; i++) {
        //     boolean isClosing = s.charAt(i) == ')', isChanging = locked.charAt(i) == '1';
        //     if (isClosing) {
        //         if (isChanging) close++;
        //         else closeLock++;
        //     } else {
        //         if (isChanging) open++;
        //         else openLock++;
        //     }
        // }


//    }

}
