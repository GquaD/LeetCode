package LeetCode;

/**
 * Created by Behzod on 26, March, 2021
 */
public class Problem1603Parking {
    private int bigNum;
    private int mediumNum;
    private int smallNum;

    public Problem1603Parking(int big, int medium, int small) {
        this.bigNum = big;
        this.mediumNum = medium;
        this.smallNum = small;
    }

    public boolean addCar(int carType) {
        switch (carType) {
            case 1: {
                if (bigNum > 0) {
                    bigNum--;
                    return true;
                } else return false;
            }
            case 2: {
                if (mediumNum > 0) {
                    mediumNum--;
                    return true;
                } else return false;
            }
            default: {
                if (smallNum > 0) {
                    smallNum--;
                    return true;
                } else return false;
            }
        }
    }
}
