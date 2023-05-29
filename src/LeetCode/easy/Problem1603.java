package LeetCode.easy;

/**
 * Created by Behzod on 26, March, 2021
 */
public class Problem1603 {
    //https://leetcode.com/problems/design-parking-system
    public static void main(String[] args) {
        Problem1603Parking parking = new Problem1603Parking(1,1,0);
        System.out.println(parking.addCar(1));
        System.out.println(parking.addCar(2));
        System.out.println(parking.addCar(3));
        System.out.println(parking.addCar(1));
        //O (n)
    }
}
//https://leetcode.com/problems/design-parking-system/solutions/3575831/java-simple-array-3-line-solution/
//Runtime
//9 ms
//Beats
//56.91%
//Memory
//44.6 MB
//Beats
//6.49%
class ParkingSystem {

    int[] arr;
    public ParkingSystem(int big, int medium, int small) {
        arr = new int[]{0, big, medium, small};
    }

    public boolean addCar(int carType) {
        return arr[carType]-- > 0;
    }
}
