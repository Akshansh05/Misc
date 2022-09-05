package TaskScheduler;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SchedulerService {

    private final ThreadPoolExecutor workerPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

    public static void main(String[] args) {

        System.out.println("Started at " + System.currentTimeMillis());
        SchedulerService schedulerService = new SchedulerService();
        schedulerService.schedule(getRunnableTask("task1"), TimeUnit.SECONDS, 1);
        schedulerService.scheduleAtFixRate(getRunnableTask("task2"), TimeUnit.SECONDS, 1, 2);
        schedulerService.scheduleAtFixDelay(getRunnableTask("task3"), TimeUnit.SECONDS, 1, 2);
        schedulerService.scheduleAtFixRate(getRunnableTask("task4"), TimeUnit.SECONDS, 1, 2);
    }

    private static Runnable getRunnableTask(String task) {
        return () -> {
            System.out.println(task + " Started at " + System.currentTimeMillis());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(task + " Completed at " + System.currentTimeMillis());

        };
    }

    public void schedule(Runnable task, TimeUnit timeUnit, long initialDelay) {
        CustomTask customTask = new CustomTask(task, timeUnit, initialDelay, null, 1);
        workerPool.submit(customTask);
    }

    public void scheduleAtFixRate(Runnable task, TimeUnit timeUnit, long initialDelay, long period) {
        CustomTask customTask = new CustomTask(task, timeUnit, initialDelay, period, 2);
        workerPool.submit(customTask);
    }

    public void scheduleAtFixDelay(Runnable task, TimeUnit timeUnit, long initialDelay, long period) {
        CustomTask customTask = new CustomTask(task, timeUnit, initialDelay, period, 3);
        workerPool.submit(customTask);
    }

}

@AllArgsConstructor
class CustomTask implements Runnable {

    private final Runnable task;
    private final TimeUnit timeUnit;
    private final Long initialDelay;
    private final Long period;
    private final int type;

    @SneakyThrows
    @Override
    public void run() {
        switch (type) {
            case 1:
                Thread.sleep(timeUnit.toMillis(initialDelay));
                task.run();
                break;
            case 2:
                Thread.sleep(timeUnit.toMillis(initialDelay));
                do {
                    task.run();
                    Thread.sleep(timeUnit.toMillis(period));
                } while (true);
            case 3:
                Thread.sleep(timeUnit.toMillis(initialDelay));
                ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
                do {
                    Future result = executor.submit(task);
                    result.get();
                    Thread.sleep(timeUnit.toMillis(period));
                } while (true);
        }
    }
}
