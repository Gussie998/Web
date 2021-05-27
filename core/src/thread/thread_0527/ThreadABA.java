package thread.thread_0527;

import java.util.concurrent.atomic.AtomicReference;

/**
 * User:DELL
 * Date:2021-05-27
 * Time:19:49
 */
public class ThreadABA {
    private static AtomicReference money = new AtomicReference(100);

    public static void main(String[] args) throws InterruptedException {


        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                Boolean res=money.compareAndSet(100,0);
                System.out.println("-100-->"+res);
            }
        });
        t1.start();
        t1.join();


        Thread t3=new Thread(new Runnable() {
            @Override
            public void run() {
                Boolean res=money.compareAndSet(0,100);
                System.out.println("+100-->"+res);

            }
        });
        t3.start();
        t3.join();

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                Boolean res=money.compareAndSet(100,0);
                System.out.println("-100-->"+res);

            }
        });
        t2.start();


        //发生ABA问题
        //-100-->true
        //+100-->true
        //-100-->true

    }
}
