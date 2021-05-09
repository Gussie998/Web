package thread.thread_0509;

/**
 * User:DELL
 * Date:2021-05-09
 * Time:11:09
 */
public class ThreadWaitNotify {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1进入线程方法");
                synchronized (lock){
                    try {
                        lock.wait();
                        System.out.println("线程1等待");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("执行完成");
                }

            }
        }, "t1");
        t1.start();
        Thread.sleep(1000);
        synchronized (lock){
            lock.notify();
        }
    }
}
