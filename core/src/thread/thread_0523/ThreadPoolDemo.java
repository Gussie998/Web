package thread.thread_0523;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * User:DELL
 * Date:2021-05-23
 * Time:9:25
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(5,10,
                        60, TimeUnit.SECONDS,
                        new LinkedBlockingQueue<>(1000));
        for (int i = 0; i <6 ; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {

                        System.out.println("线程名："+ Thread.currentThread().getName());
                    }
            });
        }
//        并没有新创建线程，只是五个
//        线程名：pool-1-thread-1
//        线程名：pool-1-thread-2
//        线程名：pool-1-thread-2
//        线程名：pool-1-thread-3
//        线程名：pool-1-thread-4
//        线程名：pool-1-thread-5




    }

}
