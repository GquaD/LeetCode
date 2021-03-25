package Practice.functional;

/**
 * Created by Behzod on 21, March, 2021
 */
public class Functional {

    public static void main(String[] args) {
        A a = arg -> System.out.println(arg);
        a.consume("Hello, world!");
    }
}
