package LeetCode.medium;

import java.util.ArrayList;

public class Problem3829 {
    //5min

    //Runtime
    //48
    //ms
    //Beats
    //88.48%
    //Analyze Complexity
    //Memory
    //47.92
    //MB
    //Beats
    //98.33%

    class RideSharingSystem {

        ArrayList<Integer> drivers, riders;

        public RideSharingSystem() {
            drivers = new ArrayList<>();
            riders = new ArrayList<>();
        }

        public void addRider(int riderId) {
            riders.add(riderId);
        }

        public void addDriver(int driverId) {
            drivers.add(driverId);
        }

        public int[] matchDriverWithRider() {
            if (riders.size() < 1 || drivers.size() < 1) return new int[]{-1, -1};
            return new int[]{drivers.remove(0), riders.remove(0)};
        }

        public void cancelRider(int riderId) {
            riders.remove(Integer.valueOf(riderId));
        }
    }
}
