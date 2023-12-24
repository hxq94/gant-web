package queue;

import java.util.concurrent.*;

public class ThreadPool {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2,
                5,
                2,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        try {
            for (int i = 1; i <= 6; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "-work");
                });
            }
        }catch (Exception e){

        }finally {
            threadPool.shutdown();
        }

    }
}
