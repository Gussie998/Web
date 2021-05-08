package thread.thread_0428;

/**
 * User:DELL
 * Date:2021-05-07
 * Time:9:58
 */
public class ThreadInterrupt2 {

    /**
     * 使用interrupt终止
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //while (Thread.interrupted()){ //判断线程的终止状态哦
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        //e.printStackTrace();
                        System.out.println("终止状态" +
                                Thread.currentThread().isInterrupted());
                        break;
                    }
                    System.out.println("转账 ing");
                }
                System.out.println("终止线程");
            }
        });
        t1.start();

        Thread.sleep(310);
        System.out.println("有内鬼，停止交易");
        t1.interrupt();
    }
}
