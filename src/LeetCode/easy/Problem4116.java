package LeetCode.easy;

public class Problem4116 {
    //10min
    //Runtime
    //2
    //ms
    //Beats
    //100.00%
    //Memory
    //46.44
    //MB
    //Beats
    //97.18%
    public String[] assignUmbrella(int[] rain) {
        String[] result = new String[rain.length];
        int a = 0, b = 0;
        for (int i = 0; i < rain.length; i++) {
            //if alice needs
            boolean aliceNeeds = i < rain.length - 1 && rain[i] == rain[i + 1] && rain[i] == 1, bobNeeds = rain[i] == 1;
            if (aliceNeeds) {
                if (bobNeeds) {
                    if (a <= b) {
                        a++;
                        result[i] = "Alice";
                    } else {
                        b++;
                        result[i] = "Bob";
                    }
                } else {
                    a++;
                    result[i] = "Alice";
                }
            } else if (bobNeeds) {
                b++;
                result[i] = "Bob";
            } else {
                result[i] = "None";
            }
        }

        return result;
    }
}
