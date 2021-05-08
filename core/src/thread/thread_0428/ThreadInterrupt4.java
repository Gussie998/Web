package thread.thread_0428;

/**
 * User:DELL
 * Date:2021-05-07
 * Time:10:31
 */
public class ThreadInterrupt4 {
    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.interrupted()); //true false*9 复位为false 因为interrupted()是全局方法
                    System.out.println(Thread.currentThread().isInterrupted());//true*10
                }
            }
        });
        t1.start();

        // 终止线程
        t1.interrupt();

    }
}
