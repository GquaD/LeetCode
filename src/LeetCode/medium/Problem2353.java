package LeetCode.medium;

import java.util.*;

public class Problem2353 {
    //https://leetcode.com/problems/design-a-food-rating-system/

    public static void main(String[] args) {
        String[] foods = new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"};
        String[] cuisines = new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"};
        int[] ratings = new int[]{9, 12, 8, 15, 14, 7};
        FoodRatings fr = new FoodRatings(foods, cuisines, ratings);
        System.out.println(fr.highestRated("korean"));
        System.out.println(fr.highestRated("japanese"));
        fr.changeRating("sushi", 16);
        System.out.println(fr.highestRated("japanese"));
        fr.changeRating("ramen", 16);
        System.out.println(fr.highestRated("japanese"));
    }



}
//Runtime
//526 ms
//Beats
//45.37%
//Memory
//84.8 MB
//Beats
//5.56%
class FoodRatings {

    private Map<String, Map<String, Integer>> map;
    private Map<String, String> mapFC;
    private TreeMap<Integer, TreeMap<String, String>> mapR;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        map = new HashMap<>();
        mapFC = new HashMap<>();
        mapR = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < foods.length; i++) {
            if (!map.containsKey(cuisines[i])) map.put(cuisines[i], new TreeMap<>());
            map.get(cuisines[i]).put(foods[i], ratings[i]);
            mapFC.put(foods[i], cuisines[i]);

            if (!mapR.containsKey(ratings[i])) mapR.put(ratings[i], new TreeMap<>());
            mapR.get(ratings[i]).put(foods[i], cuisines[i]);
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = mapFC.get(food);
        int oldRating = map.get(cuisine).get(food);
        map.get(cuisine).put(food, newRating);

        mapR.get(oldRating).remove(food);
        if (!mapR.containsKey(newRating)) mapR.put(newRating, new TreeMap<>());
        mapR.get(newRating).put(food, cuisine);
    }

    public String highestRated(String cuisine) {
        for (int r : mapR.keySet()) {
            Map<String, String> map1 = mapR.get(r);
            for (String food : map1.keySet()) if (map1.get(food).equals(cuisine)) return food;
        }
        return "";
    }

    /*public String highestRated(String cuisine) {
        Map<String, Integer> foods = map.get(cuisine);
        int max = -1;
        String foodMax = "";
        for (String food : foods.keySet()) {
            int rating = foods.get(food);
            if (max < rating) {
                max = rating;
                foodMax = food;
            }
        }
        return foodMax;
    }*/
}


/*class FoodRatings {

    private Map<String, Map<String, Integer>> map;
    private Map<String, String> mapFC;
    private TreeMap<Integer, TreeSet<String>> mapRF;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        map = new HashMap<>();
        mapFC = new HashMap<>();
        mapRF = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < foods.length; i++) {
            if (!map.containsKey(cuisines[i])) map.put(cuisines[i], new HashMap<>());
            map.get(cuisines[i]).put(foods[i], ratings[i]);
            mapFC.put(foods[i], cuisines[i]);
            if (!mapRF.containsKey(ratings[i])) mapRF.put(ratings[i], new TreeSet<>());
            mapRF.get(ratings[i]).add(foods[i]);
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = mapFC.get(food);
        int oldRating = map.get(cuisine).get(food);
        map.get(cuisine).put(food, newRating);

        if (!mapRF.containsKey(oldRating)) mapRF.put(oldRating, new TreeSet<>());
        mapRF.get(oldRating).remove(food);
        if (!mapRF.containsKey(newRating)) mapRF.put(newRating, new TreeSet<>());
        mapRF.get(newRating).add(food);
    }

    public String highestRated(String cuisine) {
        Map<String, Integer> foods = map.get(cuisine);
        int max = -1;
        String foodMax = "";
        for (String food : foods.keySet()) {
            int rating = foods.get(food);
            if (max < rating) {
                max = rating;
                foodMax = food;
            }
        }
        return foodMax;
    }
}*/
