package LeetCode.easy;

public class Problem3894 {
    //1min

    //Runtime
    //1
    //ms
    //Beats
    //67.65%
    //Memory
    //43.35
    //MB
    //Beats
    //81.39%
    public String trafficSignal(int timer) {
        return timer == 0 ? "Green" : timer == 30 ? "Orange" : timer > 30 && timer <= 90 ? "Red" : "Invalid";
    }
}
