package LeetCode.medium;
import java.util.*;

public class Problem3408 {
    //https://leetcode.com/problems/design-task-manager
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/design-task-manager/solutions/6426289/java-2-map-solution-by-tbekpro-y51x/
    //35min
    //Runtime
    //320
    //ms
    //Beats
    //72.54%
    //Analyze Complexity
    //Memory
    //210.48
    //MB
    //Beats
    //5.82%
    class TaskManager {
        //map taskId -> userId, priority
        //map priority -> list<taskIds>

        Map<Integer, Task> mapt;
        TreeMap<Integer, PriorityQueue<Task>> mapp;

        public TaskManager(List<List<Integer>> tasks) {
            mapt = new HashMap<>();
            mapp = new TreeMap<>((a, b) -> b - a);
            for (List<Integer> task: tasks) {
                int u = task.get(0), t = task.get(1), p = task.get(2);
                Task cur = new Task(t, u, p);
                mapt.put(t, cur);

                PriorityQueue<Task> list = mapp.get(p);
                if (list == null) {
                    list = new PriorityQueue<>((a, b) -> b.taskId - a.taskId);
                    mapp.put(p, list);
                }
                list.add(cur);
            }
        }

        public void add(int userId, int taskId, int priority) {
            Task cur = new Task(taskId, userId, priority);
            mapt.put(taskId, cur);

            PriorityQueue<Task> list = mapp.get(priority);
            if (list == null) {
                list = new PriorityQueue<>((a, b) -> b.taskId - a.taskId);
                mapp.put(priority, list);
            }
            list.add(cur);
        }

        public void edit(int taskId, int newPriority) {
            Task task = mapt.get(taskId);
            int oldPriority = task.priority;


            PriorityQueue<Task> list = mapp.get(oldPriority);
            if (list.size() == 1) {
                mapp.remove(oldPriority);
            } else {
                list.remove(task);
            }

            list = mapp.get(newPriority);
            task.priority = newPriority;
            if (list == null) {
                list = new PriorityQueue<>((a, b) -> b.taskId - a.taskId);
                mapp.put(newPriority, list);
            }
            list.add(task);
        }

        public void rmv(int taskId) {
            Task task = mapt.remove(taskId);

            PriorityQueue<Task> list = mapp.get(task.priority);
            if (list.size() == 1) {
                mapp.remove(task.priority);
            } else {
                list.remove(task);
            }
        }

        public int execTop() {
            if (mapp.size() == 0) return -1;
            int p = mapp.firstKey();
            PriorityQueue<Task> pq = mapp.get(p);
            Task task = pq.peek();
            if (pq.size() == 1) {
                mapp.remove(p);
            } else {
                pq.poll();
            }

            mapt.remove(task.taskId);
            return task.userId;
        }

        class Task {
            int taskId, userId, priority;

            public Task (int t, int u, int p) {
                taskId = t;
                userId = u;
                priority = p;
            }
        }
    }
}
