package thread.thread_0509;

/**
 * User:DELL
 * Date:2021-05-09
 * Time:11:47
 */
public class ThreadUnlock {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Thread t1 =  new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    System.out.println("got lock,waiting");
                }
//                try {
//                    lock.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程1执行完成释放锁");

            }
        });
        t1.start();

        Thread.sleep(5000);
        //试图获取锁
        synchronized (lock){
            System.out.println("主线程got lock");
        }
    }
}
