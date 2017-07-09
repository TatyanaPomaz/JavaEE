package thread_creation_1;

import java.util.concurrent.*;

/**
 * Created by User on 25.06.2017.
 */
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService =
                Executors.newFixedThreadPool(2);

        CustomCallable customCallable = new CustomCallable();
        Future<String> future = executorService.submit(customCallable);
        System.out.println(future.get());
        executorService.shutdown();

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println("test");
            }
        }, 0, 10, TimeUnit.MILLISECONDS);

    }
}


class CustomCallable implements Callable<String> {
    public String call() throws Exception {
        return "hello from callable";
    }
}