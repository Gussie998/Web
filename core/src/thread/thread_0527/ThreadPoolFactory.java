package thread.thread_0527;

import sun.nio.ch.ThreadPool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * User:DELL
 * Date:2021-05-23
 * Time:9:25
 */
public class ThreadPoolFactory {
    private  static int count=1;

    public static void main(String[] args) {

        ThreadFactory threadFactory=new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread=new Thread(r);
                thread.setName("myThreadPol-"+(count++));
                return thread;
            }
        };
        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(5,5,
                        0, TimeUnit.SECONDS,
                        new LinkedBlockingQueue<>(1000),threadFactory);

        for (int i = 0; i <6 ; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {

                    System.out.println("线程名："+ Thread.currentThread().getName());
                }
            });
        }

    }
}

