package LeetCode.medium;

import java.util.*;

public class Problem1834 {
    //https://leetcode.com/problems/single-threaded-cpu/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getOrder(new int[][]{{5,6},{9,4},{3,9},{3,7},{1,1},{6,9},{9,1}})));
        System.out.println(Arrays.toString(getOrder(new int[][]{{5,2},{7,2},{9,4},{6,3},{5,10},{1,1}})));
        System.out.println(Arrays.toString(getOrder(new int[][]{
                {1,2},
                {2,4},
                {3,2},
                {4,1}
        })));
    }

    //https://leetcode.com/problems/single-threaded-cpu/solutions/2967929/java-using-2-priority-queues/
    //3-4 hours
    //Runtime
    //487 ms
    //Beats
    //15.21%
    //Memory
    //86 MB
    //Beats
    //78.34%
    static int[] getOrder(int[][] tasks) {
        PriorityQueue<Task> queueAv = new PriorityQueue(Comparator.comparing(Task::getAvailableAt).thenComparing(Task::getTime));
        PriorityQueue<Task> queueTime = new PriorityQueue(Comparator.comparing(Task::getTime).thenComparing(Task::getIdx));

        int avCount = Integer.MAX_VALUE;
        for (int i = 0; i < tasks.length; i++) {
            int av = tasks[i][0], time = tasks[i][1];
            Task task = new Task(av, time, i);
            queueAv.offer(task);
            if (avCount > av) {
                avCount = av;
            }
        }

        int[] res = new int[tasks.length];
        for (int i = 0; i < res.length; i++) {
            while (queueAv.size() > 0 && queueAv.peek().availableAt <= avCount) {
                queueTime.offer(queueAv.poll());
            }
            Task t = queueTime.poll();
            if (t == null) {
                t = queueAv.poll();
                avCount = t.availableAt;
            }
            avCount += t.time;
            res[i] = t.idx;
        }
        return res;
    }

    //time limit exceeded on 27/39

    static int[] getOrder4(int[][] tasks) {
        List<Task> list = new ArrayList<>();
        int avCount = Integer.MAX_VALUE;
        for (int i = 0; i < tasks.length; i++) {
            int av = tasks[i][0], time = tasks[i][1];
            Task task = new Task(av, time, i);
            list.add(task);
            if (avCount > av) {
                avCount = av;
            }
        }

        Collections.sort(list, Comparator.comparing(Task::getTime).thenComparing(Task::getIdx).reversed());

        int[] res = new int[tasks.length];
        int count = 0;
        while (!list.isEmpty()) {
            for (int i = list.size() - 1; i >= 0; i--) {
                Task t = list.get(i);
                if (t.availableAt <= avCount) {
                    avCount += t.time;
                    list.remove(i);
                    res[count++] = t.idx;
                    break;
                }
            }
        }
        return res;
    }

    static int[] getOrder3(int[][] tasks) {
        Comparator<Task> comparator = Comparator.comparing(Task::getTime).thenComparing(Task::getAvailableAt);
        PriorityQueue<Task> queue = new PriorityQueue<>(comparator);
        for (int i = 0; i < tasks.length; i++) queue.add(new Task(tasks[i][0], tasks[i][1], i));
        int[] result = new int[tasks.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = queue.poll().getIdx();
            //queue = new PriorityQueue<>(queue);
        }
        return result;
    }

    //works but time limit exceeded on 26/39
    static int[] getOrder2(int[][] tasks) {
        Map<Integer, List<Task>> map = new HashMap<>();
        int key = Integer.MAX_VALUE;
        for (int i = 0; i < tasks.length; i++) {
            Task task = new Task(tasks[i][0], tasks[i][1], i);
            if (key > task.availableAt) key = task.availableAt;
            List<Task> list = map.get(task.availableAt);
            if (list == null) {
                List<Task> list1 = new ArrayList<>();
                list1.add(task);
                map.put(task.availableAt, list1);
            } else {
                list.add(task);
            }
        }
        int[] result = new int[tasks.length];
        int timeCurr = key;
        for (int i = 0; i < result.length; i++) {
            List<Task> list = new ArrayList<>();
            for (int k : map.keySet()) {
                if (k <= timeCurr) {
                    list.addAll(map.get(k));
                }
            }

            if (list.size() > 1) {
                Task taskWithMinTime = list.get(0);
                int idxRemove = 0;
                for (int j = 1; j < list.size(); j++) {
                    Task taskCurr = list.get(j);
                    if (taskWithMinTime.time > taskCurr.time) {
                        taskWithMinTime = taskCurr;
                    } else if (taskWithMinTime.time == taskCurr.time && taskWithMinTime.idx > taskCurr.idx) {
                        taskWithMinTime = taskCurr;
                    }
                }
                result[i] = taskWithMinTime.idx;
                timeCurr += taskWithMinTime.time;

                // remove element from map
                List<Task> listTemp = map.get(taskWithMinTime.availableAt);
                listTemp.remove(taskWithMinTime);
                if (listTemp.isEmpty()) map.remove(taskWithMinTime.availableAt);
            } else {
                Task task = list.get(0);
                result[i] = task.idx;
                timeCurr += task.time;

                //remove element from map
                map.remove(task.availableAt);
            }

        }
        return result;
    }

    static int[] getOrder1(int[][] tasks) {
        TreeMap<Integer, List<Task>> map = new TreeMap<>();
        for (int i = 0; i < tasks.length; i++) {
            Task task = new Task(tasks[i][0], tasks[i][1], i);
            List<Task> list = map.get(task.availableAt);
            if (list == null) {
                List<Task> list1 = new ArrayList<>();
                list1.add(task);
                map.put(task.availableAt, list1);
            } else {
                list.add(task);
                Collections.sort(list, (o1, o2) -> o2.time - o1.time);
            }
        }
        int[] result = new int[tasks.length];
        int time = map.firstKey();
        for (int i = 0; i < result.length; i++) {
            Map.Entry<Integer, List<Task>> first = map.firstEntry();
            int avail = first.getKey();
            List<Task> list = first.getValue();
            if (list.size() > 1) {
                int idxCurr = list.size() - 1;
                Task task = list.get(idxCurr);
                result[i] = task.idx;
                time += task.time;
                list.remove(idxCurr);
            } else {
                int idxCurr = list.size() - 1;
                Task task = list.get(idxCurr);
                result[i] = task.idx;
                time += task.time;
                map.remove(avail);
            }
        }
        return result;
    }

    static class Task {
        int availableAt, time, idx;

        public Task(int availableAt, int time, int idx) {
            this.availableAt = availableAt;
            this.time = time;
            this.idx = idx;
        }

        public int getAvailableAt() {
            return availableAt;
        }

        public int getTime() {
            return time;
        }

        public int getIdx() {
            return idx;
        }
    }
}
