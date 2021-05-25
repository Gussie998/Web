package thread.thread_0523;

import java.util.concurrent.*;

/**
 * User:DELL
 * Date:2021-05-23
 * Time:11:00
 */
public class ThreadPoolShutdown {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(10,10,
                        0, TimeUnit.SECONDS,
                        new LinkedBlockingQueue<>(1000)
                );
        for (int i = 0; i <100 ; i++) {
            int finalI=i;
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(String.format("%s , %s",finalI, Thread.currentThread().getName()));
                }
            });
        }

        executor.shutdown();//拒绝新任务加入，执行完所有任务在停止线程池
//        executor.shutdownNow();//可能会来不及执行完所有任务


    }
}
