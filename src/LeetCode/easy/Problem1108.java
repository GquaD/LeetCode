package LeetCode.easy;

import java.util.stream.Stream;

/**
 * Created by Behzod on 24, March, 2021
 */
public class Problem1108 {
    public static void main(String[] args) {
        System.out.println(defangIPaddr1("1.1.1.1"));
    }
    //works
    public static String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }

    public static String defangIPaddr1(String address) {
        String[] split = address.split("\\.");
        return split[0] + "[.]" + split[1] + "[.]" + split[2] + "[.]" + split[3];
    }
}
