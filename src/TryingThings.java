import java.util.*;

public class TryingThings {
    public static void main(String[] args) {
        List<Integer> one = new ArrayList<>();
        one.add(1);
        one.add(2);
        one.add(4);
        List<Integer> two = new ArrayList<>();
        two.add(1);
        two.add(2);
        two.add(4);
        Set<List<Integer>> set = new HashSet<>();
        set.add(one);
        set.add(two);

        for (List<Integer> list: set){
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
