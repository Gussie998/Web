package thread.thread_0425;

/**
 * User:DELL
 * Date:2021-04-25
 * Time:21:28
 */
public class ThreadDaemon {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //守护线程的设置必须要放在线程开始之前
//        t1.setDaemon(true);
        t1.start();
        System.out.println(t1.isDaemon());
    }

}
