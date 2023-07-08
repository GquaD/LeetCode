package LeetCode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem1600 {
    //https://leetcode.com/problems/throne-inheritance/
    public static void main(String[] args) {

    }
}

//https://leetcode.com/problems/throne-inheritance/solutions/3734150/java-dfs-hashmap-person-object-73-faster/
//10 min
//Runtime
//294 ms
//Beats
//72.73%
//Memory
//103.1 MB
//Beats
//61.62%

class ThroneInheritance {

    Map<String, Person> map;
    String kingName;
    public ThroneInheritance(String kingName) {
        map = new HashMap<>();
        this.kingName = kingName;
        map.put(kingName, new Person(kingName));
    }

    public void birth(String parentName, String childName) {
        Person p = map.get(parentName);
        Person child = new Person(childName);
        p.children.add(child);
        map.put(childName, child);
    }

    public void death(String name) {
        map.get(name).isAlive = false;
    }

    public List<String> getInheritanceOrder() {
        List<String> list = new ArrayList<>();
        dfs(map.get(kingName), list);
        return list;
    }

    private void dfs(Person person, List<String> list) {
        if (person == null) return;

        if (person.isAlive) list.add(person.name);
        for (int i = 0; i < person.children.size(); i++) {
            dfs(person.children.get(i), list);
        }
    }
}

class Person {
    String name;
    List<Person> children;

    boolean isAlive;

    public Person(String name) {
        this.name = name;
        children = new ArrayList<>();
        isAlive = true;
    }
}
