package thread.thread_0428;

/**
 * User:DELL
 * Date:2021-05-07
 * Time:10:29
 */
public class ThreadInterrupt3 {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.interrupted()) {
//                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("正在转账");
                }
                System.out.println("终止转账");
            }
        });
        t1.start();

        Thread.sleep(1);
        System.out.println("有内鬼终止交易");
        t1.interrupt();


    }
}
