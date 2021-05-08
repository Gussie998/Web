package thread.thread_0425;

/**
 * User:DELL
 * Date:2021-04-25
 * Time:21:16
 */
public class ThreadPriority {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("name:"+Thread.currentThread().getName());
            }
        };

        //最小优先级1，最大优先级为10；默认是5，优先级取值越大则权重就越高

        for (int i = 0; i <10 ; i++) {
            Thread t1 = new Thread(runnable,"1");
            Thread t2 = new Thread(runnable,"10");
            Thread t3 = new Thread(runnable,"5");
            t1.setPriority(1);
            t2.setPriority(10);
            t1.start();
            t2.start();
            t3.start();
        }
    }


}
