package LeetCode.medium;

import java.util.*;

public class Problem2115 {
    //https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/solutions/6561210/java-let-him-cook-straightforward-soluti-31lw/
    //10min
    //Runtime
    //536
    //ms
    //Beats
    //95.09%
    //Analyze Complexity
    //Memory
    //46.51
    //MB
    //Beats
    //79.51%
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> set = new HashSet<>();
        for (String s: supplies) set.add(s);
        Set<String> found = new HashSet<>();
        for (int i = 0; i < recipes.length * recipes.length; i++) {
            String recipe = recipes[i % recipes.length];
            if (!found.contains(recipe)) {
                List<String> ingr = ingredients.get(i % recipes.length);
                boolean hasAll = true;
                for (String s: ingr) {
                    if (!set.contains(s)) {
                        hasAll = false;
                        break;
                    }
                }
                if (hasAll) {
                    set.add(recipe);
                    found.add(recipe);
                }
            }
        }
        return new ArrayList<>(found);
    }
}
