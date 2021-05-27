package thread.thread_0527;

import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * User:DELL
 * Date:2021-05-27
 * Time:19:25
 */
public class ThreadOptimisticLock {
    private static  AtomicInteger count;
    private static final int MAXSIZE=100000;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < MAXSIZE; i++) {
                    count.getAndIncrement();
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < MAXSIZE; i++) {
                    count.getAndDecrement();
                }
            }
        });
        t2.start();

//        t1.join();
//        t2.join();
        System.out.println(count);

//        AtomicInteger count = new AtomicInteger(0);//int count =0;
//        count.getAndIncrement();//i++;
//        count.incrementAndGet();//++i;



    }

}
