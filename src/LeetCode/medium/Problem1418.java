package LeetCode.medium;

import LeetCode.LeetCodeUtils;

import java.util.*;

public class Problem1418 {
    //https://leetcode.com/problems/display-table-of-food-orders-in-a-restaurant/
    public static void main(String[] args) {
        List<String> s1 = Arrays.asList(new String[]{"David","3","Ceviche"});
        List<String> s2 = Arrays.asList(new String[]{"Corina","10","Beef Burrito"});
        List<String> s3 = Arrays.asList(new String[]{"David","3","Fried Chicken"});
        List<String> s4 = Arrays.asList(new String[]{"Carla","5","Water"});
        List<String> s5 = Arrays.asList(new String[]{"Carla","5","Ceviche"});
        List<String> s6 = Arrays.asList(new String[]{"Rous","3","Ceviche"});
        List<List<String>> orders = new ArrayList<>();
        orders.add(s1);
        orders.add(s2);
        orders.add(s3);
        orders.add(s4);
        orders.add(s5);
        orders.add(s6);
        List<List<String>> result = displayTable(orders);
        LeetCodeUtils.printListWithListsOfStrings(result);
    }

    //30 mins
    //https://leetcode.com/problems/display-table-of-food-orders-in-a-restaurant/discuss/2562961/Java-Simple-Solution-oror-Explained
    //Runtime: 66 ms, faster than 58.38% of Java online submissions for Display Table of Food Orders in a Restaurant.
    //Memory Usage: 126.5 MB, less than 74.62% of Java online submissions for Display Table of Food Orders in a Restaurant.
    static List<List<String>> displayTable(List<List<String>> orders) {
        //table -> (food -> quantity)
        Map<Integer, Map<String, Integer>> map = new TreeMap<>();
        Set<String> foods = new TreeSet<>();
        for (int i = 0; i < orders.size(); i++) {
            List<String> order = orders.get(i);
            Integer table = Integer.parseInt(order.get(1));
            String food = order.get(2);
            if (map.containsKey(table)) {
                Map<String, Integer> foodsMap = map.get(table);
                if (foodsMap.containsKey(food)) {
                    foodsMap.put(food, foodsMap.get(food) + 1);
                } else {
                    foods.add(food);
                    foodsMap.put(food, 1);
                }
            } else {
                foods.add(food);
                Map<String, Integer> newFoodsMap = new TreeMap<>();
                newFoodsMap.put(food, 1);
                map.put(table, newFoodsMap);
            }
        }
        List<List<String>> list = new ArrayList<>();
        List<String> header = new ArrayList<>();
        header.add("Table");
        for (String foodName : foods) {
            header.add(foodName);
        }
        list.add(header);
        for (Integer tableNum : map.keySet()) {
            List<String> tableOrders = new ArrayList<>();
            tableOrders.add(tableNum + "");
            Map<String, Integer> table = map.get(tableNum);
            for (String foodName : foods) {
                if (table.containsKey(foodName)) {
                    tableOrders.add(table.get(foodName) + "");
                } else {
                    tableOrders.add("0");
                }
            }
            list.add(tableOrders);
        }
        return list;
    }

    public List<List<String>> displayTable1(List<List<String>> orders) {
        //food -> (table -> quantity)
        Map<String, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < orders.size(); i++) {
            List<String> order = orders.get(i);
            Integer table = Integer.parseInt(order.get(1));
            String food = order.get(2);
            if (map.containsKey(food)) {
                Map<Integer, Integer> tableFoodItem = map.get(food);
                if (tableFoodItem.containsKey(table)) {
                    tableFoodItem.put(table, tableFoodItem.get(table) + 1);
                } else {
                    Map<Integer, Integer> newTableFoodItem = new HashMap<>();
                    newTableFoodItem.put(table, 1);
                    map.put(food, newTableFoodItem);
                }
            } else {
                Map<Integer, Integer> newTableFoodItem = new HashMap<>();
                newTableFoodItem.put(table, 1);
                map.put(food, newTableFoodItem);
            }
        }
        List<List<String>> list = new ArrayList<>();
        for (String food : map.keySet()) {

        }
        return null;
    }
}
