package LeetCode.easy;

public class Problem2739 {
    //https://leetcode.com/problems/total-distance-traveled/
    public static void main(String[] args) {
        System.out.println(distanceTraveled(5, 10));
        System.out.println(distanceTraveled(1, 2));
        System.out.println(distanceTraveled(25, 2));
        System.out.println(distanceTraveled(25, 10));
    }


    //10-15min
    //O(logN)
    //Runtime
    //4 ms
    //Beats
    //100%
    //Memory
    //42.7 MB
    //Beats
    //84.11%
    static int distanceTraveled(int mainTank, int additionalTank) {
        int count = 0;
        while (mainTank > 0) {
            if (mainTank >= 5) {
                count += 5;
                mainTank -= 5;
                if (additionalTank > 0) {
                    mainTank++;
                    additionalTank--;
                }
            } else {
                count += mainTank;
                mainTank = 0;
            }
        }
        return count * 10;
    }

    static int distanceTraveled1(int mainTank, int additionalTank) {
        int added = 0, temp = mainTank;
        while (temp > 0) {
            added += temp / 5;
            temp /= 5;
        }

        return  (mainTank + Math.min(added, additionalTank)) * 10;

//        return mainTank * 10 + (additionalTank >= mainTank / 5 ? (mainTank / 5) * 10 : (additionalTank % 5) * 10);
    }
}
