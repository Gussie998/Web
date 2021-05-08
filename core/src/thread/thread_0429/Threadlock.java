package thread.thread_0429;

/**
 * User:DELL
 * Date:2021-05-07
 * Time:12:37
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock手动锁
 * synchronized JVM层面的锁
 */
public class Threadlock {

    // 全局变量
    private static int number = 0;
    // 循环次数
    private static final int maxSize = 100000;

    public static void main(String[] args) throws InterruptedException {
        // 1.创建手动锁
        Lock lock = new ReentrantLock();

        // +10w
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < maxSize; i++) {
                    // 2.加锁
                    lock.lock();
                    try {
                        number++;
                    } finally {
                        // 3.释放锁
                        lock.unlock();
                    }
                }
            }
        });
        t1.start();

        // -10w
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < maxSize; i++) {
                    lock.lock();
                    try {
                        number--;
                    } finally {
                        lock.unlock();
                    }
                }
            }
        });
        t2.start();

        // 等待线程 1 和线程 2 执行完
        t1.join();
        t2.join();

        System.out.println("最终执行结果：" + number);

    }
}
