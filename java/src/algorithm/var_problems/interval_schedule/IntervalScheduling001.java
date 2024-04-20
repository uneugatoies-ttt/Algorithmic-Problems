package algorithm.var_problems.interval_schedule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntervalScheduling001 {

    private static class Task implements Comparable<Task> {
        int begin, end;
        public Task(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
        @Override
        public int compareTo(Task o) {
            return Integer.compare(this.end, o.end);
        }
    }

    private static List<Task> tasks = new ArrayList<>();
    private static List<Task> selectedTasks = new ArrayList<>();

    private static void schedule() {
        Collections.sort(tasks);
        Task task;
        while (!tasks.isEmpty()) {
            task = tasks.get(0);
            tasks.remove(0);
            selectedTasks.add(task);
            while (!tasks.isEmpty() && tasks.get(0).begin < task.end)
                tasks.remove(0);
        }
    }

}
