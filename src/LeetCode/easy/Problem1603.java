package LeetCode.easy;

/**
 * Created by Behzod on 26, March, 2021
 */
public class Problem1603 {
    public static void main(String[] args) {
        Problem1603Parking parking = new Problem1603Parking(1,1,0);
        System.out.println(parking.addCar(1));
        System.out.println(parking.addCar(2));
        System.out.println(parking.addCar(3));
        System.out.println(parking.addCar(1));
        //O (n)
    }
}
