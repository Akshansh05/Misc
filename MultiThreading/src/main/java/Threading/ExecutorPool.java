package Threading;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorPool {
    public static void main(String[] args) {

        final int max_thread = 3;

        Runnable task1 = new Task("task1");
        Runnable task2 = new Task("task2");
        Runnable task3 = new Task("task3");
        Runnable task4 = new Task("task4");
        Runnable task5 = new Task("task5");

        ExecutorService executorService = Executors.newFixedThreadPool(max_thread);
        executorService.execute(task1);
        executorService.execute(task2);
        executorService.execute(task3);
        executorService.execute(task4);
        executorService.execute(task5);
    }
}

class Task implements Runnable {

    private final String taskName;

    Task(String name) {
        taskName = name;
    }

    @Override
    public void run() {

        for (int i = 0; i <= 1; i++) {
            if (i == 0) {
                Date d = new Date();
                SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
                System.out.println("Initialise task " + taskName + " at " + ft.format(d));
            } else {
                Date d = new Date();
                SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
                System.out.println("Execute task " + taskName + " at " + ft.format(d));
            }
        }
        try {
            Thread.sleep(1000);// this sleep is introduced to keep all parallel thread sleep and then execute the Completed line at once else  above print will execute and immediately next print will execute
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Completed " + taskName);

    }
}

/*
Initialise task task2 at 10:20:25
Initialise task task1 at 10:20:25
Initialise task task3 at 10:20:25
Execute task task2 at 10:20:25
Execute task task1 at 10:20:25
Execute task task3 at 10:20:25
Completed task2
Completed task1
Completed task3
Initialise task task4 at 10:20:26
Execute task task4 at 10:20:26
Initialise task task5 at 10:20:26
Execute task task5 at 10:20:26
Completed task5
Completed task4
 */
