package thread.thread_0428;

/**
 * User:DELL
 * Date:2021-04-28
 * Time:10:46
 */
public class ThreadInterrupt {
    public static boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!flag){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("转账 ing");
                }
                System.out.println("转账 stop");
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(310);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("有内鬼，终止交易");
                flag=true;
            }
        });
        t2.start();

        t1.join();
        t2.join();
    }
}
