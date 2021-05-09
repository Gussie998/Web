package thread.thread_0509;

/**
 * User:DELL
 * Date:2021-05-09
 * Time:10:01
 */
public class ThreadDeadlock {
    public static void main(String[] args) {
        Object l1 = new Object();
        Object l2 = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (l1){
                    System.out.println("t1 get l1");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t1 want to get l2");
                    synchronized (l2){
                        System.out.println("t1 get l2");
                    }
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (l2){
                    System.out.println("t2 get l2");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t2 want to get l1");
                    synchronized (l1){
                        System.out.println("t2 get l1");
                    }
                }
            }
        });
        t2.start();
    }

}
