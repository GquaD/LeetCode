package LeetCode.medium;

import java.util.*;

public class Problem2590 {
    //https://leetcode.com/problems/design-a-todo-list/


}
//https://leetcode.com/problems/design-a-todo-list/solutions/5372135/java-93-faster-solution/
//20min
//Runtime
//55
//ms
//Beats
//92.59%
//Analyze Complexity
//Memory
//46.22
//MB
//Beats
//96.30%
class TodoList {
    int id;
    Map<Integer, List<Task>> map;
    public TodoList() {
        id = 0;
        map = new HashMap<>();
    }

    public int addTask(int userId, String taskDescription, int dueDate, List<String> tags) {
        List<Task> l = map.get(userId);
        if (l == null) {
            l = new ArrayList<>();
            map.put(userId, l);
        }
        l.add(new Task(userId, dueDate, tags, ++id, taskDescription));
        return id;
    }

    public List<String> getAllTasks(int userId) {
        List<Task> l = map.get(userId);
        List<String> res = new ArrayList<>();
        if (l != null) {
            Collections.sort(l, (a, b) -> a.due - b.due);
            for (Task t : l) {
                res.add(t.desc);
            }
        }
        return res;
    }

    public List<String> getTasksForTag(int userId, String tag) {
        List<Task> l = map.get(userId);
        List<Task> res = new ArrayList<>();
        for (Task t : l) {
            if (t.tags.contains(tag)) {
                res.add(t);
            }
        }
        Collections.sort(res, (a, b) -> a.due - b.due);
        List<String> ld = new ArrayList<>();
        for (Task t : res) {
            ld.add(t.desc);
        }
        return ld;
    }

    public void completeTask(int userId, int taskId) {
        List<Task> l = map.get(userId);
        if (l == null || l.size() == 0) return;
        int t = -1;
        for (int i = 0; i < l.size(); i++) {
            Task task = l.get(i);
            if (task.id == taskId) {
                t = i;
                break;
            }
        }
        if (t > -1) {
            l.remove(t);
        }
    }
}

class Task {
    int userId, due, id;
    List<String> tags;
    String desc;

    public Task(int userId, int due, List<String> tags, int id, String desc) {
        this.userId = userId;
        this.due = due;
        this.tags = tags;
        this.id = id;
        this.desc = desc;
    }
}
