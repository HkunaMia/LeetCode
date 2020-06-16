package Thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author ：mzr
 * @date ：Created in 2020/5/25 16:28
 * @description：
 * @modified By：
 */

public class CallableDemo {

    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());
        List<Future<String>> futures = new ArrayList<>();
        Callable<String> callable = new MyCallable();
        for(int i=0;i<10;i++){
            Future<String> future = threadPoolExecutor.submit(callable);
            futures.add(future);
        }
        for (Future<String> future : futures) {
            try {
                System.out.println(new Date() + ": :" + future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        threadPoolExecutor.shutdown();
    }

}
