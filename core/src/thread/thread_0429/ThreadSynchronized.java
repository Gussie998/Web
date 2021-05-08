package thread.thread_0429;

/**
 * User:DELL
 * Date:2021-05-07
 * Time:20:19
 */
public class ThreadSynchronized {

    private static int number = 0;
    // 循环次数
    private static final int maxSize = 100000;

    public static void main(String[] args) throws InterruptedException {

        // 创建一个锁对象
        Object lock = new Object();
        Object lock2 = new Object();

        // +10w
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < maxSize; i++) {
                    // 实现加锁
                    synchronized (lock) {
                        synchronized (lock) {
                            number++;
                        }
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
                    synchronized (lock) {
                        number--;
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
