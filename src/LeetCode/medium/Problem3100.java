package LeetCode.medium;

public class Problem3100 {
    //5min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //41.33
    //MB
    //Beats
    //13.55%
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        if (numExchange > numBottles)
            return numBottles;

        int extra = 0, drunk = 0;
        while (numBottles >= numExchange) {
            numBottles -= numExchange;
            drunk += numExchange;
            extra++;
            numExchange++;
        }
        return drunk + maxBottlesDrunk(numBottles + extra, numExchange);
    }
}
