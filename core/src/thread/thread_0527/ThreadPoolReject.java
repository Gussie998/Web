package thread.thread_0527;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * User:DELL
 * Date:2021-05-23
 * Time:10:00
 */
public class ThreadPoolReject {
    public static void main(String[] args) {
        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(5,5,
                        0, TimeUnit.SECONDS,
                        new LinkedBlockingQueue<>(5),
//                        new ThreadPoolExecutor.AbortPolicy(),
//                        new ThreadPoolExecutor.CallerRunsPolicy(),
//                        new ThreadPoolExecutor.DiscardOldestPolicy(),
                        new ThreadPoolExecutor.DiscardPolicy()
                );


        for (int i = 0; i <11 ; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {

                    System.out.println("线程名："+ Thread.currentThread().getName());
                }
            });
        }
    }

}
