package thread.thread_0422;

/**
 * User:DELL
 * Date:2021-04-22
 * Time:21:24
 */
public class ThreadDemo1 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(60*60*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();

    }
}
